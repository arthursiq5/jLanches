/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.views.internal.frame.helpers;

import com.jlanches.src.dao.ClienteDAO;
import com.jlanches.src.dao.FuncionarioDAO;
import com.jlanches.src.model.views.PedidoFormModel;
import com.jlanches.src.model.views.PedidoReportModel;
import com.jlanches.src.views.extension.elements.DatePicker;

/**
 *
 * @author arthur
 */
public class PedidoReportHelper {
    public static void fillSelects(PedidoReportModel pedidoReport){
        new FuncionarioDAO().fillCombo(pedidoReport.selectReportFuncionario);
        new ClienteDAO().fillCombo(pedidoReport.selectReportCliente);
    }
    
    public static void initComponents(PedidoReportModel pedidoReport){
        fillSelects(pedidoReport);
        pedidoReport.campoDataInicio.clearData();
        pedidoReport.campoDataFim.clearData();
    }
    
    public static void dataInicioLimpar(PedidoReportModel pedidoReport){
        pedidoReport.campoDataInicio.clearData();
    }
    public static void dataFimLimpar(PedidoReportModel pedidoReport){
        pedidoReport.campoDataFim.clearData();
    }
    
    public static void getDataInicio(PedidoReportModel pedidoReport){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatePicker(pedidoReport.campoDataInicio).setVisible(true);
            }
        });
    }
    
    public static void getDataFim(PedidoReportModel pedidoReport){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatePicker(pedidoReport.campoDataFim).setVisible(true);
            }
        });
    }
}
