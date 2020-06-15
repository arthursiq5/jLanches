/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.helpers;

/**
 *
 * @author arthur
 */
public class FormatHelpers {
    public static boolean isNumeric(String value){
        return !value.trim().equals("") 
             || !value.contains("^[a-Z]") 
             || !value.contains("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")
             || !value.trim().equals(".")
             || !value.trim().equals(",");
    }
}
