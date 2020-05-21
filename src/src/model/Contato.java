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
public class Contato {
    public int id;
    public String fone;
    public String email;
    
    public Contato(){
        this.id = 0;
        this.fone = "";
        this.email = "";
    }
    
    public Contato(int id, String email, String fone){
        this.id = id;
        this.fone = fone;
        this.email = email;
    }
    
    public String toString(){
        if(this.email.length() != 0 && this.fone.length() != 0){
            return "Email: " + this.email + " | Fone: " + this.fone;
        }else if(this.email.length() != 0){
            return "Email: " + this.email;
        }else if(this.fone.length() != 0){
            return "Fone: " + this.fone;
        }else{
            return "Este contato está vazio";
        }
    }
}
