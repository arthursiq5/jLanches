/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.model.views;

import com.jlanches.src.model.Cliente;
import com.jlanches.src.model.Funcionario;
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
    public ParseDate campoDataInicio;
    public ParseDate campoDataFim;

    public JButton btnReportClearDataFim;
    public JButton btnReportClearDataInicio;
    public JButton btnReportInsertDataFim;
    public JButton btnReportInsertDataInicio;

    public static class ParseDate implements FormUseDatePicker {

        private final JTextField field;

        public ParseDate(JTextField field) {
            this.field = field;
        }

        @Override
        public void setData(String data) {
            this.field.setText(data);
        }

        public void clearData() {
            this.field.setText("");
        }

        public String getData() {
            return this.field.getText();
        }

    }

}
