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
public enum Paths {
    ICONS("/media/icons/"),
    REPORTS("/reports/");
    
    String path;
    
    private Paths(String path){
        this.path = path;
    }
    
    public String getPath(){
        return this.path;
    }
    
    @Override
    public String toString(){
        return this.path;
    }
}
