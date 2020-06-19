/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.views;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import src.constants.Icons;
import src.helpers.IconHelper;

/**
 *
 * @author arthur
 */
public class PedidoFormModel implements FormUseDatePicker{
    public static class BooleanButton{
        public boolean pago;
        public JLabel button;

        public BooleanButton(JLabel button) {
            this.button = button;
            this.pago = false;
            this.button.setIcon(
                IconHelper.getPngIcon(Icons.CANCELAR_64.getPath())
            );
        }
        
        public void changePago(){
            this.pago = !this.pago;
            if(this.pago){
                this.button.setIcon(
                    IconHelper.getPngIcon(Icons.SELECIONADO_64.getPath())
                );
            }else{
                this.button.setIcon(
                    IconHelper.getPngIcon(Icons.CANCELAR_64.getPath())
                );
            }
        }
    }
    
    public boolean pago = true;
    
    public JButton btnCadastrar;
    public JButton btnLimpar;
    
    public JButton btnMostrarItemPedido;
    public JButton btnAdicionarItemAoPedido;
    
    public JTextField campoData;
    public JTextField campoId;

    @Override
    public void setData(String data) {
        this.campoData.setText(data);
    }
    
    
}
