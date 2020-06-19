/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import src.TestReports;
import src.constants.Paths;
import src.constants.Reports;
import src.dao.BDConnector;

/**
 *
 * @author arthur
 */
public class ReportHelper {
    
    public static Map<String, JasperReport> reports = null;
    
    public static void compileRepots(){
        ReportHelper.reports = new HashMap<String, JasperReport>();
        try {
            JasperReport compileReport = JasperCompileManager.compileReport(TestReports.class.getResourceAsStream(Paths.REPORTS + Reports.EXEMPLO.toString()));
            ReportHelper.reports.put(Reports.EXEMPLO.toString(), compileReport);
            compileReport = JasperCompileManager.compileReport(TestReports.class.getResourceAsStream(Paths.REPORTS + Reports.CIDADE_ESTADO.toString()));
            ReportHelper.reports.put(Reports.CIDADE_ESTADO.toString(), compileReport);
            compileReport = JasperCompileManager.compileReport(TestReports.class.getResourceAsStream(Paths.REPORTS + Reports.CIDADE_ESTADO_BY_ID.toString()));
            ReportHelper.reports.put(Reports.CIDADE_ESTADO_BY_ID.toString(), compileReport);
            compileReport = JasperCompileManager.compileReport(TestReports.class.getResourceAsStream(Paths.REPORTS + Reports.FUNCIONARIOS.toString()));
            ReportHelper.reports.put(Reports.FUNCIONARIOS.toString(), compileReport);
            compileReport = JasperCompileManager.compileReport(TestReports.class.getResourceAsStream(Paths.REPORTS + Reports.FUNCIONARIOS_ATIVOS.toString()));
            ReportHelper.reports.put(Reports.FUNCIONARIOS_ATIVOS.toString(), compileReport);
        } catch (JRException ex) {
            Logger.getLogger(ReportHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void showReport(Reports report){
        JasperReport compileReport = ReportHelper.reports.get(report.toString());
        JasperPrint fillReport;
        try {
            fillReport = JasperFillManager.fillReport(compileReport, new HashMap<>(), BDConnector.getInstance().getConnection());
            JasperViewer.viewReport(fillReport, false);
        } catch (JRException ex) {
            Logger.getLogger(ReportHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void showReport(Reports report, HashMap params){
        JasperReport compileReport = ReportHelper.reports.get(report.toString());
        JasperPrint fillReport;
        try {
            fillReport = JasperFillManager.fillReport(compileReport, params, BDConnector.getInstance().getConnection());
            JasperViewer.viewReport(fillReport, false);
        } catch (JRException ex) {
            Logger.getLogger(ReportHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
