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
public class EmailValidationImpl implements ConstraintValidator<EmailValidation, String>{
    //reference to https://www.cnblogs.com/lst619247/p/9289719.html
    private final String emailFormat="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    @Override
    public void initialize(EmailValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if(email.matches(emailFormat)){
            return true;
        }
        return false;
    }
}
