/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.validators;

/**
 *
 * @author arthur
 */
public abstract class BasicValidators {

    public static ValidationAnswers isEmpty(String message) {
        if ("".equals(message)) {
            return ValidationAnswers.FAIL;
        }
        return ValidationAnswers.PASS;
    }

    public static ValidationAnswers isTooLong(String message, int maxLength) {
        if (message.length() > maxLength) {
            return ValidationAnswers.FAIL;
        }
        return ValidationAnswers.PASS;
    }

    public static ValidationAnswers isTooShort(String message, int minLength) {
        if (message.length() < minLength) {
            return ValidationAnswers.FAIL;
        }
        return ValidationAnswers.PASS;
    }

    public static ValidationAnswers hasIncorrectLength(String message, int maxLength) {
        if (message.length() == maxLength) {
            return ValidationAnswers.PASS;
        }
        return ValidationAnswers.FAIL;
    }

    public static ValidationAnswers isZeroOrNegative(int number) {
        if (number <= 0) {
            return ValidationAnswers.FAIL;
        }
        return ValidationAnswers.PASS;
    }
}
