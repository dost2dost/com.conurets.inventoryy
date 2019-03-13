package com.conurets.inventory.util.validation.annotation;

import com.conurets.inventory.util.validation.InventoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author MSA
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Constraint(validatedBy = InventoryValidator.class)
public @interface InventoryNotNull {
    String message() default "Object cannot be null";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}