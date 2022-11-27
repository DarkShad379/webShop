package com.dark.webshop.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneIsCorrectValidator implements ConstraintValidator<PhoneIsCorrect, String> {
    private Pattern pattern;
    private Matcher matcher;
    private static final String PhonePattern = "^[0-9\\-\\+]{11}$";

    @Override
    public void initialize(PhoneIsCorrect constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        return (validatePhone(phone));
    }

    private boolean validatePhone(String phoneNumber) {
        pattern = Pattern.compile(PhonePattern);
        matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
