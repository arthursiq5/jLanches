/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.views;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author arthur
 */
public class CidadeViewModel {
    // buttons
    public JButton btnEditarCidade;
    public JButton btnEditarEstado;
    public JButton btnExcluirCidade;
    public JButton btnExcluirEstado;
    public JButton btnLimparBuscaCidades;
    public JButton btnLimparBuscaEstados;
    public JButton btnPesquisarCidades;
    public JButton btnPesquisarEstados;
    
    // campos
    public JTextField campoCidadeId;
    public JTextField campoCidadeNome;
    public JTextField campoPesquisarCidades;
    
    // tables
    public JTable tableCidades;
    public JTable tableEstados;
}
