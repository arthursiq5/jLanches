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
public class Estado {
    public int id;
    public String sigla;
    public String nome;
    
    @Override
    public String toString(){
        return sigla;
    }
}
