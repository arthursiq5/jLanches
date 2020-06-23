/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.constants.media;

import com.jlanches.src.constants.MediaExtensions;
import com.jlanches.src.constants.Paths;

/**
 *
 * @author arthur
 */
public enum MainIcons {
    TELA_PRINCIPAL("jlanches-icone");
    
    private String path;
    
    private MainIcons(String path){
        this.path = path;
    }
    
    @Override
    public String toString(){
        return this.path;
    }
    
    public String getPath(){
        return this.path;
    }
    
    public String getFullPath(){
        return Paths.ICONS + this.path + MediaExtensions.PNG;
    }
}
