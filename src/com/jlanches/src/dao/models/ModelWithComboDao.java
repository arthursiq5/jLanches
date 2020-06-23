/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.dao.models;

import javax.swing.JComboBox;

/**
 *
 * @author arthur
 */
public interface ModelWithComboDao<T> extends ModelDAO<T> {
    public void fillCombo(JComboBox combo);
}
