/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.helpers;

import com.jlanches.src.constants.media.MainIcons;
import javax.swing.JFrame;

/**
 *
 * @author arthur
 */
public class HeaderHelper {

    private MainIcons icon = null;
    private JFrame frame = null;
    private static HeaderHelper instance = null;

    private HeaderHelper() {
    }

    public static HeaderHelper getInstance() {
        if (HeaderHelper.instance == null) {
            HeaderHelper.instance = new HeaderHelper();
        }
        return HeaderHelper.instance;
    }

    public static void setIcon(MainIcons icon) {
        HeaderHelper.getInstance().icon = icon;
    }

    public static void loadIcon(JFrame frame) {
        FrameHelper.setHeaderIcon(frame, HeaderHelper.instance.icon);
    }

    public static void setFrame(JFrame frame) {
        HeaderHelper.getInstance().frame = frame;
    }

    public static void loadIcon() {
        if (HeaderHelper.getInstance().frame != null) {
            FrameHelper.setHeaderIcon(HeaderHelper.getInstance().frame, HeaderHelper.instance.icon);
        }
    }
}
