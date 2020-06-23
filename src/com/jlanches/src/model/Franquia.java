/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.model;

import com.jlanches.src.dao.CidadeDAO;
import com.jlanches.src.dao.EstadoDAO;

/**
 *
 * @author arthur
 */
public class Franquia {
    public int id;
    public String endereco;
    public String cnpj;
    public boolean ativo;
    public int cidade_id;
    
    @Override
    public String toString(){
        Cidade cidade = new CidadeDAO().get(this.cidade_id + "");
        Estado estado = new EstadoDAO().get(cidade.estado_id + "");
        String name =  "Franquia " + this.id + " de " + cidade + "/" + estado;
        return name;
    }
}
