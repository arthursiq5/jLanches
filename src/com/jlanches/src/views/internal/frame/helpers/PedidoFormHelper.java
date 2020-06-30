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
import com.jlanches.src.dao.LanchePedidoDAO;
import com.jlanches.src.dao.PedidoDAO;
import com.jlanches.src.helpers.ComboHelper;
import com.jlanches.src.helpers.DateHelper;
import com.jlanches.src.helpers.MessageHelper;
import com.jlanches.src.helpers.TableHelper;
import com.jlanches.src.helpers.ViewHelper;
import com.jlanches.src.model.Cliente;
import com.jlanches.src.model.Funcionario;
import com.jlanches.src.model.LanchePedido;
import com.jlanches.src.model.Pedido;
import com.jlanches.src.model.views.PedidoFormModel;
import com.jlanches.src.model.views.PedidoViewModel;
import com.jlanches.src.views.extension.elements.ComboItem;
import java.util.ArrayList;

/**
 *
 * @author arthur
 */
public class PedidoFormHelper {
    
    protected enum AbasDoSistema {
        VISUALIZAR(0),
        CADASTRAR(1),
        MOSTRAR_PEDIDO(2);

        public final int id;

        private AbasDoSistema(int id) {
            this.id = id;
        }
    }

    protected static void changeTab(PedidoFormModel pedidoView, AbasDoSistema aba) {
        pedidoView.abasDoSistema.setSelectedIndex(
                aba.id
        );
    }

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
        if(pedidoForm.selectCliente.getSelectedIndex() == 0 ||
            pedidoForm.selectFuncionario.getSelectedIndex() == 0 ||
            pedidoForm.campoData.getText().equals("")){
            MessageHelper.createWarningMessage("Formulário inválido", "Por favor, preencha os campos obrigatórios");
            return;
        }
        
        new PedidoDAO().save(PedidoViewHelper.generatePedido(pedidoForm));
        int id = new PedidoDAO().getUltimoPedido().id;
        
        pedidoForm.pedido.itens.forEach(el -> {
            el.pedido_id = id;
            new LanchePedidoDAO().save(el);
        });
        
        PedidoFormHelper.clearForm(pedidoForm);
        PedidoFormHelper.changeTab(pedidoForm, AbasDoSistema.VISUALIZAR);
    }
    public static void edita(PedidoFormModel pedidoForm) {
        if(pedidoForm.selectCliente.getSelectedIndex() == 0 ||
            pedidoForm.selectFuncionario.getSelectedIndex() == 0 ||
            pedidoForm.campoData.getText().equals("")){
            MessageHelper.createWarningMessage("Formulário inválido", "Por favor, preencha os campos obrigatórios");
            return;
        }
        
        new PedidoDAO().update(PedidoViewHelper.generatePedido(pedidoForm));
        int id = pedidoForm.pedido.id;
        
        pedidoForm.pedido.itens.forEach(el -> {
            el.pedido_id = id;
            if(el.id == 0){
                new LanchePedidoDAO().save(el);
            }else{
                new LanchePedidoDAO().update(el);
            }
        });
        PedidoFormHelper.changeTab(pedidoForm, AbasDoSistema.VISUALIZAR);
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
        
        pedido.pago = pedidoForm.pago.pago;

        return pedido;
    }
    
    public static void updatePedidoLancheTable(PedidoFormModel form){
        TableHelper.populaTabelaLanchePedido(form.tabelaItensPedido, form.pedido.itens);
    }
    
    public static void deletePedidoItem(PedidoFormModel form){
        int itemRemover = form.tabelaItensPedido.getSelectedRow();
        if(form.pedido.itens.get(itemRemover).id != 0)
            new LanchePedidoDAO().delete(form.pedido.itens.get(itemRemover));
        form.pedido.itens.remove(itemRemover);
        PedidoFormHelper.updatePedidoLancheTable(form);
    }
    
    public static void clearForm(PedidoFormModel form){
        form.pedido = new Pedido();
        form.campoComentarios.setText("");
        form.campoData.setText("");
        form.campoId.setText("");
        form.selectCliente.setSelectedIndex(0);
        form.selectFormaPagamento.setSelectedIndex(0);
        form.selectFuncionario.setSelectedIndex(0);
        TableHelper.populaTabelaLanchePedido(form.tabelaItensPedido, new ArrayList<LanchePedido>());
    }
}
