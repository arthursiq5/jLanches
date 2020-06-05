/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.validators.testers;

import src.helpers.ValidatorMessageHelper;
import src.model.Lanche;
import src.validators.BasicValidators;
import src.validators.ValidationAnswers;

/**
 *
 * @author arthur
 */
public class LancheValidator {
    public static boolean insert(Lanche lanche){
        if(BasicValidators.isZeroOrNegative(lanche.categoria_id) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertCombo("categoria");
        if(BasicValidators.isTooShort(lanche.nome, 3) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertShortCamp("nome", 3);
        if(BasicValidators.isTooLong(lanche.nome, 255) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertGiantCamp("nome", 255);
        
        return true;
    }
    
    public static boolean update(Lanche lanche){
        if(BasicValidators.isZeroOrNegative(lanche.id) == ValidationAnswers.FAIL)
                return ValidatorMessageHelper.alertID();
        return (LancheValidator.insert(lanche));
    }
}
