/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.views;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author arthur
 */
public class PedidoFormModel implements FormUseDatePicker{
    public JButton btnCadastrar;
    public JButton btnLimpar;
    
    public JButton btnMostrarItemPedido;
    public JButton btnAdicionarItemAoPedido;
    
    public JTextField campoData;

    @Override
    public void setData(String data) {
        this.campoData.setText(data);
    }
    
    
}
