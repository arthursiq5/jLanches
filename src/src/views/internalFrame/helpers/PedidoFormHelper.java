/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.views.internalFrame.helpers;

import src.constants.Icons;
import src.constants.SystemColors;
import src.helpers.ViewHelper;
import src.model.views.PedidoFormModel;

/**
 *
 * @author arthur
 */
public class PedidoFormHelper {
    public static void initButtons(PedidoFormModel pedidoView){
        ViewHelper.initFormButtons(pedidoView.btnLimpar, pedidoView.btnCadastrar);
        ViewHelper.setButtonStyle(pedidoView.btnAdicionarItemAoPedido, SystemColors.LIGHT_GREEN, Icons.ADD_64);
        ViewHelper.setButtonStyle(pedidoView.btnMostrarItemPedido, SystemColors.SILVER, Icons.PESQUISAR_64);
    }
}
