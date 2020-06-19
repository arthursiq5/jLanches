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
    EXEMPLO("Exemplo"),
    CIDADE_ESTADO("cidade_estado"),
    CIDADE_ESTADO_BY_ID("cidade_estado_by_id"),
    FUNCIONARIOS("funcionarios"),
    FUNCIONARIOS_ATIVOS("funcionarios_ativos");
    
    private final String name;
    
    private Reports(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return this.name + ".jrxml";
    }
}
