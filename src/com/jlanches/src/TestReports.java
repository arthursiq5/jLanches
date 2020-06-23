/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src;

import com.jlanches.src.constants.Paths;
import com.jlanches.src.constants.Reports;
import java.io.InputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import com.jlanches.src.dao.BDConnector;

/**
 *
 * @author arthur
 */
public class TestReports {
    public static void main(String[] args) {
        try {
            JasperReport compileReport = JasperCompileManager.compileReport(TestReports.class.getResourceAsStream(Paths.REPORTS + Reports.CIDADE_ESTADO.toString()));
            JasperPrint fillReport = JasperFillManager.fillReport(compileReport, new HashMap<>(), BDConnector.getInstance().getConnection());
            JasperViewer.viewReport(fillReport, false);
        } catch (JRException ex) {
            ex.printStackTrace();
            Logger.getLogger(TestReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
