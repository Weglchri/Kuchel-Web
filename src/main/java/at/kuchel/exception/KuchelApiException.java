package at.kuchel.exception;
public class KuchelApiException extends RuntimeException {

    final KuchelErrorCode errorCode;
    final Object[] arguments;

    public KuchelApiException(final KuchelErrorCode errorCode, final Object... arguments)
            throws IllegalArgumentException {
        super(errorCode.getMessage(arguments));
        this.errorCode = errorCode;
        this.arguments = arguments;
    }

    public KuchelApiException(KuchelException ex) {
        this.arguments= ex.getArguments();
        this.errorCode= ex.getErrorCode();
    }

    public KuchelErrorCode getErrorCode() {
        return errorCode;
    }

    public Object[] getArguments() {
        return arguments;
    }


}
