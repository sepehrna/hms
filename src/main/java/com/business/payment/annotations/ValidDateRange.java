package com.business.payment.annotations;

import com.business.payment.validators.DateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface ValidDateRange {
    String message() default "Check-out date must be after the check-in date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
