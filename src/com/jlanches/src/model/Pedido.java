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
    public boolean ativo;
    public FormaDePagamento formaDePagamento;
    public String comentarios;
    public String cliente_cpf;
    public String funcionario_cpf;
    public int franquia_id;

    public ArrayList<LanchePedido> itens;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    @Override
    public String toString() {
        String mensagem = "Pedido do cliente "
                + new ClienteDAO().get(this.cliente_cpf).nome
                + " feito no dia "
                + DateHelper.dateToString(this.data);
        if(!this.ativo)
            mensagem = "(inativo) " + mensagem;
        return mensagem;
    }
}
