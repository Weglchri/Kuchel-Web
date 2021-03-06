package at.kuchel.exception;
public class KuchelException extends RuntimeException {

    final KuchelErrorCode errorCode;
    final Object[] arguments;

    public KuchelException(final KuchelErrorCode errorCode, final Object... arguments)
            throws IllegalArgumentException {
        super(errorCode.getMessage(arguments));
        this.errorCode = errorCode;
        this.arguments = arguments;
    }

    public KuchelErrorCode getErrorCode() {
        return errorCode;
    }

    public Object[] getArguments() {
        return arguments;
    }


}
