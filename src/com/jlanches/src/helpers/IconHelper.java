/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.helpers;

import javax.swing.ImageIcon;
import com.jlanches.src.constants.MediaExtensions;
import com.jlanches.src.constants.Paths;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 *
 * @author arthur
 */
public class IconHelper {
    public static ImageIcon getPngIcon(String name){
        return new IconHelper().getStaticPngIcon(name);
    }
    
    public ImageIcon getStaticPngIcon(String name){
        return new ImageIcon(getClass().getResource(name));
    }
    
    private Image getStaticPngImage(String name){
        URL iconPath = getClass().getResource(name);
        return Toolkit.getDefaultToolkit().getImage(iconPath);
    }
    
    public static Image getPngImage(String name){
        return new IconHelper().getStaticPngImage(name);
    }
}
