/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.dao;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author arthur
 */
public class BDConnector {
    
    private static BDConnector instance = null;
    private Connection connection = null;
    
    public BDConnector(){
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("db.properties"));
            String dbdriver = prop.getProperty("db.driver");
            String dburl = prop.getProperty("db.url");
            String dbuser = prop.getProperty("db.user");
            String dbpassword = "qwer1234";
            
            Class.forName(dbdriver);
            
            if(dbuser.length() != 0){
                this.connection = DriverManager.getConnection(dburl, dbuser, dbpassword);
            }else{
                this.connection = DriverManager.getConnection(dburl);
            }
            JOptionPane.showMessageDialog(null, "deu certo");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao conectar na base de dados",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
            System.err.println(e);
        }
    }
    
    public static BDConnector getInstance(){
        if(instance == null)
            instance = new BDConnector();
        return instance;
    }
    
    public Connection getConnection(){
        if(this.connection == null)
            throw new RuntimeException("Conexão perdida");
        return this.connection;
    }
    
    public void shutDown(){
        try {
            this.connection.close();
            instance = null;
            this.connection = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao encerrar a conexão",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
            System.err.println(e);
        }
    }
}
