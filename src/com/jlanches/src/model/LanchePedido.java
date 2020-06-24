/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.model;

import com.jlanches.src.constants.Operation;

/**
 *
 * @author arthur
 */
public class LanchePedido {

    public int id;
    public int lanche_id;
    public int pedido_id;
    public int quantidade;
    public double valor;
    public double desconto;
    public double acrescimo;
    public String modificacoes;

    public Operation estado;
}
