/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.constants;

/**
 *
 * @author arthur
 */
public enum FormaDePagamento {
    
    A_VISTA("A VISTA"),
    CARTAO_DE_CREDITO("CARTÃO DE CRÉDITO"),
    CARTAO_DE_DEBITO("CARTÃO DE DÉBITO"),
    CHEQUE("CHEQUE");
    
    private String nome;
    
    private FormaDePagamento(String nome){
        this.nome = nome;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
}
