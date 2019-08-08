/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.zz.utils;

/**
 *
 * @author Zheng Ru
 */
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE})

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidationImpl.class)
@Documented
//reference to https://blog.csdn.net/neweastsun/article/details/78164055
public @interface EmailValidation {
    //maybe need change after
    String message () default "must be a valid Email form" +
            " found: ${validatedValue}";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}

