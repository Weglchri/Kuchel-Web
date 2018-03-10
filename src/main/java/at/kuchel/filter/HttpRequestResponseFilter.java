package at.kuchel.filter;

import org.apache.commons.io.output.TeeOutputStream;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;
import java.util.StringTokenizer;

@Component
public class HttpRequestResponseFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger("httplogger");

    //todo refactore later to read from application properties
    private boolean jsonLogging = true;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = castToHttpServletRequest(request);
        HttpServletResponse httpServletResponse = castToHttpServletResponseHttpServletResponse(response);

        //todo change when controller for rest exists
        if (httpServletRequest.getServletPath().contains("/restschnittstelle")) {
            if (LOG.isDebugEnabled()) {
                BufferedRequestWrapper bufferedRequest = new BufferedRequestWrapper(httpServletRequest);
                BufferedResponseWrapper bufferedResponse = new BufferedResponseWrapper(httpServletResponse);

                chain.doFilter(bufferedRequest, bufferedResponse);

                JSONObject json = null;

                final StringBuilder logMessage = new StringBuilder("REST Request from user ")

                        .append(getUsername(httpServletRequest))
                        .append(" - ")

                        .append("\n[REQUEST HTTP METHOD:")
                        .append(httpServletRequest.getMethod())
                        .append("]\n[REQUEST URI:")
                        .append(httpServletRequest.getRequestURI())
                        .append("]\n[REQUEST BODY:");

                if (jsonLogging) {

                    if (!bufferedRequest.getRequestBody().isEmpty() && bufferedRequest.getRequestBody().charAt(0) == '[') {
                        JSONArray jsonarray = new JSONArray(bufferedRequest.getRequestBody());
                        for (int i = 0; i < jsonarray.length(); i++) {
                            JSONObject jsonobject = jsonarray.getJSONObject(i);
                            logMessage.append(jsonobject.toString(4));
                        }

                    } else if (!bufferedRequest.getRequestBody().isEmpty() && bufferedRequest.getRequestBody().charAt(0) == '{') {
                        json = new JSONObject(bufferedRequest.getRequestBody());
                        logMessage.append(json.toString(4) + "]\n");
                    }
                } else logMessage.append(bufferedRequest.getRequestBody()).toString();

                logMessage.append("[RESPONSE STATUS:").append(bufferedResponse.getStatus()).append("]\n").append("[RESPONSE OBJECT:\n");

                if (jsonLogging) {
                    if (!bufferedResponse.getContent().isEmpty() && bufferedResponse.getContent().charAt(0) == '[') {
                        JSONArray jsonarray = new JSONArray(bufferedResponse.getContent());
                        for (int i = 0; i < jsonarray.length(); i++) {
                            JSONObject jsonobject = jsonarray.getJSONObject(i);
                            logMessage.append(jsonobject.toString(4));
                        }
                    } else if (!bufferedResponse.getContent().isEmpty() && !isValidFileResponse(bufferedResponse)) {
                        logMessage.append(new JSONObject(bufferedResponse.getContent()).toString(4));
                    }
                } else logMessage.append(bufferedResponse.getContent()).toString();

                logMessage.append("]");
                LOG.debug(logMessage.toString());
            } else {
                LOG.info(httpServletRequest.getServletPath());
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    private boolean isValidFileResponse(BufferedResponseWrapper bufferedResponse) {
        String contentDisposition = bufferedResponse.getHeader("Content-Disposition");
        String contentType = bufferedResponse.getContentType();
        if (StringUtils.isNotEmpty(contentDisposition) && contentDisposition.contains("attachment; filename=")
                && contentType.contains("application/vnd.ms-excel")) {
            return true;
        }
        return false;
    }

    private HttpServletRequest castToHttpServletRequest(ServletRequest request) {
        if (request instanceof HttpServletRequest) {
            return (HttpServletRequest) request;
        }
        throw new RuntimeException("tried to cast request to httpservlet");
    }

    private HttpServletResponse castToHttpServletResponseHttpServletResponse(ServletResponse request) {
        if (request instanceof HttpServletResponse) {
            return (HttpServletResponse) request;
        }
        throw new RuntimeException("tried to cast response to httpservlet");
    }

    @Override
    public void destroy() {
    }


    private static final class BufferedRequestWrapper extends HttpServletRequestWrapper {

        private ByteArrayInputStream bais = null;
        private ByteArrayOutputStream baos = null;
        private BufferedServletInputStream bsis = null;
        private byte[] buffer = null;


        public BufferedRequestWrapper(HttpServletRequest req) throws IOException {
            super(req);
            // Read InputStream and store its content in a buffer.
            InputStream is = req.getInputStream();
            this.baos = new ByteArrayOutputStream();
            byte buf[] = new byte[1024];
            int letti;
            while ((letti = is.read(buf)) > 0) {
                this.baos.write(buf, 0, letti);
            }
            this.buffer = this.baos.toByteArray();
        }


        @Override
        public ServletInputStream getInputStream() {
            this.bais = new ByteArrayInputStream(this.buffer);
            this.bsis = new BufferedServletInputStream(this.bais);
            return this.bsis;
        }


        String getRequestBody() throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.getInputStream()));
            String line = null;
            StringBuilder inputBuffer = new StringBuilder();
            do {
                line = reader.readLine();
                if (null != line) {
                    inputBuffer.append(line.trim());
                }
            } while (line != null);
            reader.close();
            return inputBuffer.toString().trim();
        }

    }

    private static final class BufferedServletInputStream extends ServletInputStream {

        private ByteArrayInputStream bais;

        public BufferedServletInputStream(ByteArrayInputStream bais) {
            this.bais = bais;
        }

        @Override
        public int available() {
            return this.bais.available();
        }

        @Override
        public int read() {
            return this.bais.read();
        }

        @Override
        public int read(byte[] buf, int off, int len) {
            return this.bais.read(buf, off, len);
        }


        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setReadListener(ReadListener readListener) {

        }
    }

    public class TeeServletOutputStream extends ServletOutputStream {

        private final TeeOutputStream targetStream;

        public TeeServletOutputStream(OutputStream one, OutputStream two) {
            targetStream = new TeeOutputStream(one, two);
        }

        @Override
        public void write(int arg0) throws IOException {
            this.targetStream.write(arg0);
        }

        public void flush() throws IOException {
            super.flush();
            this.targetStream.flush();
        }

        public void close() throws IOException {
            super.close();
            this.targetStream.close();
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setWriteListener(WriteListener writeListener) {

        }
    }

    public class BufferedResponseWrapper extends HttpServletResponseWrapper {
        private HttpServletResponse original;
        private TeeServletOutputStream tee;
        private ByteArrayOutputStream bos;

        public BufferedResponseWrapper(HttpServletResponse response) {
            super(response);
            original = response;
            bos = new ByteArrayOutputStream();
        }

        public ServletOutputStream getOutputStream() throws IOException {
            if (tee == null) {
                tee = new TeeServletOutputStream(original.getOutputStream(), bos);
            }
            return tee;

        }

        public String getContent() {

            try {
                return bos.toString(getCharacterEncoding());
            } catch (UnsupportedEncodingException e) {
                LOG.warn("Cannot encode body with charset {}: {}", getCharacterEncoding(), e.getMessage());
                return bos.toString();
            }
        }

    }

    private String getUsername(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            StringTokenizer st = new StringTokenizer(authHeader);
            if (st.hasMoreTokens()) {
                String basic = st.nextToken();

                if (basic.equalsIgnoreCase("Basic")) {
                    try {
                        String credentials = new String(Base64.decodeBase64(st.nextToken()), "UTF-8");
                        int indexOfSeparator = credentials.indexOf(":");
                        if (indexOfSeparator != -1) {
                            return credentials.substring(0, indexOfSeparator).trim();
                        }
                    } catch (UnsupportedEncodingException e) {
                        LOG.debug("Couldn't retrieve authentication");
                    }
                }
            }
        }
        return StringUtils.EMPTY;
    }
}
