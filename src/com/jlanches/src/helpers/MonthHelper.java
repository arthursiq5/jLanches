/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.helpers;

import com.jlanches.src.constants.Meses;

/**
 *
 * @author arthur
 */
public class MonthHelper {
    public static class ComboMonth{
        public final Meses mes;
        public final String nome;
        public ComboMonth(Meses mes){
            this.mes = mes;
            this.nome = mes.toString();
        }
        
        public String toString(){
            return this.nome;
        }
    }
}
