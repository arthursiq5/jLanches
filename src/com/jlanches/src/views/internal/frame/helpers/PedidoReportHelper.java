/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.views.internal.frame.helpers;

import com.jlanches.src.constants.Reports;
import com.jlanches.src.dao.ClienteDAO;
import com.jlanches.src.dao.FuncionarioDAO;
import com.jlanches.src.dao.PedidoDAO;
import com.jlanches.src.helpers.MessageHelper;
import com.jlanches.src.helpers.ReportHelper;
import com.jlanches.src.model.Cliente;
import com.jlanches.src.model.Funcionario;
import com.jlanches.src.model.views.PedidoFormModel;
import com.jlanches.src.model.views.PedidoReportModel;
import com.jlanches.src.views.extension.elements.ComboItem;
import com.jlanches.src.views.extension.elements.DatePicker;
import java.sql.Timestamp;
import java.util.HashMap;

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
    
    public static void generate(PedidoReportModel pedidoReport){
        if(!PedidoReportHelper.formularioValido(pedidoReport)){
            MessageHelper.createWarningMessage("Aviso", "Dados inválidos foram encontrados. "
                    + "Por favor, verifique os dados inseridos");
            ReportHelper.showReport(Reports.ERROR_REPORT);
            return;
        }
        HashMap hash = new HashMap();
        hash.put("data_inicio", Timestamp.valueOf(pedidoReport.campoDataInicio.getData()));
        hash.put("data_fim", Timestamp.valueOf(pedidoReport.campoDataFim.getData()));
        hash.put("cliente_cpf", ((Cliente)((ComboItem)pedidoReport.selectReportCliente.getSelectedItem()).descricao).cpf);
        hash.put("funcionario_cpf", ((Funcionario)((ComboItem)pedidoReport.selectReportFuncionario.getSelectedItem()).descricao).cpf);
        
        ReportHelper.showReport(Reports.PEDIDO_CLIENTE_FUNCIONARIO_DATA, hash);
    }
    
    private static boolean formularioValido(PedidoReportModel model){
        System.out.println(!model.campoDataFim.getData().equals(""));
        System.out.println(!model.campoDataInicio.getData().equals(""));
        System.out.println(((ComboItem)model.selectReportFuncionario.getSelectedItem()).id != 0);
        System.out.println(((ComboItem)model.selectReportCliente.getSelectedItem()).id != 0);
        if(!model.campoDataFim.getData().equals("")
            && !model.campoDataInicio.getData().equals("")
            //&& ((ComboItem)model.selectReportFuncionario.getSelectedItem()).id != 0
            //&& ((ComboItem)model.selectReportCliente.getSelectedItem()).id != 0
            )
        if(new PedidoDAO()
            .databaseHasClienteFuncionarioData(
                    ((Funcionario)((ComboItem)model.selectReportFuncionario.getSelectedItem()).descricao).cpf, 
                    ((Cliente)((ComboItem)model.selectReportCliente.getSelectedItem()).descricao).cpf, 
                    model.campoDataInicio.getData(), 
                    model.campoDataFim.getData()
                ))
            return true;
        return false;
    }
}
