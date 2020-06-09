/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.helpers;

import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.UIManager;

/**
 *
 * @author arthur
 */
public class FrameHelper {
    public static void setLookAndFeel(){
        FrameHelper.setJTattooLookAndFeel();
    }
    
    public static boolean setJTattooLookAndFeel(){
        boolean success = false;
        
        String jTattoo = "";
        try{
            Properties prop = new Properties();
            prop.load(new FileInputStream("lib.properties"));
            jTattoo = prop.getProperty("lib.jtattoo");
        }catch(Exception e){
            System.out.print("Erro: ");
            System.err.println(e);
        }
        if(!jTattoo.equals(""))
            try {
                UIManager.setLookAndFeel(jTattoo);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            FrameHelper.setNimbusLookAndFeel();
        }
        
        return success;
    }
    
    public static boolean setNimbusLookAndFeel(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
