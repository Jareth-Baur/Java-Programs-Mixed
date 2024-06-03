package Exceptions;

public class AgeLessThanZeroException extends Exception {
    AgeLessThanZeroException() {
    }

    AgeLessThanZeroException(String message) {
        super(message);
    }

    AgeLessThanZeroException(Throwable cause) {
        super(cause);
    }

    AgeLessThanZeroException(String message, Throwable cause) {
        super(message, cause);
    }
}
