package at.kuchel.exception;

public enum KuchelErrorCode {

    RECIPE_NOT_FOUND("Error while loading recipe");

    private final String message;

    private KuchelErrorCode(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
