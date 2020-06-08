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
import src.model.Cidade;
import src.model.views.CidadeViewModel;
import src.validators.testers.CidadeValidator;
import src.views.extensionElements.ComboItem;

/**
 *
 * @author arthur
 */
public class CidadeViewHelper {
    
    public static void initButtons(
            CidadeViewModel cidadeView
    ){
        ViewHelper.initButtons(cidadeView.btnEditar,
                cidadeView.btnExcluir,
                cidadeView.btnPesquisar,
                cidadeView.btnLimparBusca
        );
    }
    
    public static void resetCidadeInputs(
            CidadeViewModel cidadeView
    ){
        cidadeView.campoCidadeId.setText("");
        cidadeView.campoPesquisarCidades.setText("");
        cidadeView.campoCidadeNome.setText("");
    }
    
    public static void updateTable(CidadeViewModel cidadeView){
        new CidadeDAO().fillTable(cidadeView.table, "");
    }
    
    public static void cadastrarCidade(CidadeViewModel cidadeView){
        Cidade cidade = new Cidade();
        cidade.id = (cidadeView.campoCidadeId.getText().equals("")) ? 0 : Integer.parseInt(cidadeView.campoCidadeId.getText());
        cidade.nome = cidadeView.campoCidadeNome.getText();
        ComboItem estado = (ComboItem) cidadeView.selectEstado.getSelectedItem();
        
        cidade.estado_id = estado.id;
        
        if(cidade.id == 0){
            if(CidadeValidator.insert(cidade)){
                new CidadeDAO().save(cidade);
            }else{
                return;
            }
        }else{
            if(CidadeValidator.update(cidade)){
                new CidadeDAO().update(cidade);
            }else{
                return;
            }
        }
        
        CidadeViewHelper.updateTable(cidadeView);
        
        CidadeViewHelper.resetCidadeInputs(cidadeView);
        cidadeView.abasDoSistema.setSelectedIndex(0);
    }
}
