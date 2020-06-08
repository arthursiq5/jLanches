/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.views.internalFrame.helpers;

import src.dao.EstadoDAO;
import src.helpers.ViewHelper;
import src.model.views.CidadeViewModel;
import src.model.views.EstadoViewModel;

/**
 *
 * @author arthur
 */
public class EstadoViewHelper {
    public static void updateTable(EstadoViewModel cidadeView){
        new EstadoDAO().fillTable(cidadeView.table, "");
    }
    
    public static void initButtons(
            EstadoViewModel estadoView
    ){
        ViewHelper.initButtons(estadoView.btnEditar,
                estadoView.btnExcluir,
                estadoView.btnPesquisar,
                estadoView.btnLimparBusca
        );
    }
}
