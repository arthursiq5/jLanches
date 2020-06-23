/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.views.internalFrame.helpers;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.constants.FormaDePagamento;
import src.constants.Icons;
import src.constants.SystemColors;
import src.dao.ClienteDAO;
import src.dao.FranquiaDAO;
import src.dao.FuncionarioDAO;
import src.helpers.ComboHelper;
import src.helpers.DateHelper;
import src.helpers.ViewHelper;
import src.model.Cliente;
import src.model.Funcionario;
import src.model.Pedido;
import src.model.views.PedidoFormModel;

/**
 *
 * @author arthur
 */
public class PedidoFormHelper {
    public static void initButtons(PedidoFormModel pedidoView){
        ViewHelper.initFormButtons(pedidoView.btnLimpar, pedidoView.btnCadastrar);
        ViewHelper.setButtonStyle(pedidoView.btnAdicionarItemAoPedido, SystemColors.LIGHT_GREEN, Icons.ADD_64);
        ViewHelper.setButtonStyle(pedidoView.btnMostrarItemPedido, SystemColors.SILVER, Icons.PESQUISAR_64);
    }
    
    public static void resetCampos(PedidoFormModel pedidoForm){
        pedidoForm.campoComentarios.setText("");
        pedidoForm.campoData.setText("");
        pedidoForm.campoId.setText("");
    }
    
    public static void carregaCombos(PedidoFormModel pedidoForm){
        FormaDePagamento[] formaPagamento = {
            FormaDePagamento.A_VISTA,
            FormaDePagamento.CARTAO_DE_CREDITO,
            FormaDePagamento.CARTAO_DE_DEBITO,
            FormaDePagamento.CHEQUE
        };
        ComboHelper.fillCombo(pedidoForm.selectFormaPagamento, formaPagamento);
        new ClienteDAO().fillCombo(pedidoForm.selectCliente);
        new FuncionarioDAO().fillCombo(pedidoForm.selectFuncionario);
        
    }
    
    public static void insert(PedidoFormModel pedidoForm){
        Pedido pedido = new Pedido();
        pedido.id = pedidoForm.campoId.getText().equals("")?0:Integer.parseInt(pedidoForm.campoId.getText());
        pedido.comentarios = pedidoForm.campoComentarios.getText();
        try {
            pedido.data = DateHelper.stringToDate(pedidoForm.campoData.getText());
        } catch (ParseException ex) {
            Logger.getLogger(PedidoFormHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        pedido.formaDePagamento = (FormaDePagamento) pedidoForm.selectFormaPagamento.getSelectedItem();
        pedido.cliente_cpf = ((Cliente) pedidoForm.selectCliente.getSelectedItem()).cpf;
        pedido.funcionario_cpf = ((Funcionario) pedidoForm.selectFuncionario.getSelectedItem()).cpf;
        
        pedido.franquia_id = new FuncionarioDAO().get(pedido.funcionario_cpf).franquia_id;
    }
}
