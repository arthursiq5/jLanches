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
public enum Icons {
    SELECIONADO_64("icons8-selecionado-64"),
    CANCELAR_64("icons8-cancelar-64"),
    USUARIO_CANCEL_64("icons8-usuário-masculino-cancel-64"),
    USUARIO_PLUS_64("icons8-usuário-masculino-plus-64");
    
    
    String path;
    
    private Icons(String path){
        this.path = path;
    }
    
    @Override
    public String toString(){
        return this.path;
    }
    
    public String getPath(){
        return this.path;
    }
}
