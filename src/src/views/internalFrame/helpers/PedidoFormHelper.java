/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.views.internalFrame.helpers;

import src.constants.FormaDePagamento;
import src.constants.Icons;
import src.constants.SystemColors;
import src.dao.ClienteDAO;
import src.dao.FuncionarioDAO;
import src.helpers.ComboHelper;
import src.helpers.ViewHelper;
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
    
    public static void carregaFormaDePagamento(PedidoFormModel pedidoForm){
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
}
