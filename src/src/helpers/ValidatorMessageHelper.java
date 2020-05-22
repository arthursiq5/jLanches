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
public class ValidatorMessageHelper {
    public static boolean alert(String message){
        MessageHelper.createInfoMessage("Aviso", message);
        return false;
    }
    
    public static boolean alertCombo(String message){
        return ValidatorMessageHelper.alert("O campo "+message + " precisa ser selecionado");
    }
    
    public static boolean alertEndereco(){
        return ValidatorMessageHelper.alert("Por favor, selecione um endereço");
    }
    
    public static boolean alertID(){
        return ValidatorMessageHelper.alert("Para atualizar, é necessário um ID válido");
    }
    
    public static boolean alertCPF(){
        return ValidatorMessageHelper.alert("CPF inválido");
    }
}
