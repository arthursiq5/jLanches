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
public enum SystemColors {
    
    DEFAULT_BACKEND(207, 216, 220),
    SILVER(192,192,192);
    
    private final int red;
    private final int green;
    private final int blue;

    private SystemColors(int red, int green, int blue){
        this.red =  red;
        this.green = green;
        this.blue = blue;
    }
    
    public int getRed(){
        return this.red;
    }
    
    public int getGreen(){
        return this.green;
    }
    
    public int getBlue(){
        return this.blue;
    }
}
