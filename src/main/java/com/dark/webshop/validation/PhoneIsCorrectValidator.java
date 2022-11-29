package com.dark.webshop.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneIsCorrectValidator implements ConstraintValidator<PhoneIsCorrect, String> {
    private static final String phonePattern = "^[0-9\\-\\+]{11}$";

    @Override
    public void initialize(PhoneIsCorrect constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        return (validatePhone(phone));
    }

    private boolean validatePhone(String phoneNumber) {
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
