package at.kuchel.exception;

import org.springframework.http.HttpStatus;

public enum KuchelErrorCode {

    RECIPE_NOT_FOUND(HttpStatus.NO_CONTENT, "Error while loading recipe");

    private final String message;
    private final HttpStatus httpStatus;

    private KuchelErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
