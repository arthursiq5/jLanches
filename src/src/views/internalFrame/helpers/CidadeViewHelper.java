/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.views.internalFrame.helpers;

import javax.swing.JButton;
import src.helpers.ViewHelper;

/**
 *
 * @author arthur
 */
public class CidadeViewHelper {
    public static void initButtons(
        JButton btnEditarCidade,
        JButton btnEditarEstado,
        JButton btnExcluirCidade,
        JButton btnExcluirEstado,
        JButton btnPesquisarCidades,
        JButton btnPesquisarEstados,
        JButton btnLimparBuscaCidades,
        JButton btnLimparBuscaEstados
    ){
        ViewHelper.setEditButtonStyle(btnEditarCidade);
        ViewHelper.setEditButtonStyle(btnEditarEstado);
        ViewHelper.setDeleteButtonStyle(btnExcluirCidade);
        ViewHelper.setDeleteButtonStyle(btnExcluirEstado);
        ViewHelper.setSearchButtonStyle(btnPesquisarCidades);
        ViewHelper.setSearchButtonStyle(btnPesquisarEstados);
        ViewHelper.setClearSearchButtonStyle(btnLimparBuscaCidades);
        ViewHelper.setClearSearchButtonStyle(btnLimparBuscaEstados);
    }
}
