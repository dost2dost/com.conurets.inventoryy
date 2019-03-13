package com.conurets.inventory.bean;

/**
 * @author MSA
 */

public class ErrorResponse<T> {
    private int code;
    private T value;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}