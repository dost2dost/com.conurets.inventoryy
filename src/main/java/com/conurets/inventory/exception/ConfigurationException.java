package com.conurets.inventory.exception;

/**
 * @author MSA
 */

public class ConfigurationException extends RuntimeException {
    protected int position;

    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(int position, String message) {
        super(message);
        this.position = position;
    }

    public ConfigurationException(int position, String message, Throwable cause) {
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