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
public class PasswordValidationImpl implements ConstraintValidator<PasswordValidation, String> {
    //reference to http://www.aijquery.cn/Html/jqueryjiqiao/200.html
    private final String emailFormat="^(?=.*[a-zA-Z])(?=.*[1-9])(?=.*[\\W]).{8,20}$";
    @Override
    public void initialize(PasswordValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if(password.matches(emailFormat)){
            return true;
        }
        return false;
    }
    
}
