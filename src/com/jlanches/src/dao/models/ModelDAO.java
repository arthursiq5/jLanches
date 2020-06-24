/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.dao.models;

import java.util.ArrayList;

/**
 *
 * @author arthur
 */
public interface ModelDAO<T> {

    public void save(T objeto);

    public void update(T objeto);

    public void delete(T objeto);

    public ArrayList<T> getAll();

    public ArrayList<T> search(String criterio);

    public T get(String id);
}
