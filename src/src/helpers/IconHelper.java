/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.helpers;

import javax.swing.ImageIcon;
import src.constants.MediaExtensions;
import src.constants.Paths;

/**
 *
 * @author arthur
 */
public class IconHelper {
    public static ImageIcon getPngIcon(String name){
        return new IconHelper().getStaticPngIcon(name);
    }
    
    private ImageIcon getStaticPngIcon(String name){
        return new ImageIcon(getClass().getResource(Paths.ICONS + name + MediaExtensions.PNG));
    }
}
