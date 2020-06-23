/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.validators.testers;

import com.jlanches.src.helpers.ValidatorMessageHelper;
import com.jlanches.src.model.Categoria;
import com.jlanches.src.validators.BasicValidators;
import com.jlanches.src.validators.ValidationAnswers;

/**
 *
 * @author arthur
 */
public abstract class CategoriaValidator {
    
    public static boolean insert(Categoria categoria){
        if(BasicValidators.isEmpty(categoria.nome) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertEmptyCamp("nome");
        if(BasicValidators.isTooLong(categoria.nome, 255) == ValidationAnswers.FAIL)
                return ValidatorMessageHelper.alertGiantCamp("nome", 255);
        if(BasicValidators.isTooShort(categoria.nome, 3) == ValidationAnswers.FAIL)
            return ValidatorMessageHelper.alertShortCamp("nome", 3);
        
        return true;
    }
    
    public static boolean update(Categoria categoria){
        if(CategoriaValidator.insert(categoria))
            if(BasicValidators.isEmpty(categoria.id + "") == ValidationAnswers.FAIL)
                return ValidatorMessageHelper.alertID();
        return true;
    }
}
