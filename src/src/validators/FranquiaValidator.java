/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.validators;

import src.helpers.ValidatorMessageHelper;
import src.model.Franquia;

/**
 *
 * @author arthur
 */
public class FranquiaValidator {
    
    public static boolean insert(Franquia franquia){
        if(BasicValidators.isEmpty(franquia.endereco) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertEndereco();
        if(BasicValidators.isZeroOrNegative(franquia.cidade_id) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alert("cidade");
        
        return true;
    }
    
    public static boolean update(Franquia franquia){
        boolean answer = FranquiaValidator.insert(franquia);
        if(answer)
            if(BasicValidators.isZeroOrNegative(franquia.id) == ValidationAnswers.FAIL)
                answer = ValidatorMessageHelper.alertID();
        return answer;
    }
}
