/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import src.constants.FormaDePagamento;
import src.dao.ClienteDAO;
import src.dao.LancheDAO;
import src.helpers.DateHelper;
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
    
    public String toString(){
        return "Pedido do cliente"
                + new ClienteDAO().get(this.cliente_cpf).nome
                + " feito no dia "
                + DateHelper.dateToString(this.data);
    }
}
