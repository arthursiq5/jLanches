/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.views;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author arthur
 */
public class EstadoViewModel {
    
    public AbasDaTela abasDoSistema;
    
    public JButton btnEditar;
    public JButton btnExcluir;
    public JButton btnLimparBusca;
    public JButton btnPesquisar;
    
    public JButton btnCadastrar;
    public JButton btnLimparFormulario;
    
    public JTextField campoPesquisar;
    public JTextField campoId;
    public JTextField campoNome;
    public JTextField campoSigla;
    
    public JTable table;
}
