/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.model.views;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author arthur
 */
public class LancheViewModel {
    public boolean disponivel;
    
    public JLabel btnAtivo;
    
    public JButton btnCadastrar;
    public JButton btnEditar;
    public JButton btnExcluir;
    public JButton btnLimpar;
    public JButton btnLimparBusca;
    public JButton btnPesquisar;
    
    public JTextField campoId;
    public JTextArea campoIngredientes;
    public JTextField campoNome;
    public JTextField campoPesquisar;
    public JTextField campoValor;
    
    public JTable tableLanches;
    
    public JComboBox<String> selectCategoria;
    
    public JTabbedPane abasDoSistema;
}
