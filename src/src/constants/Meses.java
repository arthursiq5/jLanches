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
public enum Meses {
    JANEIRO("Janeiro", 31),
    FEVEREIRO("Fevereiro", 28),
    MARCO("Março", 31),
    ABRIL("Abril", 30),
    MAIO("Maio", 31),
    JUNHO("Junho", 30),
    JULHO("Julho", 31),
    AGOSTO("Agosto", 31),
    SETEMBRO("Setembro", 30),
    OUTUBRO("Outubro", 31),
    NOVEMBRO("Novembro", 30),
    DEZEMBRO("Dezembro", 31);
    
    private final String nome;
    private final int quantidadeDeDias;
    
    private Meses(String nome, int quantidadeDeDias){
        this.nome = nome;
        this.quantidadeDeDias = quantidadeDeDias;
    }
    
    public String toString(){
        return this.nome;
    }
    
    public int getQuantidadeDeDias(){
        return this.quantidadeDeDias;
    }
}
