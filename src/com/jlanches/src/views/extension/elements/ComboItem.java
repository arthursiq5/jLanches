/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.views.extension.elements;

/**
 *
 * @author arthur
 */
public class ComboItem {

    public int id = 0;
    public String cpf = "";
    public Object descricao = "";
    private boolean useCpf = false;

    public ComboItem() {
        this.id = 0;
        this.cpf = "";
        this.descricao = "";
    }

    public ComboItem(int id, Object descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public ComboItem(String cpf, Object descricao) {
        this.cpf = cpf;
        this.descricao = descricao;
        this.useCpf = true;
    }

    public String getId() {
        if (this.useCpf) {
            return this.cpf;
        }
        return this.id + "";
    }

    /**
     *
     * @return descricao
     */
    @Override
    public String toString() {
        return this.descricao + "";
    }
}
