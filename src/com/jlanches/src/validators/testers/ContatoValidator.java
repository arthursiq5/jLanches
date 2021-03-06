/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.validators.testers;

import com.jlanches.src.helpers.MessageHelper;
import com.jlanches.src.model.Contato;
import com.jlanches.src.validators.BasicValidators;
import com.jlanches.src.validators.ObjectValidator;
import com.jlanches.src.validators.ValidationAnswers;

/**
 *
 * @author arthur
 */
public class ContatoValidator extends ObjectValidator {

    public static boolean insert(Contato contato) {

        if (BasicValidators.isEmpty(contato.email) == ValidationAnswers.PASS
                && BasicValidators.isEmpty(contato.fone) == ValidationAnswers.PASS) {
            return true;
        }
        MessageHelper.createInfoMessage("Aviso", "Ao menos uma das opções de contato deve ser selecionada");
        return false;

    }

    public static boolean update(Contato contato) {
        boolean answer = ContatoValidator.insert(contato);

        if (answer && BasicValidators.isZeroOrNegative(contato.id) == ValidationAnswers.PASS) {
            return true;
        }
        MessageHelper.createInfoMessage("Aviso", "Não é possível atualizar sem o ID inserido");
        return false;
    }
}
