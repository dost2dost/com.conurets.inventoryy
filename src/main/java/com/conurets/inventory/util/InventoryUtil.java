package com.conurets.inventory.util;

import com.conurets.inventory.bean.ErrorResponse;
import com.conurets.inventory.vo.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.sql.Timestamp;
import java.util.stream.Collectors;

/**
 * @author MSA
 */

public class InventoryUtil {
    private static final Logger logger = LoggerFactory.getLogger(InventoryUtil.class);

    public static Timestamp currentDateTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static int stringToInteger(String input) {
        int parseValue = InventoryConstants.INT_ZERO;
        try {
            parseValue = Integer.parseInt(input);
        } catch (Exception e) {
            parseValue = InventoryConstants.INT_ZERO;
        }
        return parseValue;
    }

    public static long stringToLong(String input) {
        long parseValue = InventoryConstants.INT_ZERO;
        try {
            parseValue = Long.parseLong(input);
        } catch (Exception e) {
            parseValue = InventoryConstants.INT_ZERO;
        }
        return parseValue;
    }

    public static double stringToDouble(String input) {
        double parseValue = InventoryConstants.INT_ZERO;
        try {
            parseValue = Double.parseDouble(input);
        } catch (Exception e) {
            parseValue = InventoryConstants.INT_ZERO;
        }
        return parseValue;
    }

    public static double longToDouble(long input) {
        double parseValue = InventoryConstants.INT_ZERO;
        try {
            parseValue = input;
        } catch (Exception e) {
            parseValue = InventoryConstants.INT_ZERO;
        }
        return parseValue;
    }

    public static final long getLongDateTime() {
        return System.currentTimeMillis();
    }

    public static final Timestamp getCurrentTimestamp() {
        return new Timestamp(getLongDateTime());
    }

    public static final Timestamp isObjectNull(Timestamp input) {
        return input == null ? null : input;
    }

    public static final String isObjectNull(String input) {
        return input == null ? InventoryConstants.SC_EMPTY : input;
    }

    public static final String nullObjectZero(String input) {
        return input == null ? InventoryConstants.STRING_ZERO : input;
    }

    public static final long isObjectNull(Long input) {
        return input == null ? InventoryConstants.LONG_ZERO : input;
    }

    public static final String isObjectEmpty(String input) {
        return input == null ? InventoryConstants.SC_EMPTY : input;
    }

    public static final boolean isStringEmpty(String input) {
        return InventoryConstants.SC_EMPTY.equals(input) ? Boolean.TRUE : Boolean.FALSE;
    }

    public static final boolean isStringEmptyOrNull(String input) {
        return (InventoryConstants.SC_EMPTY.equals(input) || input == null) ? Boolean.TRUE : Boolean.FALSE;
    }

    public static BaseResponse<Object> setBaseResponse(int code, String value) {
        BaseResponse<Object> baseResponse = new BaseResponse<Object>();
        baseResponse.setCode(code);
        baseResponse.setValue(value);

        return baseResponse;
    }

    public static BaseResponse<Object> setBaseResponse(int code, String value, Object data) {
        BaseResponse<Object> baseResponse = new BaseResponse<Object>();
        baseResponse.setCode(code);
        baseResponse.setValue(value);
        baseResponse.setData(data);

        return baseResponse;
    }

    public static ErrorResponse<Object> setErrorResponse(int code, String value) {
        ErrorResponse<Object> response = new ErrorResponse<Object>();
        response.setCode(code);
        response.setValue(value);

        return response;
    }

    public static ErrorResponse<Object> setErrorResponse(int code, BindingResult value) {
        ErrorResponse<Object> response = new ErrorResponse<Object>();
        response.setCode(code);
        response.setValue(value.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList()));

        return response;
    }
}