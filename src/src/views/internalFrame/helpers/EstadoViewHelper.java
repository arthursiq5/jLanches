/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.views.internalFrame.helpers;

import javax.swing.JOptionPane;
import src.dao.EstadoDAO;
import src.helpers.ViewHelper;
import src.model.Estado;
import src.model.views.EstadoViewModel;
import src.validators.testers.EstadoValidator;

/**
 *
 * @author arthur
 */
public class EstadoViewHelper {
    public static void updateTable(EstadoViewModel estadoView){
        new EstadoDAO().fillTable(estadoView.table, "");
    }
    
    public static void initButtons(
            EstadoViewModel estadoView
    ){
        ViewHelper.initButtons(
                estadoView.btnEditar,
                estadoView.btnExcluir,
                estadoView.btnPesquisar,
                estadoView.btnLimparBusca
        );
        
        ViewHelper.initFormButtons(
                estadoView.btnLimparFormulario,
                estadoView.btnCadastrar
        );
    }
    
    public static void resetInputs(EstadoViewModel estadoView){
        estadoView.campoId.setText("");
        estadoView.campoNome.setText("");
        estadoView.campoSigla.setText("");
        estadoView.campoPesquisar.setText("");
    }
    
    public static void cadastrarEstado(EstadoViewModel estadoView){
        if(estadoView.campoSigla.getText().length() > 2){
            JOptionPane.showMessageDialog(null, "O campo \"sigla\" deve ter no máximo dois caracteres", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(estadoView.campoSigla.getText().length() < 2){
            JOptionPane.showMessageDialog(null, "O campo \"sigla\" deve ter ao menos dois caracteres", "Erro de cadastro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Estado estado = new Estado();
        estado.id = (estadoView.campoId.getText().equals("")) ? 0 : Integer.parseInt(estadoView.campoId.getText());
        estado.sigla = estadoView.campoSigla.getText().toUpperCase();
        estado.nome = estadoView.campoNome.getText();
        if(estado.id == 0){
            if(EstadoValidator.insert(estado)){
                new EstadoDAO().save(estado);
            }else{
                return;
            }
        }else{
            if(EstadoValidator.update(estado)){
                new EstadoDAO().update(estado);
            }else{
                return;
            }
        }
        EstadoViewHelper.updateTable(estadoView);
        EstadoViewHelper.resetInputs(estadoView);
        estadoView.abasDoSistema.PAINEL.setSelectedIndex(estadoView.abasDoSistema.VIEW_ID);
    }
    
    public static void excluir(EstadoViewModel estadoView){
        Estado estado = new Estado();
        estado.id = Integer.parseInt(
                String.valueOf(estadoView.table.getValueAt(estadoView.table.getSelectedRow(), 0)));
        estado.sigla = String.valueOf(estadoView.table.getValueAt(estadoView.table.getSelectedRow(), 1));
        estado.nome = String.valueOf(estadoView.table.getValueAt(estadoView.table.getSelectedRow(), 2));
        
        if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?") == JOptionPane.OK_OPTION){
            new EstadoDAO().delete(estado);
            EstadoViewHelper.updateTable(estadoView);
        }
    }
    
    public static void editar(EstadoViewModel estadoView){
        Estado estado = new Estado();
        estado.id = Integer.parseInt(
                String.valueOf(estadoView.table.getValueAt(estadoView.table.getSelectedRow(), 0)));
        estado.sigla = String.valueOf(estadoView.table.getValueAt(estadoView.table.getSelectedRow(), 1));
        estado.nome = String.valueOf(estadoView.table.getValueAt(estadoView.table.getSelectedRow(), 2));
        
        estadoView.campoId.setText(estado.id + "");
        estadoView.campoSigla.setText(estado.sigla);
        estadoView.campoNome.setText(estado.nome);
        
        estadoView.abasDoSistema.PAINEL.setSelectedIndex(estadoView.abasDoSistema.FORM_ID);
    }
}
