/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.views;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author arthur
 */
public class CidadeViewModel {
    
    public JTabbedPane abasDoSistema;
    
    // buttons
    public JButton btnEditar;
    
    public JButton btnExcluir;
    
    public JButton btnLimparBusca;
    
    public JButton btnPesquisar;
    
    public JButton btnCadastrar;
    public JButton btnLimparFormulario;
    
    // campos
    public JTextField campoCidadeId;
    public JTextField campoCidadeNome;
    public JTextField campoPesquisarCidades;
    
    // tables
    public JTable table;
    
    
    // combobox
    public JComboBox<String> selectEstado;
}
