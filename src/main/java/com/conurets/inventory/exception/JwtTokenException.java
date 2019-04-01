package com.conurets.inventory.exception;

/**
 * @author MSA
 */

public class JwtTokenException extends RuntimeException {
    protected int position;

    public JwtTokenException(String message) {
        super(message);
    }

    public JwtTokenException(int position, String message) {
        super(message);
        this.position = position;
    }

    public JwtTokenException(int position, String message, Throwable cause) {
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