/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.helpers;

import java.awt.Color;
import com.jlanches.src.constants.SystemColors;

/**
 *
 * @author arthur
 */
public class ColorHelper {

    public static Color getColor(SystemColors color) {
        return ColorHelper.getColor(color.getRed(), color.getGreen(), color.getBlue());
    }

    public static Color getColor(int red, int green, int blue) {
        return new Color(red, green, blue);
    }
}
