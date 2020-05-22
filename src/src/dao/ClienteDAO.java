/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.dao;

import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import src.dao.models.ModelWithComboDao;
import src.helpers.MessageHelper;
import src.model.Cliente;
import src.model.Estado;
import src.views.extensionElements.ComboItem;

/**
 *
 * @author arthur
 */
public class ClienteDAO implements ModelWithComboDao<Cliente> {
    
    private ResultSet resultadoQuery = null;

    @Override
    public void save(Cliente objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = "INSERT INTO cliente (cpf, nome, endereco, cidade_id, contato_id) VALUES "+
                    " ("
                        + "'" + objeto.cpf +"', "
                        + "'" + objeto.nome  + "', "
                        + "'" + objeto.endereco  + "', "
                        + "'" + objeto.cidade_id  + "', "
                        + "'" + objeto.contato_id  + "' "
                    + ")";
            System.out.println(sql);
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao inserir dados de cliente do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void update(Cliente objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = "" 
                + "UPDATE estado "
                + "SET " 
                            + " cpf = '"  + objeto.cpf + "', "
                            + " nome = '" + objeto.nome + "', "
                        + " endereco = '" + objeto.endereco + "', "
                       + " cidade_id = '" + objeto.cidade_id + "', "
                      + " contato_id = '" + objeto.contato_id + "', "
                + "WHERE cpf = '" + objeto.cpfEditar + "'";
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao atualizar dados de cliente do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void delete(Cliente objeto) {
        try {
            String sql = "DELETE "
                    + "FROM cliente "
                    + "WHERE cpf = '" + objeto.cpf + "'";
            BDConnector.getInstance()
                        .getConnection()
                        .createStatement()
                        .executeUpdate(sql);
        }catch(SQLIntegrityConstraintViolationException e){
            MessageHelper.createInfoMessage(
                "Falha", 
                "Não foi possível remover o cliente, pois ele está atrelado a um pedido"
            );
            System.err.println("Falha: " + e);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao remover dados de cliente do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public ArrayList<Cliente> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cliente> search(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente get(String id) {
        Cliente cliente = new Cliente();
        try {
            Statement statement = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = ""
                    + "SELECT * "
                    + "FROM cliente "
                    + "WHERE "
                    + "cpf LIKE '" + id +"'";
            
            System.out.println("SQL: " + sql);
            
            this.resultadoQuery = statement.executeQuery(sql);
            
            this.resultadoQuery.next();
            
            cliente.cpf = this.resultadoQuery.getString("cpf");
            cliente.nome = this.resultadoQuery.getString("nome");
            cliente.endereco = this.resultadoQuery.getString("endereco");
            cliente.cidade_id = this.resultadoQuery.getInt("cidade_id");
            cliente.contato_id = this.resultadoQuery.getInt("contato_id");
            
            
        } catch (Exception e) {
            MessageHelper.createWarningMessage(
                    "Aviso", 
                    "Houveram problemas ao recuperar os estados do banco.\n"
                  + "Por favor, tente novamente mais tarde"
            );
            System.err.println("Erro: \n" + e);
        }
        return cliente;
    }
    
    public void fillTable(JTable table, String criteria){
        Object [][] dadosTabela = null;
        Object [] cabecalho = new Object[5];
        cabecalho[0] = "CPF";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Endereço";
        cabecalho[3] = "Cidade";
        cabecalho[4] = "Contato";
        
        String like = criteria.equals("") 
                ? "" 
                : ("WHERE "
                + "UCASE(nome) LIKE UCASE('%" + criteria + "%') OR"
                + "UCASE(cpf) LIKE UCASE('%" + criteria + "%') OR"
                + "UCASE(endereco) LIKE UCASE('%" + criteria + "%') OR"
                + "");
        
        try {
            this.resultadoQuery = BDConnector.getInstance()
                                    .getConnection()
                                    .createStatement()
                                    .executeQuery(""
                                            + "SELECT count(*) "
                                            + "FROM cliente "
                                            + like
                                    );
            
            this.resultadoQuery.next();
            
            dadosTabela = new Object[this.resultadoQuery.getInt(1)][5];
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao puxar dados de clientes do banco");
            System.err.println("Erro: \n" + e);
        }
        
        try {
            this.resultadoQuery = BDConnector.getInstance()
                                    .getConnection()
                                    .createStatement()
                                    .executeQuery(""
                                            + "SELECT * "
                                            + "FROM cliente "
                                            + like
                                    );
            int line = 0;
            while(this.resultadoQuery.next()){
                Cliente cliente = new Cliente();
                cliente.cpf = this.resultadoQuery.getString("cpf");
                cliente.nome = this.resultadoQuery.getString("nome");
                cliente.endereco = this.resultadoQuery.getString("endereco");
                cliente.cidade_id = this.resultadoQuery.getInt("cidade_id");
                cliente.contato_id = this.resultadoQuery.getInt("contato_id");
            
                dadosTabela[line][0] = cliente.cpf;
                dadosTabela[line][1] = cliente.nome;
                dadosTabela[line][2] = cliente.endereco;
                dadosTabela[line][3] = new CidadeDAO().get(cliente.cidade_id + "");
                dadosTabela[line][4] = new ContatoDAO().get(cliente.contato_id + "");
                line++;
            }
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao puxar dados de clientes do banco");
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
                            "SELECT * FROM cliente"
                    );
            if(this.resultadoQuery.isBeforeFirst()){
                while(this.resultadoQuery.next()){
                    Cliente cliente = new Cliente();
                    cliente.cpf = this.resultadoQuery.getString("cpf");
                    cliente.nome = this.resultadoQuery.getString("nome");
                    cliente.endereco = this.resultadoQuery.getString("endereco");
                    cliente.cidade_id = this.resultadoQuery.getInt("cidade_id");
                    cliente.contato_id = this.resultadoQuery.getInt("contato_id");
                    item = new ComboItem();
                    
                    item.cpf = cliente.cpf;
                    item.descricao = cliente.toString();
            
                    combo.addItem(item);
                }
            }
            
            
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao tentar popular o campo \"select\"");
            System.err.println("Erro: \n" + e);
        }
    }
}
