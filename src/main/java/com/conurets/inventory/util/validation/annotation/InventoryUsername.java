package com.conurets.inventory.util.validation.annotation;

import com.conurets.inventory.util.validation.InventoryUsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author MSA
 * @version 1.0
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Constraint(validatedBy = InventoryUsernameValidator.class)
public @interface InventoryUsername {
    String message() default "Username should be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}