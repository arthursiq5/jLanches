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
public class Funcionario {

    public String cpfEditar;
    public String cpf;
    public String nome;
    public String senha;
    public String endereco;
    public boolean ativo;
    public boolean administrador;
    public int cidade_id;
    public int franquia_id;
    public int contato_id;

    @Override
    public String toString() {
        return this.nome;
    }
}
