/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model;

import java.util.ArrayList;
import java.util.Date;
import src.constants.FormaDePagamento;
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
    
    public ArrayList<LanchePedido> itens;
    
    public Pedido(){
        this.itens = new ArrayList<LanchePedido>();
    }
}
