/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.dao;

import src.dao.models.ModelDAO;
import java.util.ArrayList;
import src.model.Funcionario;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import src.dao.models.ModelWithComboDao;
import src.helpers.MessageHelper;
import src.model.Cliente;
import src.views.extensionElements.ComboItem;

/**
 *
 * @author arthur
 */
public class FuncionarioDAO implements ModelWithComboDao<Funcionario>{
    
    private ResultSet resultadoQuery = null;

    @Override
    public void save(Funcionario objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = "INSERT INTO funcionario "
                + "(cpf, nome, senha, endereco, cidade_id, contato_id, franquia_id) VALUES "+
                    " ("
                        + "'" + objeto.cpf +"', "
                        + "'" + objeto.nome  + "', "
                        + "MD5('" + objeto.senha + "'), "
                        + "'" + objeto.endereco  + "', "
                        + "'" + objeto.cidade_id  + "', "
                        + "'" + objeto.contato_id  + "', "
                        + "'" + objeto.franquia_id + "' "
                    + ")";
            System.out.println(sql);
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao inserir dados do funcionário do banco");
            System.err.println("Erro: " + e);
        }
    }
    
    public void deleteWithAuthentication(Funcionario funcionario, String senha){
        if(this.autenticate(funcionario.cpf, senha))
            this.delete(funcionario);
    }
    
    public void updateWithAuthentication(Funcionario funcionario, String senha){
        if(this.autenticate(funcionario.cpf, senha))
            this.update(funcionario);
    }

    @Override
    public void update(Funcionario objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = "" 
                + "UPDATE funcionario "
                + "SET " 
                            + " cpf = '"  + objeto.cpf + "', "
                            + " nome = '" + objeto.nome + "', "
                        + " endereco = '" + objeto.endereco + "', "
                       + " cidade_id = '" + objeto.cidade_id + "', "
                      + " contato_id = '" + objeto.contato_id + "', "
                     + " franquia_id = '" + objeto.franquia_id + "', "
                       + " senha = MD5('" + objeto.senha + "') "
                + "WHERE cpf = '" + objeto.cpfEditar + "'";
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao atualizar dados de cliente do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void delete(Funcionario objeto) {
        try {
            String sql = "DELETE "
                    + "FROM funcionario "
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
    public ArrayList<Funcionario> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Funcionario> search(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario get(String id) {
        Funcionario funcionario;
        try {
            Statement statement = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = ""
                    + "SELECT * "
                    + "FROM funcionario "
                    + "WHERE "
                    + "cpf LIKE '" + id +"'";
            
            System.out.println("SQL: " + sql);
            
            this.resultadoQuery = statement.executeQuery(sql);
            
            this.resultadoQuery.next();
            
            funcionario = this.queryToFuncionario();
            
        } catch (Exception e) {
            MessageHelper.createWarningMessage(
                    "Aviso", 
                    "Houveram problemas ao recuperar os estados do banco.\n"
                  + "Por favor, tente novamente mais tarde"
            );
            System.err.println("Erro: \n" + e);
            funcionario = new Funcionario();
        }
        return funcionario;
    }
    
    public void fillTable(JTable table, String criteria){
        Object [][] dadosTabela = null;
        Object [] cabecalho = new Object[6];
        cabecalho[0] = "CPF";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Endereço";
        cabecalho[3] = "Cidade";
        cabecalho[4] = "Contato";
        cabecalho[5] = "Franquia";
        
        String like = criteria.equals("") 
                ? "" 
                : ("WHERE "
                + "UCASE(nome) LIKE UCASE('%" + criteria + "%') OR"
                + "UCASE(cpf) LIKE UCASE('%" + criteria + "%') OR"
                + "UCASE(endereco) LIKE UCASE('%" + criteria + "%')"
                + "");
        
        try {
            this.resultadoQuery = BDConnector.getInstance()
                                    .getConnection()
                                    .createStatement()
                                    .executeQuery(""
                                            + "SELECT count(*) "
                                            + "FROM funcionario "
                                            + like
                                    );
            
            this.resultadoQuery.next();
            
            dadosTabela = new Object[this.resultadoQuery.getInt(1)][6];
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
                                            + "FROM funcionario "
                                            + like
                                    );
            int line = 0;
            while(this.resultadoQuery.next()){
                Funcionario funcionario = this.queryToFuncionario();
            
                dadosTabela[line][0] = funcionario.cpf;
                dadosTabela[line][1] = funcionario.nome;
                dadosTabela[line][2] = funcionario.endereco;
                dadosTabela[line][3] = new CidadeDAO().get(funcionario.cidade_id + "");
                dadosTabela[line][4] = new ContatoDAO().get(funcionario.contato_id + "");
                dadosTabela[line][5] = new FranquiaDAO().get(funcionario.franquia_id + "");
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
                            "SELECT * FROM funcionario"
                    );
            if(this.resultadoQuery.isBeforeFirst()){
                while(this.resultadoQuery.next()){
            
                    Funcionario funcionario = this.queryToFuncionario();
                    
                    item = new ComboItem();
                    
                    item.cpf = funcionario.cpf;
                    item.descricao = funcionario.toString();
            
                    combo.addItem(item);
                }
            }
            
            
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao tentar popular o campo \"select\"");
            System.err.println("Erro: \n" + e);
        }
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
    
    private Funcionario queryToFuncionario() throws Exception{
        Funcionario funcionario = new Funcionario();
        try {
            funcionario.cpf = this.resultadoQuery.getString("cpf");
            funcionario.nome = this.resultadoQuery.getString("nome");
            funcionario.endereco = this.resultadoQuery.getString("endereco");
            funcionario.cidade_id = this.resultadoQuery.getInt("cidade_id");
            funcionario.contato_id = this.resultadoQuery.getInt("contato_id");
            funcionario.franquia_id = this.resultadoQuery.getInt("franquia_id");
        } catch (Exception e) {
            System.err.println("Erro ao criar objeto");
            throw e;
        }
        return funcionario;
    }
}
