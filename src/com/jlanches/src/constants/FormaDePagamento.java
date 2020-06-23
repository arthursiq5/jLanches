/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.constants;

/**
 *
 * @author arthur
 */
public enum FormaDePagamento {
    
    A_VISTA("A VISTA", Icons.CASH_PAYMENT_16, Icons.CASH_PAYMENT_64),
    CARTAO_DE_CREDITO("CARTÃO DE CRÉDITO", Icons.CREDIT_CARD_16, Icons.CREDIT_CARD_64),
    CARTAO_DE_DEBITO("CARTÃO DE DÉBITO", Icons.CREDIT_CARD_16, Icons.CREDIT_CARD_64),
    CHEQUE("CHEQUE", Icons.PAYMENT_CHECK_16, Icons.PAYMENT_CHECK_64);
    
    private String nome;
    private Icons icone16;
    private Icons icone64;
    
    private FormaDePagamento(String nome, Icons icone16, Icons icone64){
        this.nome = nome;
        this.icone16 = icone16;
        this.icone64 = icone64;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
    
    public Icons getIcon16(){
        return this.icone16;
    }
    
    public Icons getIcon64(){
        return this.icone64;
    }
}
