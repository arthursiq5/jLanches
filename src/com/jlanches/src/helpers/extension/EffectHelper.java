/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.helpers.extension;

import com.jlanches.src.constants.SoundEffects;
import com.jlanches.src.helpers.SoundHelper;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author arthur
 */
public abstract class EffectHelper {
    
    public static void playBellSound(){
        EffectHelper.playSound(SoundEffects.BELL);
    }
    
    public static void playBeepSound(){
        EffectHelper.playSound(SoundEffects.BEEP);
    }
    
    public static void playBrokeSound(){
        EffectHelper.playSound(SoundEffects.BROKE);
    }
    
    public static void playCoinSound(){
        EffectHelper.playSound(SoundEffects.COIN);
    }
    
    public static void playSound(SoundEffects effect){
        try 
        {   
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(SoundHelper.class.getResource(effect.getFullPath()));
            AudioFormat format = inputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip)AudioSystem.getLine(info);
            clip.open(inputStream);
            clip.start();
        }

    catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1)
        {
            System.out.println(effect.getFullPath());
            e1.printStackTrace();
        }
    }
}
