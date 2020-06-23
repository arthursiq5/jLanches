/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.views.internal.frame.helpers;

import com.jlanches.src.constants.media.Icons;
import com.jlanches.src.constants.SystemColors;
import com.jlanches.src.dao.PedidoDAO;
import com.jlanches.src.helpers.ViewHelper;
import com.jlanches.src.model.Lanche;
import com.jlanches.src.model.Pedido;
import com.jlanches.src.model.views.PedidoViewModel;

/**
 *
 * @author arthur
 */
public class PedidoViewHelper {
    
    private enum AbasDoSistema{
        VISUALIZAR(0),
        CADASTRAR(1),
        MOSTRAR_PEDIDO(2);
        
        private int id;
        
        private AbasDoSistema(int id){
            this.id = id;
        }
    }
    
    private static void changeTab(PedidoViewModel pedidoView, AbasDoSistema aba){
        pedidoView.abasDoSistema.setSelectedIndex(
                aba.id
        );
    }
    
    public static void updateMainTable(PedidoViewModel pedidoView){
        new PedidoDAO().fillTable(pedidoView.tabelaPedidos, false, "");
        pedidoView.btnMostrarTodosOsPedidos.setSelected(false);
        PedidoViewHelper.changeTab(pedidoView, AbasDoSistema.VISUALIZAR);
    }
    
    public static void mostrarTodosOsPedidos(PedidoViewModel pedidoView){
        if(pedidoView.btnMostrarTodosOsPedidos.isSelected()){
            new PedidoDAO().fillTable(pedidoView.tabelaPedidos, true, "");
            return;
        }
        PedidoViewHelper.updateMainTable(pedidoView);
    }
    
    public static void initPedidoView(PedidoViewModel pedidoView){
        PedidoViewHelper.updateMainTable(pedidoView);
        PedidoViewHelper.initButtonsStyle(pedidoView);
        PedidoFormHelper.carregaCombos(pedidoView);
    }
    
    private static Pedido getItemFromTable(PedidoViewModel pedidoView){
        return (Pedido)(pedidoView.tabelaPedidos.getValueAt(pedidoView.tabelaPedidos.getSelectedRow(), 1));
    }
    
    private static void initButtonsStyle(PedidoViewModel pedidoView){
        ViewHelper.setButtonStyle(pedidoView.btnPagar, SystemColors.CONFIRM_GREEN, Icons.COIN_64);
        ViewHelper.setButtonStyle(pedidoView.btnMostraPedido, SystemColors.ERASE_BLUE, Icons.PESQUISAR_64);
        ViewHelper.setButtonStyle(pedidoView.btnMostrarTodosOsPedidos, SystemColors.SILVER, Icons.COIN_64);
    }
}