/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import com.jlanches.src.dao.models.ModelWithComboDao;
import com.jlanches.src.helpers.MessageHelper;
import com.jlanches.src.model.Franquia;
import com.jlanches.src.views.extension.elements.ComboItem;

/**
 *
 * @author arthur
 */
public class FranquiaDAO implements ModelWithComboDao<Franquia> {
    private ResultSet resultadoQuery = null;

    @Override
    public void save(Franquia objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = "INSERT INTO franquia"
                    +" (id, endereco, cnpj, ativo, cidade_id) "
                    + "VALUES ("
                    + "DEFAULT, "
                    + "'" + objeto.endereco + "', "
                    + "'" + objeto.cnpj + "', "
                    + "" + objeto.ativo + ", "
                    + objeto.cidade_id
                    + ")";
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao inserir dados de estados do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void update(Franquia objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = "UPDATE franquia SET "
                        + "cnpj = '" + objeto.cnpj + "', "
                        + "endereco = '" + objeto.endereco + "', "
                        + "ativo = " + objeto.ativo + ", "
                        + "cidade_id = " + objeto.cidade_id + " "
                    + "WHERE id = " + objeto.id;
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao atualizar dados de estados do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void delete(Franquia objeto) {
        try {
            String sql = "DELETE "
                    + "FROM franquia "
                    + "WHERE id = '" + objeto.id + "'";
            BDConnector.getInstance()
                        .getConnection()
                        .createStatement()
                        .executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao remover dados de franquias do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public ArrayList<Franquia> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Franquia> search(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Franquia get(String id) {
        Franquia franquia = new Franquia();
        try {
            Statement statement = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = ""
                    + "SELECT * "
                    + "FROM franquia "
                    + "WHERE "
                    + "id LIKE '" + id +"'";
            
            
            this.resultadoQuery = statement.executeQuery(sql);
            
            this.resultadoQuery.next();
            
            franquia.id = this.resultadoQuery.getInt("id");
            franquia.endereco = this.resultadoQuery.getString("endereco");
            franquia.cnpj = this.resultadoQuery.getString("cnpj");
            franquia.ativo = this.resultadoQuery.getBoolean("ativo");
            franquia.cidade_id = this.resultadoQuery.getInt("cidade_id");
            
        } catch (Exception e) {
            MessageHelper.createWarningMessage(
                    "Aviso", 
                    "Houveram problemas ao recuperar as franquias do banco.\n"
                  + "Por favor, tente novamente mais tarde"
            );
            System.err.println("Erro: \n" + e);
            franquia.id = 0;
            franquia.endereco = "erro";
            franquia.cnpj = "erro";
            franquia.ativo = false;
            franquia.cidade_id = 0;
        }
        return franquia;
    }
    
    public void fillTable(JTable table, String criteria){
        Object [][] dadosTabela = null;
        Object [] cabecalho = new Object[5];
        cabecalho[0] = "ID";
        cabecalho[1] = "Nome";
        cabecalho[2] = "CNPJ";
        cabecalho[3] = "Endereço";
        cabecalho[4] = "Ativo";
        
        try {
            this.resultadoQuery = BDConnector.getInstance()
                                    .getConnection()
                                    .createStatement()
                                    .executeQuery(""
                                            + "SELECT count(*) "
                                            + "FROM franquia "
                                    );
            
            this.resultadoQuery.next();
            
            dadosTabela = new Object[this.resultadoQuery.getInt(1)][5];
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
                                            + "FROM franquia "
                                    );
            int line = 0;
            while(this.resultadoQuery.next()){
                Franquia franquia = new Franquia();
                franquia.id = this.resultadoQuery.getInt("id");
                franquia.endereco = this.resultadoQuery.getString("endereco");
                franquia.cnpj = this.resultadoQuery.getString("cnpj");
                franquia.ativo = this.resultadoQuery.getBoolean("ativo");
                franquia.cidade_id = this.resultadoQuery.getInt("cidade_id");
                
                dadosTabela[line][0] = franquia.id;
                dadosTabela[line][1] = franquia;
                dadosTabela[line][2] = franquia.cnpj;
                dadosTabela[line][3] = franquia.endereco;
                dadosTabela[line][4] = franquia.ativo ? "ativo" : "inativo";
                line++;
            }
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao puxar dados de franquias do banco");
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

    @Override
    public void fillCombo(JComboBox combo) {
        combo.removeAllItems();
        
        ComboItem item = new ComboItem();
        item.id = 0;
        item.descricao = "Selecione";
        combo.addItem(item);
        
        try {
            
            this.resultadoQuery = new BDConnector()
                    .getConnection()
                    .createStatement()
                    .executeQuery("" +
                            "SELECT * FROM franquia"
                    );
            if(this.resultadoQuery.isBeforeFirst()){
                while(this.resultadoQuery.next()){
                    
                    Franquia franquia = new Franquia();
                    franquia.id = this.resultadoQuery.getInt("id");
                    franquia.endereco = this.resultadoQuery.getString("endereco");
                    franquia.cnpj = this.resultadoQuery.getString("cnpj");
                    franquia.ativo = this.resultadoQuery.getBoolean("ativo");
                    franquia.cidade_id = this.resultadoQuery.getInt("cidade_id");
                    
                    item = new ComboItem(
                        franquia.id, 
                        franquia.toString()
                    );
            
                    combo.addItem(item);
                }
            }
            
            
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao tentar popular o campo \"select\"");
            System.err.println("Erro: \n" + e);
        }
    }
}
