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
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import src.dao.models.ModelWithComboDao;
import src.helpers.MessageHelper;
import src.views.extensionElements.ComboItem;

/**
 *
 * @author arthur
 */
public class EstadoDAO implements ModelWithComboDao<Estado> {
    
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
        Estado estado = new Estado();
        try {
            Statement statement = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = ""
                    + "SELECT * "
                    + "FROM estado "
                    + "WHERE "
                    + "id LIKE '" + id +"'";
            
            System.out.println("SQL: " + sql);
            
            this.resultadoQuery = statement.executeQuery(sql);
            
            this.resultadoQuery.next();
            
            estado = this.queryToObject();
            
            
        } catch (Exception e) {
            MessageHelper.createWarningMessage(
                    "Aviso", 
                    "Houveram problemas ao recuperar os estados do banco.\n"
                  + "Por favor, tente novamente mais tarde"
            );
            System.err.println("Erro: \n" + e);
        }
        return estado;
    }
    
    public void fillTable(JTable table, String criteria){
        Object [][] dadosTabela = null;
        Object [] cabecalho = new Object[3];
        cabecalho[0] = "ID";
        cabecalho[1] = "Sigla";
        cabecalho[2] = "Nome";
        
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
            
            dadosTabela = new Object[this.resultadoQuery.getInt(1)][3];
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
                Estado estado = this.queryToObject();
                dadosTabela[line][0] = estado.id;
                dadosTabela[line][1] = estado;
                dadosTabela[line][2] = estado.nome;
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
                            "SELECT * FROM estado"
                    );
            if(this.resultadoQuery.isBeforeFirst()){
                while(this.resultadoQuery.next()){
                    
                    item = new ComboItem(
                        this.resultadoQuery.getInt(1), 
                        this.resultadoQuery.getString(2)
                    );
            
                    combo.addItem(item);
                }
            }
            
            
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao tentar popular o campo \"select\"");
            System.err.println("Erro: \n" + e);
        }
    }
    
    private Estado queryToObject() throws Exception{
        try {
            Estado estado = new Estado();
            estado.id = this.resultadoQuery.getInt("id");
            estado.sigla = this.resultadoQuery.getString("sigla");
            estado.nome = this.resultadoQuery.getString("nome");
            return estado;
        } catch (Exception e) {
            System.err.println("Erro ao parsear objeto");
            throw e;
        }
        
    }
}
