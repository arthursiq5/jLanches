/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.validators.testers;

import com.jlanches.src.helpers.ValidatorMessageHelper;
import com.jlanches.src.validators.BasicValidators;
import com.jlanches.src.validators.ObjectValidator;
import com.jlanches.src.validators.StringValidators;
import com.jlanches.src.validators.ValidationAnswers;

/**
 *
 * @author arthur
 */
public class PasswordValidator extends ObjectValidator {

    public static boolean confereSenha(String senha, String repeteSenha) {
        if (StringValidators.isEqual(senha, repeteSenha) == ValidationAnswers.FAIL) {
            return ValidatorMessageHelper.alert("As senhas precisam ser iguais");
        }
        if (BasicValidators.isEmpty(senha) == ValidationAnswers.FAIL) {
            return ValidatorMessageHelper.alert("O campo senha deve ser preenchido");
        }
        return true;
    }
}
