/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.model;

/**
 *
 * @author arthur
 */
public class Cliente {

    public String cpfEditar;
    public String cpf;
    public String nome;
    public String endereco;
    public int cidade_id;
    public int contato_id;

    public Cliente() {
        this.cpf = "";
        this.nome = "";
        this.endereco = "";
        this.cidade_id = 0;
        this.contato_id = 0;
    }

    @Override
    public String toString() {
        return this.nome + " | " + this.cpf;
    }

}
