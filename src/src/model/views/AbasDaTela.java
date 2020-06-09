/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.model.views;

import javax.swing.JTabbedPane;

/**
 *
 * @author arthur
 */
public class AbasDaTela {
    public final JTabbedPane PAINEL;
    public final int VIEW_ID;
    public final int FORM_ID;
    
    public AbasDaTela(JTabbedPane painel, int viewId, int formId){
        this.PAINEL = painel;
        this.VIEW_ID = viewId;
        this.FORM_ID = formId;
    }
}
