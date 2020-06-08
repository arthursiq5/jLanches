/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.views.internalFrame.helpers;

import javax.swing.JButton;
import javax.swing.JTextField;
import src.dao.CidadeDAO;
import src.dao.EstadoDAO;
import src.helpers.ViewHelper;
import src.model.views.CidadeViewModel;

/**
 *
 * @author arthur
 */
public class CidadeViewHelper {
    
    public static void initButtons(
            CidadeViewModel cidadeView
    ){
        ViewHelper.initButtons(
                cidadeView.btnEditarEstado, 
                cidadeView.btnExcluirEstado, 
                cidadeView.btnPesquisarEstados, 
                cidadeView.btnLimparBuscaEstados
        );
        ViewHelper.initButtons(
                cidadeView.btnEditarCidade,
                cidadeView.btnExcluirCidade,
                cidadeView.btnPesquisarCidades,
                cidadeView.btnLimparBuscaCidades
        );
    }
    
    public static void resetCidadeInputs(
            CidadeViewModel cidadeView
    ){
        cidadeView.campoCidadeId.setText("");
        cidadeView.campoPesquisarCidades.setText("");
        cidadeView.campoCidadeNome.setText("");
    }
    
    public static void updateTables(CidadeViewModel cidadeView){
        new CidadeDAO().fillTable(cidadeView.tableCidades, "");
        new EstadoDAO().fillTable(cidadeView.tableEstados, "");
    }
}
