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
public class Categoria {
    public int id;
    public String nome;
    public boolean ativo;
    
    @Override
    public String toString(){
        return this.nome;
    }
}
