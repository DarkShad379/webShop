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
@Constraint(validatedBy = CheckImageValidator.class)
public @interface CheckImage {
    public String message() default "Image must not be null";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
