/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.constants;

/**
 *
 * @author arthur
 */
public enum Reports {
    EXEMPLO(Paths.REPORTS, "Exemplo"),
    CIDADE_ESTADO(Paths.ADDRESS_REPORTS, "cidade_estado"),
    CIDADE_ESTADO_BY_ID(Paths.ADDRESS_REPORTS, "cidade_estado_by_id"),
    FUNCIONARIOS(Paths.REPORTS, "funcionarios"),
    FUNCIONARIOS_ATIVOS(Paths.REPORTS, "funcionarios_ativos"),
    PEDIDO_GENERICO(Paths.PEDIDO_REPORTS, "pedido_geral"),
    PEDIDO_COMPLETO(Paths.PEDIDO_REPORTS, "pedido_cliente_funcionario_data_pago_forma_pagamento"),
    PEDIDO_CLIENTE_FUNCIONARIO_DATA(Paths.PEDIDO_REPORTS, "pedido_cliente_funcionario_data"),
    ERROR_REPORT(Paths.REPORTS, "error_report");

    private final Paths path;
    private final String name;

    private Reports(Paths path, String name) {
        this.name = name;
        this.path = path;
    }

    @Override
    public String toString() {
        return this.name + ".jrxml";
    }

    public String getFullPath() {
        return this.path + this.name + ".jrxml";
    }
}
