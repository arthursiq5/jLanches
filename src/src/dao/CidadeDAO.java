/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import src.dao.models.ModelWithComboDao;
import src.helpers.MessageHelper;
import src.model.Cidade;
import src.model.Estado;
import src.views.extensionElements.ComboItem;

/**
 *
 * @author arthur
 */
public class CidadeDAO implements ModelWithComboDao<Cidade> {
    private ResultSet resultadoQuery = null;

    @Override
    public void save(Cidade objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = "INSERT INTO cidade (id, nome, estado_id) VALUES ("
                        + "DEFAULT, "
                        + "'" + objeto.nome + "', " 
                        + objeto.estado_id + ")";
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao inserir dados de cidades do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void update(Cidade objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = "UPDATE cidade "
                        + "SET nome = '" + objeto.nome + "' "
                        + "SET estado_id = '" + objeto.estado_id + "' "
                        + "WHERE id = '" + objeto.id + "'";
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao atualizar dados de cidades do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void delete(Cidade objeto) {
        try {
            String sql = "DELETE "
                    + "FROM cidade "
                    + "WHERE id = '" + objeto.id + "'";
            BDConnector.getInstance()
                        .getConnection()
                        .createStatement()
                        .executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao remover dados de cidades do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public ArrayList<Cidade> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cidade> search(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cidade get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void fillTable(JTable table, String criteria){
        Object [][] dadosTabela = null;
        Object [] cabecalho = new Object[3];
        cabecalho[0] = "ID";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Estado";
        
        String like = criteria.equals("") ? "" : ("WHERE UCASE(nome) LIKE UCASE('%" + criteria + "%')");
        
        try {
            this.resultadoQuery = BDConnector.getInstance()
                                    .getConnection()
                                    .createStatement()
                                    .executeQuery(""
                                            + "SELECT count(*) "
                                            + "FROM cidade "
                                            + like
                                    );
            
            this.resultadoQuery.next();
            
            dadosTabela = new Object[this.resultadoQuery.getInt(1)][3];
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao puxar dados de cidades do banco");
            System.err.println("Erro: \n" + e);
        }
        
        try {
            this.resultadoQuery = BDConnector.getInstance()
                                    .getConnection()
                                    .createStatement()
                                    .executeQuery(""
                                            + "SELECT * "
                                            + "FROM cidade "
                                            + like
                                    );
            int line = 0;
            while(this.resultadoQuery.next()){
                dadosTabela[line][0] = this.resultadoQuery.getInt("id");
                dadosTabela[line][1] = this.resultadoQuery.getString("nome");
                dadosTabela[line][2] = new EstadoDAO().get(this.resultadoQuery.getInt("estado_id") + "");
                line++;
            }
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao puxar dados de cidades do banco");
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
                            "SELECT * FROM cidade"
                    );
            if(this.resultadoQuery.isBeforeFirst()){
                while(this.resultadoQuery.next()){
                    item = new ComboItem(
                        this.resultadoQuery.getInt(1),
                        (
                            this.resultadoQuery.getString(2)
                          + "/"
                          + new EstadoDAO().get(this.resultadoQuery.getInt("estado_id") + "")
                        )
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
