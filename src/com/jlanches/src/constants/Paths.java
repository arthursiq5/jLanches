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
public enum Paths {
    ICONS("/com/jlanches/media/icons/"),
    MAIN_ICONS("/com/jlanches/media/icons/main/"),
    REPORTS("/com/jlanches/reports/"),
    ADDRESS_REPORTS("/com/jlanches/reports/endereco/"),
    PEDIDO_REPORTS("/com/jlanches/reports/pedido/"),
    EFFECTS("/com/jlanches/media/sounds/effects/");

    String path;

    private Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    @Override
    public String toString() {
        return this.path;
    }
}
