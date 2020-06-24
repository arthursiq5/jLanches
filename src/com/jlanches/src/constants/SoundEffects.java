/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.constants;

/**
 *
 * @author arthur
 */
public enum SoundEffects {
    BEEP("beep", MediaExtensions.WAV),
    BELL("bell", MediaExtensions.WAV),
    BROKE("broke", MediaExtensions.WAV),
    COIN("coin", MediaExtensions.WAV);
    
    private final String path;
    private final MediaExtensions extension;
    
    private SoundEffects(String path, MediaExtensions extension){
        this.path = path;
        this.extension = extension;
    }
    
    public String toString(){
        return this.path;
    }
    
    public String getFullPath(){
        return Paths.EFFECTS + this.path + this.extension;
    }
}
