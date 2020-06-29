/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.helpers;

import com.jlanches.src.model.LanchePedido;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arthur
 */
public class TableHelper {

    public static void populaTabelaLanchePedido(JTable tabela, ArrayList<LanchePedido> pedidos) {
        System.out.println("executou");
        tabela.setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int arg0, int arg1) {
                return false;
            }

            {
                Object[][] matriz = new Object[pedidos.size()][LanchePedido.CABECALHO_DA_TABELA.length];
                for (int i = 0; i < pedidos.size(); i++) {
                    matriz[i] = new Object[]{
                        pedidos.get(i).getValorTotal(),
                        pedidos.get(i).getNomeDoLanche(),
                        pedidos.get(i).quantidade,
                        pedidos.get(i).modificacoes
                    };
                    
                }
                setDataVector(matriz, LanchePedido.CABECALHO_DA_TABELA);
            }

        });
    }
}
