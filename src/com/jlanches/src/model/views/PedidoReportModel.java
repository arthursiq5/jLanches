/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.model.views;

import com.jlanches.src.model.Cliente;
import com.jlanches.src.model.Funcionario;
import com.jlanches.src.views.extension.elements.DatePicker;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author arthur
 */
public class PedidoReportModel {

    public Date dataInicio;
    public Date dataFim;
    public Funcionario funcionario;
    public Cliente cliente;

    public JComboBox selectReportFuncionario;
    public JComboBox selectReportCliente;
    
    public DatePicker.ParseDate campoDataInicio;
    public DatePicker.ParseDate campoDataFim;

    public JButton btnReportClearDataFim;
    public JButton btnReportClearDataInicio;
    public JButton btnReportInsertDataFim;
    public JButton btnReportInsertDataInicio;

    

}
