package at.kuchel.controller.global;

import at.kuchel.api.ErrorResponse;
import at.kuchel.exception.KuchelApiException;
import at.kuchel.exception.KuchelException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;

import static at.kuchel.Context.REST_API;

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(KuchelException.class)
    protected Object handleKuchelException(KuchelException klex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", klex);
        modelAndView.setViewName("error/kuchelerror");
        return modelAndView;
    }


    @ExceptionHandler(KuchelApiException.class)
    protected Object handleKuchelApiException(KuchelApiException klex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(new Date());
        errorResponse.setError(klex.getMessage());
        errorResponse.setStatus(50);

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(NoHandlerFoundException.class)
    public Object handleNotFoundException(final NoHandlerFoundException nhfex) {
        if(nhfex.getRequestURL().startsWith(REST_API)){
            return handleNotFoundRest(nhfex);
        }
     return handleNotFoundBrowser(nhfex);
    }

    private Object handleNotFoundRest(NoHandlerFoundException nhfex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(new Date());
        errorResponse.setError(nhfex.getMessage());
        errorResponse.setStatus(10);

        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Throwable.class)
    public Object handleGeneralException(final Throwable throwable) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("throwable", throwable);
        modelAndView.setViewName("error/generalerror");
        return modelAndView;
    }

    private ModelAndView handleNotFoundBrowser(NoHandlerFoundException nhfex){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", nhfex);
        modelAndView.setViewName("error/notfoundexception");
        return modelAndView;
    }
}
