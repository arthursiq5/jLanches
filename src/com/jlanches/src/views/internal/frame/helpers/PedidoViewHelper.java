/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.views.internal.frame.helpers;

import com.jlanches.src.constants.media.Icons;
import com.jlanches.src.constants.SystemColors;
import com.jlanches.src.dao.ClienteDAO;
import com.jlanches.src.dao.FuncionarioDAO;
import com.jlanches.src.dao.PedidoDAO;
import com.jlanches.src.helpers.ComboHelper;
import com.jlanches.src.helpers.DateHelper;
import com.jlanches.src.helpers.TableHelper;
import com.jlanches.src.helpers.ViewHelper;
import com.jlanches.src.model.Lanche;
import com.jlanches.src.model.Pedido;
import com.jlanches.src.model.views.PedidoFormModel;
import com.jlanches.src.model.views.PedidoViewModel;
import com.jlanches.src.views.internal.frame.advanced.search.SearchPedido;
import java.util.ArrayList;

/**
 *
 * @author arthur
 */
public class PedidoViewHelper extends PedidoFormHelper {

    

    public static void updateMainTable(PedidoViewModel pedidoView) {
        new PedidoDAO().fillTable(pedidoView.tabelaPedidos, false, "");
        pedidoView.btnMostrarTodosOsPedidos.setSelected(false);
        PedidoViewHelper.changeTab(pedidoView, AbasDoSistema.VISUALIZAR);
    }

    public static void search(PedidoViewModel pedidoView) {
        new PedidoDAO().fillTable(
                pedidoView.tabelaPedidos,
                true,
                pedidoView.campoPesquisar.getText()
        );
    }

    public static void mostrarTodosOsPedidos(PedidoViewModel pedidoView) {
        if (pedidoView.btnMostrarTodosOsPedidos.isSelected()) {
            new PedidoDAO().fillTable(pedidoView.tabelaPedidos, true, "");
            return;
        }
        PedidoViewHelper.updateMainTable(pedidoView);
    }

    public static void initPedidoView(PedidoViewModel pedidoView) {
        pedidoView.campoPesquisar.setText("");
        PedidoViewHelper.updateMainTable(pedidoView);
        PedidoViewHelper.initButtonsStyle(pedidoView);
        PedidoFormHelper.carregaCombos(pedidoView);
        PedidoViewHelper.resetCampos(pedidoView);
        PedidoViewHelper.updatePedidoLancheTable(pedidoView);
        PedidoViewHelper.clearViewSinglePedido(pedidoView);
    }

    private static Pedido getItemFromTable(PedidoViewModel pedidoView) {
        return (Pedido) (pedidoView.tabelaPedidos.getValueAt(pedidoView.tabelaPedidos.getSelectedRow(), 1));
    }

    private static void initButtonsStyle(PedidoViewModel pedidoView) {
        ViewHelper.setButtonStyle(pedidoView.btnPagar, SystemColors.CONFIRM_GREEN, Icons.COIN_64);
        ViewHelper.setButtonStyle(pedidoView.btnMostraPedido, SystemColors.ERASE_BLUE, Icons.PESQUISAR_64);
        ViewHelper.setButtonStyle(pedidoView.btnMostrarTodosOsPedidos, SystemColors.SILVER, Icons.COIN_64);
    }

    public static void cadastrar(PedidoViewModel pedidoView) {
        PedidoFormHelper.cadastrar(pedidoView);
        PedidoViewHelper.updateMainTable(pedidoView);
    }

    public static void showPedido(PedidoViewModel pedidoView) {
        Pedido pedido = PedidoViewHelper.getPedidoFromTable(pedidoView);
        pedidoView.pedidoShow = pedido;
        pedidoView.showId.setText(pedido.id + "");
        pedidoView.showComentarios.setText(pedido.comentarios);
        pedidoView.showData.setText(DateHelper.dateToString(pedido.data));
        pedidoView.showCliente.setText(new ClienteDAO().get(pedido.cliente_cpf).toString());
        pedidoView.showFuncionario.setText(new FuncionarioDAO().get(pedido.funcionario_cpf).toString());
        pedidoView.showPago.setText(pedido.pago ? "sim" : "não");
        pedidoView.showFormaDePagamento.setText(pedido.formaDePagamento.toString());

        PedidoViewHelper.changeTab(pedidoView, AbasDoSistema.MOSTRAR_PEDIDO);
    }
    
    public static void editPedido(PedidoViewModel view){
        view.campoId.setText(view.pedidoShow.id + "");
        view.campoData.setText(DateHelper.dateToString(view.pedidoShow.data));
        view.campoComentarios.setText(view.pedidoShow.comentarios);
        TableHelper.populaTabelaLanchePedido(view.tabelaItensPedido, view.pedidoShow.itens);
        ComboHelper.setIndex(view.selectCliente, view.pedidoShow.cliente_cpf);
        ComboHelper.setIndex(view.selectFuncionario, view.pedidoShow.funcionario_cpf);
        view.pago.set(view.pedidoShow.pago);
        
        PedidoViewHelper.changeTab(view, AbasDoSistema.CADASTRAR);
    }

    public static Pedido getPedidoFromTable(PedidoViewModel pedidoView) {
        return (Pedido) (pedidoView.tabelaPedidos.getValueAt(pedidoView.tabelaPedidos.getSelectedRow(), 1));
    }
    
    public static void openPesquisaAvancada(PedidoViewModel view){
        new SearchPedido(view).setVisible(true);
    }
    
    public static void clearViewSinglePedido(PedidoViewModel view){
        TableHelper.populaTabelaLanchePedido(view.tabelaShowItens, new ArrayList<>());
        view.showCliente.setText("");
        view.showComentarios.setText("");
        view.showData.setText("");
        view.showFormaDePagamento.setText("");
        view.showFuncionario.setText("");
        view.showId.setText("");
        view.showPago.setText("");
    }
}
