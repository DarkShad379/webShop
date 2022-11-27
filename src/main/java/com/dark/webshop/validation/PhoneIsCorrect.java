package com.dark.webshop.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = PhoneIsCorrectValidator.class)
public @interface PhoneIsCorrect {
    String message() default "Неверный номер";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}