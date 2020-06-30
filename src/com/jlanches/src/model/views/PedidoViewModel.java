/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.model.views;

import com.jlanches.src.model.Pedido;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author arthur
 */
public class PedidoViewModel extends PedidoFormModel {
    public Pedido pedidoShow;

    public static final int ABA_VISUALIZAR = 0;
    public static final int ABA_CADASTRAR = 1;
    public static final int ABA_CONSULTAR = 2;

    public JTabbedPane abasDoSistema;

    public JTable tabelaPedidos;
    public JTable tabelaShowItens;

    public JLabel showCliente;
    public JLabel showId;
    public JLabel showFuncionario;
    public JLabel showData;
    public JLabel showFormaDePagamento;
    public JLabel showPago;

    public JTextArea showComentarios;

    public JButton btnShowEditar;
    public JButton btnShowExcluir;
    public JTextField campoPesquisar;

    public JButton btnLimparBusca;
    public JButton btnPesquisar;
    public JButton btnPesquisaAvancada;

    public JToggleButton btnMostrarTodosOsPedidos;
    public JButton btnMostraPedido;

    public JButton btnPagar;
}
