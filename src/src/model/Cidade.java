/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model;

/**
 *
 * @author arthur
 */
public class Cidade {
    public int id;
    public String nome;
    public int estado_id;
    
    @Override
    public String toString(){
        return this.nome;
    }
}
