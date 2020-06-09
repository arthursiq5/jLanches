/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.helpers;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import src.constants.Icons;
import src.constants.SystemColors;
import src.model.views.AbasDaTela;

/**
 *
 * @author arthur
 */
public class ViewHelper {
    
    public static void changeTab(JTabbedPane abasDoSistema, int idAba){
        abasDoSistema.setSelectedIndex(idAba);
    }
    
    public static void openFormTab(AbasDaTela abasDoSistema){
        ViewHelper.changeTab(abasDoSistema.PAINEL, abasDoSistema.FORM_ID);
    }
    
    public static void openViewTab(AbasDaTela abasDoSistema){
        ViewHelper.changeTab(abasDoSistema.PAINEL, abasDoSistema.VIEW_ID);
    }
    
    public static void setButtonStyle(JButton button, SystemColors color, Icons icon){
        button.setBackground(ColorHelper.getColor(color));
        button.setIcon(IconHelper.getPngIcon(icon.getPath()));
        button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }
    
    public static void setEditButtonStyle(JButton button){
        ViewHelper.setButtonStyle(button, SystemColors.LIGHT_GREEN, Icons.EDITAR_64);
    }
    
    public static void setDeleteButtonStyle(JButton button){
        ViewHelper.setButtonStyle(button, SystemColors.LIGHT_RED, Icons.EXCLUIR_64);
    }
    
    public static void setClearSearchButtonStyle(JButton button){
        ViewHelper.setButtonStyle(button, SystemColors.DEFAULT_BACKEND, Icons.APAGAR_16);
    }
    
    public static void setSearchButtonStyle(JButton button){
        ViewHelper.setButtonStyle(button, SystemColors.DEFAULT_BACKEND, Icons.PESQUISAR_16);
    }
    
    public static void setSearch64ButtonStyle(JButton button){
        ViewHelper.setButtonStyle(button, SystemColors.DEFAULT_BACKEND, Icons.PESQUISAR_64);
    }
    
    public static void setSubmitButtonStyle(JButton button){
        ViewHelper.setButtonStyle(button, SystemColors.CONFIRM_GREEN, Icons.CHECK_64);
    }
    
    public static void setClearFormButtonStyle(JButton button){
        ViewHelper.setButtonStyle(button, SystemColors.ERASE_BLUE, Icons.APAGAR_64);
    }
    public static void setCancel64ButtonStyle(JButton button){
        ViewHelper.setButtonStyle(button, SystemColors.LIGHT_RED, Icons.CANCELAR_64);
    }
    
    public static void initButtons(
        JButton btnEditar,
        JButton btnExcluir,
        JButton btnPesquisar,
        JButton btnLimpar
    ){
        ViewHelper.setEditButtonStyle(btnEditar);
        ViewHelper.setDeleteButtonStyle(btnExcluir);
        ViewHelper.setSearchButtonStyle(btnPesquisar);
        ViewHelper.setClearSearchButtonStyle(btnLimpar);
    }
    
    public static void initFormButtons(
            JButton btnLimpar,
            JButton btnCadastrar
    ){
        ViewHelper.setSubmitButtonStyle(btnCadastrar);
        ViewHelper.setClearFormButtonStyle(btnLimpar);
    }
}
