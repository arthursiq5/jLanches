/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.helpers;

import java.util.ArrayList;
import javax.swing.JComboBox;
import src.views.extensionElements.ComboItem;

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
    
    public static void fillCombo(JComboBox combo, ArrayList<Object> itens){
        combo.removeAllItems();
        itens.forEach((item) -> {
            combo.addItem(item);
        });
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
