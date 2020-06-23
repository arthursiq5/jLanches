/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.model;

/**
 *
 * @author arthur
 */
public class Lanche {
    public int id;
    public String nome;
    public String ingredientes;
    public String valor;
    public boolean disponivel;
    public int categoria_id;
    
    @Override
    public String toString(){
        return this.nome;
    }
}
