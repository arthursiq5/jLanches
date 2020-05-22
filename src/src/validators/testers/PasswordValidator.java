/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.validators.testers;

import src.helpers.ValidatorMessageHelper;
import src.validators.BasicValidators;
import src.validators.ObjectValidator;
import src.validators.StringValidators;
import src.validators.ValidationAnswers;

/**
 *
 * @author arthur
 */
public class PasswordValidator extends ObjectValidator {
    
    public static boolean confereSenha(String senha, String repeteSenha){
        if(StringValidators.isEqual(senha, repeteSenha) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alert("As senhas precisam ser iguais");
        if(BasicValidators.isEmpty(senha) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alert("O campo senha deve ser preenchido");
        return true;
    }
}
