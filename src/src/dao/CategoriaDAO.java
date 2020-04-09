/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.dao;

import java.util.ArrayList;
import src.model.Categoria;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author arthur
 */
public class CategoriaDAO implements ModelDAO<Categoria> {
    
    private ResultSet resultadoQuery = null;

    @Override
    public void save(Categoria objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = "INSERT INTO categoria (id, nome) VALUES ("
                        + "DEFAULT, "
                        + "'" + objeto.nome + "')";
            st.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Erro ao inserir dados no banco", 
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE
            );
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void update(Categoria objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = "UPDATE categoria "
                        + "SET nome = '" + objeto.nome + "' "
                        + "WHERE id = '" + objeto.id + "'";
            st.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Erro ao inserir dados no banco", 
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE
            );
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void delete(Categoria objeto) {
        try {
            String sql = "DELETE "
                    + "FROM categoria "
                    + "WHERE id = '" + objeto.id + "'";
            BDConnector.getInstance()
                        .getConnection()
                        .createStatement()
                        .executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Erro ao remover dados do banco", 
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE
            );
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public ArrayList<Categoria> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Categoria> search(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void fillTable(JTable table, String criteria){
        Object [][] dadosTabela = null;
        Object [] cabecalho = new Object[2];
        cabecalho[0] = "ID";
        cabecalho[1] = "Sigla";
        
        String like = criteria.equals("") ? "" : ("WHERE UCASE(nome) LIKE UCASE('%" + criteria + "%')");
        
        try {
            this.resultadoQuery = BDConnector.getInstance()
                                    .getConnection()
                                    .createStatement()
                                    .executeQuery(""
                                            + "SELECT count(*) "
                                            + "FROM categoria "
                                            + like
                                    );
            
            this.resultadoQuery.next();
            
            dadosTabela = new Object[this.resultadoQuery.getInt(1)][2];
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Erro ao puxar dados do banco", 
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE
            );
            System.err.println("Erro: \n" + e);
        }
        
        try {
            this.resultadoQuery = BDConnector.getInstance()
                                    .getConnection()
                                    .createStatement()
                                    .executeQuery(""
                                            + "SELECT * "
                                            + "FROM categoria "
                                            + like
                                    );
            int line = 0;
            while(this.resultadoQuery.next()){
                dadosTabela[line][0] = this.resultadoQuery.getInt("id");
                dadosTabela[line][1] = this.resultadoQuery.getString("nome");
                line++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Erro ao puxar dados do banco", 
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE
            );
            System.err.println("Erro: \n" + e);
        }
        
        table.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        
        table.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }
    }
}
