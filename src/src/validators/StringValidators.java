/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.validators;

/**
 *
 * @author arthur
 */
public abstract class StringValidators {
    public static ValidationAnswers isEqual(String senha, String repeteSenha){
        if(senha.endsWith(repeteSenha))
            return ValidationAnswers.PASS;
        return ValidationAnswers.FAIL;
    }
    
    public static ValidationAnswers hasNumber(String senha){
        if(senha.matches("[A-Z a-z Çç]{" + senha.length() + "}"))
            return ValidationAnswers.FAIL;
        return ValidationAnswers.PASS;
    }
}
