/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.helpers;

import com.jlanches.src.constants.media.Icons;
import com.jlanches.src.constants.MediaExtensions;
import com.jlanches.src.constants.Paths;
import com.jlanches.src.constants.media.MainIcons;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;

/**
 *
 * @author arthur
 */
public class FrameHelper {

    public static void setHeaderIcon(JInternalFrame frame, Icons icone) {
        frame.setFrameIcon(IconHelper.getPngIcon(icone.getFullPath()));
    }

    public static void setHeaderIcon(JInternalFrame frame, MainIcons icone) {
        frame.setFrameIcon(IconHelper.getPngIcon(icone.getFullPath()));
    }

    public static void setHeaderIcon(JFrame frame, Icons icone) {
        frame.setIconImage(IconHelper.getPngImage(icone.getFullPath()));
    }

    public static void setHeaderIcon(JFrame frame, MainIcons icone) {
        frame.setIconImage(IconHelper.getPngImage(icone.getFullPath()));
    }

    public static void setLookAndFeel() {
        FrameHelper.setJTattooLookAndFeel();
    }

    public static boolean setJTattooLookAndFeel() {
        boolean success = false;

        String jTattoo = "";
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("lib.properties"));
            jTattoo = prop.getProperty("lib.jtattoo");
        } catch (Exception e) {
            System.out.print("Erro: ");
            System.err.println(e);
        }
        if (!jTattoo.equals("")) {
            try {
                UIManager.setLookAndFeel(jTattoo);
            } catch (Exception ex) {
                ex.printStackTrace();
                FrameHelper.setNimbusLookAndFeel();
            }
        }

        return success;
    }

    public static boolean setNimbusLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
