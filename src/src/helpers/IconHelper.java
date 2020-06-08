/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.helpers;

import javax.swing.ImageIcon;

/**
 *
 * @author arthur
 */
public class IconHelper {
    public ImageIcon getPngIcon(String name){
        return new ImageIcon(getClass().getResource("/media/icons/" + name + ".png"));
    }
}
