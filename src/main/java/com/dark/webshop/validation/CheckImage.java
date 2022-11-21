package com.dark.webshop.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckImageValidator.class)
public @interface CheckImage {
    public String message() default "Image must not be null";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
