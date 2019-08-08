/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Zheng Ru
 */
public class PhoneValidationImpl implements ConstraintValidator<EmailValidation, String>{
    private final String phoneFormat="^[1]([3-9])[0-9]{9}$";

    @Override
    public void initialize(EmailValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        if(phone.matches(phoneFormat)){
            return true;
        }
        return false;
    }
}
