package com.conurets.inventory.vo;

import java.io.Serializable;

/**
 * @author MSA
 */

public class BaseResponse<T> implements Serializable {
    private int code;
    private String value;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}