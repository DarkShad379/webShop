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
@Constraint(validatedBy = UserNotExistValidator.class)
public @interface UserNotExist {
    String message() default "Пользователь с таким логином уже существует";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
