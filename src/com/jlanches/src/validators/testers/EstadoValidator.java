/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.validators.testers;

import com.jlanches.src.helpers.MessageHelper;
import com.jlanches.src.model.Estado;
import com.jlanches.src.validators.BasicValidators;
import com.jlanches.src.validators.ObjectValidator;
import com.jlanches.src.validators.ValidationAnswers;

/**
 *
 * @author arthur
 */
public abstract class EstadoValidator extends ObjectValidator {

    public static boolean insert(Estado estado) {
        boolean answer = false;

        if (BasicValidators.isEmpty(estado.nome) == ValidationAnswers.FAIL) {
            MessageHelper.createInfoMessage("Aviso", "Campo nome não foi preenchido");
        } else if (BasicValidators.isTooLong(estado.nome, 255) == ValidationAnswers.FAIL) {
            MessageHelper.createInfoMessage("Aviso", "Campo nome possui mais que 255 caracteres. Por favor, reduza o tamanho");
        } else if (BasicValidators.hasIncorrectLength(estado.sigla, 2) == ValidationAnswers.FAIL) {
            MessageHelper.createInfoMessage("Aviso", "O campo sigla deve possuir exatamente dois caracteres");
        } else {
            answer = true;
        }

        return answer;
    }

    public static boolean update(Estado estado) {
        boolean answer = EstadoValidator.insert(estado);

        if (answer) {
            if (BasicValidators.isEmpty(estado.id + "") == ValidationAnswers.FAIL
                    && BasicValidators.isZeroOrNegative(estado.id) == ValidationAnswers.FAIL) {
                MessageHelper.createInfoMessage("Aviso", "Não é possível atualizar com um campo nulo ou negativo");
                answer = false;
            }
        }

        return answer;

    }
}
