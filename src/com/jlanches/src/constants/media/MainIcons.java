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
    LANCHEIRA_PRINCIPAL("lunch-bag-coin"),
    LANCHEIRA_PADLOCK("lunch-bag-lock"),
    LANCHERIA_SEARCH("lunch-bag-search"),
    CHOCOLATE("chocolate"),
    HAMBURGER_CALENDAR("hamburger-calendar"),
    HAMBURGER_CONFIGURE("hamburger-configure"),
    HAMBURGER_LIKE("hamburger-like"),
    HAMBURGER_SEARCH("hamburger-search"),
    HAMBURGER_SHOW("hamburger-show"),
    HAMBURGER_STAR("hamburger-star"),
    HAMBURGER("hamburger"),
    CROISSANT("croissant"),
    SALADA("salad"),
    ESPETINHO("skewer");
    
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
        return Paths.MAIN_ICONS + this.path + MediaExtensions.PNG;
    }
}
