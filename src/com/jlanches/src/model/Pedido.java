/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.jlanches.src.constants.FormaDePagamento;
import com.jlanches.src.dao.ClienteDAO;
import com.jlanches.src.dao.LancheDAO;
import com.jlanches.src.helpers.DateHelper;
/**
 *
 * @author arthur
 */
public class Pedido {
    public int id;
    public Date data;
    public boolean pago;
    public FormaDePagamento formaDePagamento;
    public String comentarios;
    public String cliente_cpf;
    public String funcionario_cpf;
    public int franquia_id;
    
    public Map<String, LanchePedido> itens;
    
    public Pedido(){
        this.itens = new HashMap<String, LanchePedido>();
    }
    
    @Override
    public String toString(){
        return "Pedido do cliente "
                + new ClienteDAO().get(this.cliente_cpf).nome
                + " feito no dia "
                + DateHelper.dateToString(this.data);
    }
}
