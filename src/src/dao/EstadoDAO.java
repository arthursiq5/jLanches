/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.dao;

import java.util.ArrayList;
import src.model.Estado;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author arthur
 */
public class EstadoDAO implements ModelDAO<Estado> {
    
    private ResultSet resultadoQuery = null;

    @Override
    public void save(Estado objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Estado objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Estado objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        
        String ilike = criteria.equals("") ? "" : ("WHERE sigla ILIKE '%" + criteria + "%'");
        
        try {
            this.resultadoQuery = BDConnector.getInstance()
                                    .getConnection()
                                    .createStatement()
                                    .executeQuery(""
                                            + "SELECT count(*) "
                                            + "FROM estado "
                                            + ilike
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
                                            + "FROM estado "
                                            + ilike
                                    );
            int line = 0;
            while(this.resultadoQuery.next()){
                dadosTabela[line][0] = this.resultadoQuery.getInt("id");
                dadosTabela[line][1] = this.resultadoQuery.getString("sigla");
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
