/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.helpers;

import java.util.Arrays;

/**
 *
 * @author arthur
 */
public class ConvertCoinHelper {
    private static enum Length{
        INTEGER_LENGTH(3),
        FRACTION_LENGTH(2);
        
        private final int length;
        
        private Length(int length){
            this.length = length;
        }
        
        public int getLength(){
            return this.length;
        }
    }
    
    public static String convertAmericanToBrazilian(String value){
        if(!FormatHelpers.isNumeric(value))
            return "0,00";
        return (ConvertCoinHelper.convertAmericanToDouble(value) + "").replace(".", ",").replace(" ", "");
    }
    
    public static String convertBrazilianToAmerican(String value){
        if(!FormatHelpers.isNumeric(value.replace(",", ".").replace(" ", "")))
            return "0.00";
        return (ConvertCoinHelper.convertAmericanToDouble(value.replace(",", ".")) + "").replace(" ", "");
    }
    
    public static double convertAmericanToDouble(String value){
        return Double.parseDouble(value);
    }
    
    public static double convertBrazilianToDouble(String value){
        return ConvertCoinHelper.convertAmericanToDouble(
            ConvertCoinHelper.convertBrazilianToAmerican(value)
        );
    }
    
    private static String changeZeros(String value){
        String [] separatedValue = value.split("\\.");

        if(separatedValue.length == 0)
            return "000.00";

        if(separatedValue.length == 1 && value.equals(separatedValue[0]+ "."))
            return value + "00";
        
        if(separatedValue.length == 1 && value.equals("." + separatedValue[0]))
            return "000" + value;
        
        return ConvertCoinHelper.getZeroQuantity(
                    ConvertCoinHelper.Length.INTEGER_LENGTH.getLength() - separatedValue[0].length())
            +  separatedValue[0]
            +  "."
            +  separatedValue[1]
            +  ConvertCoinHelper.getZeroQuantity(
                    ConvertCoinHelper.Length.FRACTION_LENGTH.getLength() - separatedValue[1].length());
    }
    
    private static String getZeroQuantity(int quantity){
        if(quantity > 0)
            return "0" + ConvertCoinHelper.getZeroQuantity(quantity -1);
        return "";
    }
    
    public static void main(String[] args) {
        // testes
        System.out.println("R$ 14.5 convertido: " + ConvertCoinHelper.convertAmericanToBrazilian("14.5"));
        System.out.println("R$ 14. convertido: "  + ConvertCoinHelper.convertAmericanToBrazilian("14."));
        System.out.println("R$ .5 convertido: "   + ConvertCoinHelper.convertAmericanToBrazilian(".5"));
        System.out.println("R$ . convertido: "  + ConvertCoinHelper.convertAmericanToBrazilian("."));
        
        System.out.println("R$ 14,5 convertido: " + ConvertCoinHelper.convertBrazilianToAmerican("14,5"));
        System.out.println("R$ 14, convertido: "  + ConvertCoinHelper.convertBrazilianToAmerican("14,"));
        System.out.println("R$ ,5 convertido: "   + ConvertCoinHelper.convertBrazilianToAmerican(",5"));
        System.out.println("R$ , convertido: "  + ConvertCoinHelper.convertBrazilianToAmerican(","));
    }
}
