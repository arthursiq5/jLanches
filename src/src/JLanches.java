/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import src.constants.Reports;
import src.helpers.ReportHelper;
import src.views.LoginScreen;

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
