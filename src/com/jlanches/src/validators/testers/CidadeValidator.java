/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.validators.testers;

import com.jlanches.src.helpers.MessageHelper;
import com.jlanches.src.model.Cidade;
import com.jlanches.src.validators.BasicValidators;
import com.jlanches.src.validators.ObjectValidator;
import com.jlanches.src.validators.ValidationAnswers;

/**
 *
 * @author arthur
 */
public class CidadeValidator extends ObjectValidator {

    public static boolean insert(Cidade cidade) {
        boolean answer = false;

        if (BasicValidators.isEmpty(cidade.nome) == ValidationAnswers.FAIL) {
            MessageHelper.createInfoMessage("Aviso", "Campo nome não foi preenchido");
        } else if (BasicValidators.isTooLong(cidade.nome, 255) == ValidationAnswers.FAIL) {
            MessageHelper.createInfoMessage("Aviso", "Campo nome possui mais que 255 caracteres. Por favor, reduza o tamanho");
        } else if (BasicValidators.isZeroOrNegative(cidade.estado_id) == ValidationAnswers.FAIL) {
            MessageHelper.createInfoMessage("Aviso", "Não foi selecionado um estado");
        } else {
            answer = true;
        }

        return answer;
    }

    public static boolean update(Cidade cidade) {
        boolean answer = CidadeValidator.insert(cidade);

        if (answer) {
            if (BasicValidators.isEmpty(cidade.id + "") == ValidationAnswers.FAIL
                    && BasicValidators.isZeroOrNegative(cidade.id) == ValidationAnswers.FAIL) {
                MessageHelper.createInfoMessage("Aviso", "Não é possível atualizar com um campo nulo ou negativo");
                answer = false;
            }
        }

        return answer;

    }
}
