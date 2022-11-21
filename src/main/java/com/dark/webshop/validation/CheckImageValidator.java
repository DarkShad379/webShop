package com.dark.webshop.validation;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckImageValidator implements ConstraintValidator<CheckImage, MultipartFile> {
    @Override
    public void initialize(CheckImage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext constraintValidatorContext) {
        return !file.isEmpty();
    }
}
