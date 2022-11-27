package com.dark.webshop.validation;

import com.dark.webshop.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNotExistValidator implements ConstraintValidator<UserNotExist, String> {
    @Override
    public void initialize(UserNotExist constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.findByUsername(s.toLowerCase()) == null;
    }
}
