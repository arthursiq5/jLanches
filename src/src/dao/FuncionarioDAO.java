/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.dao;

import java.util.ArrayList;
import src.model.Funcionario;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import src.helpers.MessageHelper;

/**
 *
 * @author arthur
 */
public class FuncionarioDAO implements ModelDAO<Funcionario>{
    
    private ResultSet resultadoQuery = null;

    @Override
    public void save(Funcionario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Funcionario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Funcionario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Funcionario> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Funcionario> search(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean autenticate(String cpf, String senha){
        try {
            Statement statement = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = ""
                    + "SELECT * "
                    + "FROM funcionario "
                    + "WHERE "
                    + "cpf LIKE '" + cpf +"' AND "
                    + "senha LIKE MD5('" + senha +"')";
            
            System.out.println("SQL: " + sql);
            
            this.resultadoQuery = statement.executeQuery(sql);
            
            return this.resultadoQuery.next();
            
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao autenticar");
            System.err.println("Erro ao autenticar: \n" + e);
            return false;
        }
    }
}
