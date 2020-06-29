/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.helpers;

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
import com.jlanches.src.TestReports;
import com.jlanches.src.constants.Paths;
import com.jlanches.src.constants.Reports;
import com.jlanches.src.dao.BDConnector;
import com.jlanches.src.helpers.extension.HashMapHelper;
import java.util.Arrays;

/**
 *
 * @author arthur
 */
public class ReportHelper {

    public static Map<String, JasperReport> reports = null;

    public static void compileRepots() {
        ReportHelper.reports = new HashMap<String, JasperReport>();
        try {
            JasperReport compileReport = JasperCompileManager.compileReport(TestReports.class.getResourceAsStream(Reports.EXEMPLO.getFullPath()));
            ReportHelper.reports.put(Reports.EXEMPLO.toString(), compileReport);
            compileReport = JasperCompileManager.compileReport(TestReports.class.getResourceAsStream(Reports.CIDADE_ESTADO.getFullPath()));
            ReportHelper.reports.put(Reports.CIDADE_ESTADO.toString(), compileReport);
            compileReport = JasperCompileManager.compileReport(TestReports.class.getResourceAsStream(Reports.CIDADE_ESTADO_BY_ID.getFullPath()));
            ReportHelper.reports.put(Reports.CIDADE_ESTADO_BY_ID.toString(), compileReport);
            compileReport = JasperCompileManager.compileReport(TestReports.class.getResourceAsStream(Reports.FUNCIONARIOS.getFullPath()));
            ReportHelper.reports.put(Reports.FUNCIONARIOS.toString(), compileReport);
            compileReport = JasperCompileManager.compileReport(TestReports.class.getResourceAsStream(Reports.FUNCIONARIOS_ATIVOS.getFullPath()));
            ReportHelper.reports.put(Reports.FUNCIONARIOS_ATIVOS.toString(), compileReport);
            compileReport = JasperCompileManager.compileReport(TestReports.class.getResourceAsStream(Reports.PEDIDO_COMPLETO.getFullPath()));
            ReportHelper.reports.put(Reports.PEDIDO_COMPLETO.toString(), compileReport);
            compileReport = JasperCompileManager.compileReport(TestReports.class.getResourceAsStream(Reports.PEDIDO_CLIENTE_FUNCIONARIO_DATA.getFullPath()));
            ReportHelper.reports.put(Reports.PEDIDO_CLIENTE_FUNCIONARIO_DATA.toString(), compileReport);
            compileReport = JasperCompileManager.compileReport(TestReports.class.getResourceAsStream(Reports.ERROR_REPORT.getFullPath()));
            ReportHelper.reports.put(Reports.ERROR_REPORT.toString(), compileReport);
            compileReport = JasperCompileManager.compileReport(TestReports.class.getResourceAsStream(Reports.PEDIDO_GENERICO.getFullPath()));
            ReportHelper.reports.put(Reports.PEDIDO_GENERICO.toString(), compileReport);
        } catch (JRException ex) {
            Logger.getLogger(ReportHelper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(Reports.EXEMPLO.getFullPath());
            System.out.println(Reports.CIDADE_ESTADO.getFullPath());
        }
    }

    public static void showReport(Reports report) {
        JasperReport compileReport = ReportHelper.reports.get(report.toString());
        JasperPrint fillReport;
        try {
            fillReport = JasperFillManager.fillReport(compileReport, new HashMap<>(), BDConnector.getInstance().getConnection());
            JasperViewer.viewReport(fillReport, false);
            SoundHelper.playCoinSound();
        } catch (JRException ex) {
            Logger.getLogger(ReportHelper.class.getName()).log(Level.SEVERE, null, ex);
            SoundHelper.playBrokeSound();
        }
    }

    public static void showReport(Reports report, HashMap params) {
        JasperReport compileReport = ReportHelper.reports.get(report.toString());
        JasperPrint fillReport;
        HashMapHelper.printHashMap(params);
        try {
            fillReport = JasperFillManager.fillReport(compileReport, params, BDConnector.getInstance().getConnection());
            JasperViewer.viewReport(fillReport, false);
            SoundHelper.playCoinSound();
        } catch (JRException ex) {
            Logger.getLogger(ReportHelper.class.getName()).log(Level.SEVERE, null, ex);
            SoundHelper.playBrokeSound();
        }
    }

}
