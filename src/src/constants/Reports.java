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
public enum Reports {
    EXEMPLO("Exemplo.jrxml");
    
    private final String name;
    
    private Reports(String name){
        this.name = name;
    }
    
    public String toString(){
        return this.name;
    }
}
