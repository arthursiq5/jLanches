/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.validators.testers;

import com.jlanches.src.helpers.ValidatorMessageHelper;
import com.jlanches.src.model.Cliente;
import com.jlanches.src.validators.BasicValidators;
import com.jlanches.src.validators.CpfCnpjUtils;
import com.jlanches.src.validators.ObjectValidator;
import com.jlanches.src.validators.ValidationAnswers;

/**
 *
 * @author arthur
 */
public class ClienteValidator extends ObjectValidator {
    public static boolean insert(Cliente cliente){
        if(CpfCnpjUtils.isValidCPF(cliente.cpf) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertCPF();
        if(BasicValidators.isEmpty(cliente.nome) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertEmptyCamp("nome");
        if(BasicValidators.isTooLong(cliente.nome, 255) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertGiantCamp("nome", 255);
        if(BasicValidators.isZeroOrNegative(cliente.cidade_id) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertCombo("cidade");
        if(BasicValidators.isZeroOrNegative(cliente.contato_id) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertCombo("contato");
        
        return true;
    }
    
    public static boolean update(Cliente cliente){
        return ClienteValidator.insert(cliente);
    }
}
