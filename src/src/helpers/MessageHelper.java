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
public class MessageHelper {
    private void createMessage(String title, String message, int type){
        JOptionPane.showMessageDialog(
            null, 
            message, 
            title, 
            type
        );
    }
    
    public static void createErrorMessage(String title, String message){
        new MessageHelper().createMessage(title, message, MessageType.ERROR.getValue());
    }
    
    public static void createInfoMessage(String title, String message){
        new MessageHelper().createMessage(title, message, MessageType.INFO.getValue());
    }
    
    public static void createPlainMessage(String title, String message){
        new MessageHelper().createMessage(title, message, MessageType.PLAIN.getValue());
    }
    
    public static void createQuestionMessage(String title, String message){
        new MessageHelper().createMessage(title, message, MessageType.QUESTION.getValue());
    }
    
    public static void createWarningMessage(String title, String message){
        new MessageHelper().createMessage(title, message, MessageType.WARNING.getValue());
    }
}
