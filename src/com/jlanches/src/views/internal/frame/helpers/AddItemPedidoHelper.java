/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.views.internal.frame.helpers;

import com.jlanches.src.constants.FormaDePagamento;
import com.jlanches.src.dao.LancheDAO;
import com.jlanches.src.helpers.ComboHelper;
import com.jlanches.src.helpers.ViewHelper;
import com.jlanches.src.model.views.AddItemPedidoModel;

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
