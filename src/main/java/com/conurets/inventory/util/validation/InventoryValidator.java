package com.conurets.inventory.util.validation;

import com.conurets.inventory.util.validation.annotation.InventoryNotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author MSA
 */

public class InventoryValidator implements ConstraintValidator<InventoryNotNull, Object> {
    /**
     * Checking null object
     * @param value
     * @param context
     * @return boolean
     */

    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return value == null ? Boolean.FALSE : Boolean.TRUE;
    }
}