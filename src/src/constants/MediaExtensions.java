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
public enum MediaExtensions {
    PNG(".png");
    
    String extension;
    
    private MediaExtensions(String extension){
        this.extension = extension;
    }
    
    public String getExtension(){
        return this.extension;
    }
    
    @Override
    public String toString(){
        return this.extension;
    }
}