package com.conurets.inventory.exception;

/**
 * @author MSA
 */

public class EntityNotFoundException extends RuntimeException {
    protected int position;

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(int position, String message) {
        super(message);
        this.position = position;
    }

    public EntityNotFoundException(int position, String message, Throwable cause) {
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