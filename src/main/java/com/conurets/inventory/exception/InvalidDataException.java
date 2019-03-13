package com.conurets.inventory.exception;

/**
 * @author MSA
 */

public class InvalidDataException extends RuntimeException {
    protected int position;

    public InvalidDataException(String message) {
        super(message);
    }

    public InvalidDataException(int position, String message) {
        super(message);
        this.position = position;
    }

    public InvalidDataException(int position, String message, Throwable cause) {
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