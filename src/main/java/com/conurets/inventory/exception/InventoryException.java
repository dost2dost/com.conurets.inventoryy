package com.conurets.inventory.exception;

/**
 * @author MSA
 */

public class InventoryException extends RuntimeException {
    protected int position;

    public InventoryException(String message) {
        super(message);
    }

    public InventoryException(int position, String message) {
        super(message);
        this.position = position;
    }

    public InventoryException(int position, String message, Throwable cause) {
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