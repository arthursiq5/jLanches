/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.model.views;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.jlanches.src.model.LanchePedido;

/**
 *
 * @author arthur
 */
public class AddItemPedidoModel {

    public ArrayList<LanchePedido> itens;
    public int pedido_id;

    public JTextField campoId;
    public JFormattedTextField campoAcrescimo;
    public JFormattedTextField campoDesconto;
    public JTextArea campoModificacoes;
    public JTextField campoTotal;

    public JComboBox<String> selectLanche;

    public JButton btnShowLanche;
    public JButton btnAdicionar;
    public JButton btnCancelar;
}
