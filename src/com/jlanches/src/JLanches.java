/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src;

import com.jlanches.src.helpers.ReportHelper;
import com.jlanches.src.views.LoginScreen;

/**
 *
 * @author arthur
 */
public class JLanches {

    public static void main(String[] args) {
        ReportHelper.compileRepots();
        new LoginScreen().setVisible(true);
    }
}
