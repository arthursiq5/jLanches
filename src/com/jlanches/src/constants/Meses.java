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
public enum Meses {
    JANEIRO("Janeiro", 0, 31),
    FEVEREIRO("Fevereiro", 1, 28),
    MARCO("Março", 2, 31),
    ABRIL("Abril", 3, 30),
    MAIO("Maio", 4, 31),
    JUNHO("Junho", 5, 30),
    JULHO("Julho", 6, 31),
    AGOSTO("Agosto", 7, 31),
    SETEMBRO("Setembro", 8, 30),
    OUTUBRO("Outubro", 9, 31),
    NOVEMBRO("Novembro", 10, 30),
    DEZEMBRO("Dezembro", 11, 31);
    
    private final String nome;
    private final int gregorianMonth;
    private final int quantidadeDeDias;
    
    private Meses(String nome, int gregorianMonth, int quantidadeDeDias){
        this.nome = nome;
        this.gregorianMonth = gregorianMonth;
        this.quantidadeDeDias = quantidadeDeDias;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
    
    public int getQuantidadeDeDias(){
        return this.quantidadeDeDias;
    }
    
    public String getMonth(){
        String month = (this.gregorianMonth + 1) + "";
        if(month.length() == 1)
            month = "0" + month;
        return month;
    }
    
    public int getGregorianMonth(){
        return this.gregorianMonth;
    }
}
