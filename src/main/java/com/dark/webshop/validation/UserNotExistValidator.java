package com.dark.webshop.validation;

import com.dark.webshop.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNotExistValidator implements ConstraintValidator<UserNotExist, String> {
    @Override
    public void initialize(UserNotExist constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    private final UserService userService;

    public UserNotExistValidator(com.dark.webshop.service.UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userService.userExist(s.toLowerCase());
    }
}
