/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.dao;

import src.dao.models.ModelDAO;
import java.util.ArrayList;
import src.model.Estado;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import src.helpers.MessageHelper;

/**
 *
 * @author arthur
 */
public class EstadoDAO implements ModelDAO<Estado> {
    
    private ResultSet resultadoQuery = null;

    @Override
    public void save(Estado objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = "INSERT INTO estado (id, sigla) VALUES ("
                        + "DEFAULT, "
                        + "'" + objeto.sigla + "')";
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao inserir dados de estados do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void update(Estado objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = "UPDATE estado "
                        + "SET sigla = '" + objeto.sigla + "' "
                        + "WHERE id = '" + objeto.id + "'";
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao atualizar dados de estados do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void delete(Estado objeto) {
        try {
            String sql = "DELETE "
                    + "FROM estado "
                    + "WHERE id = '" + objeto.id + "'";
            BDConnector.getInstance()
                        .getConnection()
                        .createStatement()
                        .executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao remover dados de estados do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public ArrayList<Estado> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Estado> search(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void fillTable(JTable table, String criteria){
        Object [][] dadosTabela = null;
        Object [] cabecalho = new Object[2];
        cabecalho[0] = "ID";
        cabecalho[1] = "Sigla";
        
        String like = criteria.equals("") ? "" : ("WHERE UCASE(sigla) LIKE UCASE('%" + criteria + "%')");
        
        try {
            this.resultadoQuery = BDConnector.getInstance()
                                    .getConnection()
                                    .createStatement()
                                    .executeQuery(""
                                            + "SELECT count(*) "
                                            + "FROM estado "
                                            + like
                                    );
            
            this.resultadoQuery.next();
            
            dadosTabela = new Object[this.resultadoQuery.getInt(1)][2];
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao puxar dados de estados do banco");
            System.err.println("Erro: \n" + e);
        }
        
        try {
            this.resultadoQuery = BDConnector.getInstance()
                                    .getConnection()
                                    .createStatement()
                                    .executeQuery(""
                                            + "SELECT * "
                                            + "FROM estado "
                                            + like
                                    );
            int line = 0;
            while(this.resultadoQuery.next()){
                dadosTabela[line][0] = this.resultadoQuery.getInt("id");
                dadosTabela[line][1] = this.resultadoQuery.getString("sigla");
                line++;
            }
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao puxar dados de estados do banco");
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
