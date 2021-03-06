/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.model.views;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jlanches.src.constants.media.Icons;
import com.jlanches.src.helpers.IconHelper;
import com.jlanches.src.model.Pedido;
import com.jlanches.src.views.extension.elements.DatePicker;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

/**
 *
 * @author arthur
 */
public class PedidoFormModel implements DatePicker.FormUseDatePicker {
    
    public Pedido pedido;
    
    public void resetPedido(){
        this.pedido = new Pedido();
    }

    public static class BooleanButton {

        public boolean pago;
        public JLabel button;

        public BooleanButton(JLabel button) {
            this.button = button;
            this.pago = false;
            this.button.setIcon(
                    IconHelper.getPngIcon(Icons.CANCELAR_64.getFullPath())
            );
        }

        public void changePago() {
            this.pago = !this.pago;
            if (this.pago) {
                this.button.setIcon(
                        IconHelper.getPngIcon(Icons.SELECIONADO_64.getFullPath())
                );
            } else {
                this.button.setIcon(
                        IconHelper.getPngIcon(Icons.CANCELAR_64.getFullPath())
                );
            }
        }
        
        public void set(boolean pago){
            this.pago = pago;
            if (this.pago) {
                this.button.setIcon(
                        IconHelper.getPngIcon(Icons.SELECIONADO_64.getFullPath())
                );
            } else {
                this.button.setIcon(
                        IconHelper.getPngIcon(Icons.CANCELAR_64.getFullPath())
                );
            }
        }
    }

    public BooleanButton pago;

    public JButton btnCadastrar;
    public JButton btnLimpar;

    public JButton btnMostrarItemPedido;
    public JButton btnAdicionarItemAoPedido;

    public JTextField campoData;
    public JTextField campoId;

    public JTextField campoComentarios;

    public JComboBox selectFormaPagamento;
    public JComboBox selectCliente;
    public JComboBox selectFuncionario;
    
    public JTable tabelaItensPedido;
    
    public JTabbedPane abasDoSistema;
    
    public PedidoFormModel(){
        this.pedido = new Pedido();
    }

    @Override
    public void setData(String data) {
        this.campoData.setText(data);
    }

}
