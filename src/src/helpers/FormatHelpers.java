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
        boolean isNumeric;
        try {
	    double aux = (Double.parseDouble(value));
            isNumeric = true;
	} catch (NumberFormatException e) {	  
            isNumeric = false;
	}

        return isNumeric;
    }
    
    public static void main(String[] args) {
        System.out.println("Testes com isNumeric");
        System.out.println("------------\\\\\\------------");
        System.out.println("\"15\" is number: " + FormatHelpers.isNumeric("15"));
        System.out.println("\"\" is number: " + FormatHelpers.isNumeric(""));
        System.out.println("\"4b5\" is number: " + FormatHelpers.isNumeric("4b5"));
        System.out.println("\"ãÃç\" is number: " + FormatHelpers.isNumeric("ãÃç"));
        System.out.println("\"0,01\" is number: " + FormatHelpers.isNumeric("0,01"));
        System.out.println("\"0.01\" is number: " + FormatHelpers.isNumeric("0.01"));
    }
}
