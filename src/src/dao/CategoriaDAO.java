/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.dao;

import src.dao.models.ModelDAO;
import java.util.ArrayList;
import src.model.Categoria;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import src.helpers.MessageHelper;
import src.views.extensionElements.ComboItem;

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
            MessageHelper.createErrorMessage("Erro", "Erro ao inserir dados de categorias do banco");
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
            MessageHelper.createErrorMessage("Erro", "Erro ao atualizar dados de categorias do banco");
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
            MessageHelper.createErrorMessage("Erro", "Erro ao remover dados de categorias do banco");
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
        Categoria categoria = new Categoria();
        
        try{
            Statement statement = BDConnector.getInstance().getConnection().createStatement();
            String sql = ""
                    + "SELECT * "
                    + "FROM categoria "
                    + "WHERE "
                    + "id LIKE '"+ id +"'";
            
            System.out.println(sql);
            
            this.resultadoQuery = statement.executeQuery(sql);
            
            this.resultadoQuery.next();
            
            categoria.id = this.resultadoQuery.getInt("id");
            categoria.nome = this.resultadoQuery.getString("nome");
            
        }catch(Exception e){
            categoria.id = 0;
            categoria.nome = "";
            
            MessageHelper.createErrorMessage("Erro", "Erro ao puxar categorias do banco\n"
                    + "Por favor, tente novamente mais parte");
            System.err.println("Erro: \n" + e);
        }
        
        return categoria;
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
            MessageHelper.createErrorMessage("Erro", "Erro ao puxar dados de categorias do banco");
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
            MessageHelper.createErrorMessage("Erro", "Erro ao puxar dados de categorias do banco");
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
                            "SELECT * FROM contato"
                    );
            if(this.resultadoQuery.isBeforeFirst()){
                while(this.resultadoQuery.next()){
                    Categoria categoria = new Categoria();
                        categoria.id = this.resultadoQuery.getInt("id");
                        categoria.nome = this.resultadoQuery.getString("fone");
                    
                    item = new ComboItem(
                        categoria.id,
                        categoria + ""
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
