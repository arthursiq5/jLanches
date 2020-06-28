/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.views.internal.frame.helpers;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.jlanches.src.constants.FormaDePagamento;
import com.jlanches.src.constants.media.Icons;
import com.jlanches.src.constants.SystemColors;
import com.jlanches.src.dao.ClienteDAO;
import com.jlanches.src.dao.FranquiaDAO;
import com.jlanches.src.dao.FuncionarioDAO;
import com.jlanches.src.dao.PedidoDAO;
import com.jlanches.src.helpers.ComboHelper;
import com.jlanches.src.helpers.DateHelper;
import com.jlanches.src.helpers.ViewHelper;
import com.jlanches.src.model.Cliente;
import com.jlanches.src.model.Funcionario;
import com.jlanches.src.model.Pedido;
import com.jlanches.src.model.views.PedidoFormModel;
import com.jlanches.src.model.views.PedidoViewModel;
import com.jlanches.src.views.extension.elements.ComboItem;

/**
 *
 * @author arthur
 */
public class PedidoFormHelper {

    public static void initButtons(PedidoFormModel pedidoView) {
        ViewHelper.initFormButtons(pedidoView.btnLimpar, pedidoView.btnCadastrar);
        ViewHelper.setButtonStyle(pedidoView.btnAdicionarItemAoPedido, SystemColors.LIGHT_GREEN, Icons.ADD_64);
        ViewHelper.setButtonStyle(pedidoView.btnMostrarItemPedido, SystemColors.SILVER, Icons.PESQUISAR_64);
    }

    public static void resetCampos(PedidoFormModel pedidoForm) {
        pedidoForm.campoComentarios.setText("");
        pedidoForm.campoData.setText("");
        pedidoForm.campoId.setText("");
    }

    public static void carregaCombos(PedidoFormModel pedidoForm) {
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

    public static void insert(PedidoFormModel pedidoForm) {
        PedidoFormHelper.cadastrar(pedidoForm);
    }

    public static void cadastrar(PedidoFormModel pedidoForm) {
        new PedidoDAO().save(PedidoViewHelper.generatePedido(pedidoForm));
    }

    public static Pedido generatePedido(PedidoFormModel pedidoForm) {
        Pedido pedido = new Pedido();

        pedido.id = pedidoForm.campoId.getText().equals("") ? 0 : Integer.parseInt(pedidoForm.campoId.getText());
        pedido.comentarios = pedidoForm.campoComentarios.getText();
        try {
            pedido.data = DateHelper.stringToDate(pedidoForm.campoData.getText());
        } catch (ParseException ex) {
            Logger.getLogger(PedidoFormHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        pedido.formaDePagamento = (FormaDePagamento) pedidoForm.selectFormaPagamento.getSelectedItem();
        pedido.cliente_cpf = ((Cliente) ((ComboItem) pedidoForm.selectCliente.getSelectedItem()).descricao).cpf;
        pedido.funcionario_cpf = ((Funcionario) ((ComboItem) pedidoForm.selectFuncionario.getSelectedItem()).descricao).cpf;

        pedido.franquia_id = new FuncionarioDAO().get(pedido.funcionario_cpf).franquia_id;

        return pedido;
    }
}
