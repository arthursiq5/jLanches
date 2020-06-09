/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.validators.testers;

import src.helpers.ValidatorMessageHelper;
import src.model.Funcionario;
import src.validators.BasicValidators;
import src.validators.CpfCnpjUtils;
import src.validators.ObjectValidator;
import src.validators.ValidationAnswers;

/**
 *
 * @author arthur
 */
public class FuncionarioValidator extends ObjectValidator {
    public static boolean insert(Funcionario funcionario){
        if(CpfCnpjUtils.isValidCPF(funcionario.cpf) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertCPF();
        if(BasicValidators.isEmpty(funcionario.nome) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertEmptyCamp("nome");
        if(BasicValidators.isTooLong(funcionario.nome, 255) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertGiantCamp("nome", 255);
        if(BasicValidators.isZeroOrNegative(funcionario.cidade_id) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertCombo("cidade");
        if(BasicValidators.isZeroOrNegative(funcionario.contato_id) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertCombo("contato");
        if(BasicValidators.isZeroOrNegative(funcionario.franquia_id) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertCombo("franquia");
        
        return true;
    }
    
    public static boolean update(Funcionario funcionario){
        return FuncionarioValidator.insert(funcionario);
    }
}
