package com.conurets.inventory.exception;

/**
 * @author MSA
 */

public class InvalidSessionException extends RuntimeException {
    protected int position;

    public InvalidSessionException(String message) {
        super(message);
    }

    public InvalidSessionException(int position, String message) {
        super(message);
        this.position = position;
    }

    public InvalidSessionException(int position, String message, Throwable cause) {
        super(message, cause);
        this.position = position;
    }

    public final int getPosition() {
        return this.position;
    }

    public String getMessage() {
        return super.getMessage();
    }
}