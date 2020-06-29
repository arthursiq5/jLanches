/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.model;

import com.jlanches.src.constants.Operation;
import com.jlanches.src.dao.LancheDAO;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 *
 * @author arthur
 */
public class LanchePedido {
    
    public static final String[] CABECALHO_DA_TABELA = {
        "valor",
        "nome do lanche",
        "quantidade",
        "modificações"
    };
    
    public static final DecimalFormat decimalFormat = new DecimalFormat(",##0.00");

    public int id;
    public int lanche_id;
    public int pedido_id;
    public int quantidade;
    public double valor;
    public double desconto;
    public double acrescimo;
    public String modificacoes;

    public Operation estado;
    
    public String getValorTotal(){
        return "R$ " 
            + LanchePedido.decimalFormat.format(this.valor + this.acrescimo - this.desconto)
                .replace(".", "AUX")
                .replace(",", ".")
                .replace("AUX", ",");
    }
    
    public String getNomeDoLanche(){
        return ((Lanche) new LancheDAO().get(this.lanche_id + "")).nome;
    }
    
    public static void main(String[] args) {
        LanchePedido lanchePedido = new LanchePedido();
        
        lanchePedido.acrescimo = 0.451123512;
        lanchePedido.desconto = 0;
        lanchePedido.lanche_id = 1;
        lanchePedido.valor = new LancheDAO().get(lanchePedido.lanche_id + "").valor;
        
        System.out.println(lanchePedido.getValorTotal());
        System.out.println(lanchePedido.getNomeDoLanche());
    }
}
