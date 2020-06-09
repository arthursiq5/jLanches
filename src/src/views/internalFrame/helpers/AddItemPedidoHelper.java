/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.views.internalFrame.helpers;

import src.constants.FormaDePagamento;
import src.dao.LancheDAO;
import src.helpers.ComboHelper;
import src.helpers.ViewHelper;
import src.model.views.AddItemPedidoModel;

/**
 *
 * @author arthur
 */
public class AddItemPedidoHelper {
    public static void initButtons(AddItemPedidoModel addItemPedido){
        ViewHelper.setSubmitButtonStyle(addItemPedido.btnAdicionar);
        ViewHelper.setCancel64ButtonStyle(addItemPedido.btnCancelar);
        ViewHelper.setSearch64ButtonStyle(addItemPedido.btnShowLanche);
    }
    
    public static void initSelect(AddItemPedidoModel addItemPedido){
        /*FormaDePagamento[] itens = new FormaDePagamento[4];
        itens[0] = FormaDePagamento.A_VISTA;
        itens[1] = FormaDePagamento.CARTAO_DE_CREDITO;
        itens[2] = FormaDePagamento.CARTAO_DE_DEBITO;
        itens[3] = FormaDePagamento.CHEQUE;
        ComboHelper.fillCombo(addItemPedido.selectLanche, itens);*/
        
        new LancheDAO().fillCombo(addItemPedido.selectLanche);
    }
}
