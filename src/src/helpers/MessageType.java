/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.helpers;

import javax.swing.JOptionPane;

/**
 *
 * @author arthur
 */
public enum MessageType {

    ERROR(JOptionPane.ERROR_MESSAGE),
    INFO(JOptionPane.INFORMATION_MESSAGE),
    PLAIN(JOptionPane.PLAIN_MESSAGE),
    QUESTION(JOptionPane.QUESTION_MESSAGE),
    WARNING(JOptionPane.WARNING_MESSAGE);
    
    private final int type;
    private MessageType(int type) {
        this.type = type;
    }
    
    public int getValue(){
        return this.type;
    }
    
}
