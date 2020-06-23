/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.helpers;

import java.util.ArrayList;
import javax.swing.JComboBox;
import com.jlanches.src.constants.Meses;
import com.jlanches.src.views.extension.elements.ComboItem;

/**
 *
 * @author arthur
 */
public class ComboHelper {
    
    public static void fillCombo(JComboBox combo, Object[] itens){
        combo.removeAllItems();
        for(Object item: itens){
            combo.addItem(item);
        }
    }
    
    public static void fillCombo(JComboBox combo, Meses[] itens){
        combo.removeAllItems();
        for(Meses item: itens){
            combo.addItem(new MonthHelper.ComboMonth(item));
        }
    }
    
    public static void fillCombo(JComboBox combo, int[] itens){
        combo.removeAllItems();
        for(Object item: itens){
            combo.addItem(item);
        }
    }
    
    public static void fillCombo(JComboBox combo, ArrayList<Object> itens){
        combo.removeAllItems();
        itens.forEach((item) -> {
            combo.addItem(item);
        });
    }
    
    public static void setIndexComboData(JComboBox combo, int id){
        int item;
        for (int i = 0; i < combo.getItemCount(); i++)
        {
            item = (int) combo.getItemAt(i);
            if (item == id)
            {
                combo.setSelectedIndex(i);
                break;
            }
        }
    }
    
    public static void setIndexComboMonth(JComboBox combo, Meses month){
        MonthHelper.ComboMonth item;
        for (int i = 0; i < combo.getItemCount(); i++)
        {
            item = (MonthHelper.ComboMonth)combo.getItemAt(i);
            if (item.mes == month)
            {
                combo.setSelectedIndex(i);
                break;
            }
        }
    }
    
    public static void setIndexComboMonth(JComboBox combo, int month){
        MonthHelper.ComboMonth item;
        for (int i = 0; i < combo.getItemCount(); i++)
        {
            item = (MonthHelper.ComboMonth)combo.getItemAt(i);
            if (item.mes.getGregorianMonth() == month)
            {
                combo.setSelectedIndex(i);
                break;
            }
        }
    }
    
    public static void setIndex(JComboBox combo, int id){
        ComboItem item;
        for (int i = 0; i < combo.getItemCount(); i++)
        {
            item = (ComboItem)combo.getItemAt(i);
            if (item.id == id)
            {
                combo.setSelectedIndex(i);
                break;
            }
        }
    }
    
    public static void setIndex(JComboBox combo, String cpf){
        ComboItem item;
        for (int i = 0; i < combo.getItemCount(); i++)
        {
            item = (ComboItem)combo.getItemAt(i);
            if (item.cpf.equalsIgnoreCase(cpf))
            {
                combo.setSelectedIndex(i);
                break;
            }
        }
    }
}
