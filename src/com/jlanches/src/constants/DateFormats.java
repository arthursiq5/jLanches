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
public enum DateFormats {
    ISO_DATETIME("yyyy-MM-dd HH:mm:ss", ""),
    ISO_DATE("yyyy-MM-dd", "");

    //AAAA-MM-DD HH:MM:SS
    private final String format;
    private final String sql_placeholder;

    private DateFormats(String format, String sql_placeholder) {
        this.format = format;
        this.sql_placeholder = sql_placeholder;
    }

    @Override
    public String toString() {
        return this.format;
    }
}
