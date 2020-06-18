/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.dao;

import java.util.ArrayList;
import src.model.Estado;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import src.constants.FormaDePagamento;
import src.dao.models.ModelDAO;
import src.dao.models.ModelWithComboDao;
import src.helpers.DateHelper;
import src.helpers.MessageHelper;
import src.model.Pedido;
import src.views.extensionElements.ComboItem;

/**
 *
 * @author arthur
 */
public class PedidoDAO implements ModelDAO<Pedido> {
    
    private ResultSet resultadoQuery = null;

    @Override
    public void save(Pedido objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = "INSERT INTO pedido " 
                + "(id, data, pago, formaDePagamento, comentarios, cliente_cpf, funcionario_cpf, franquia_id)"
                    + " VALUES ("
                        + "DEFAULT, "
                        + "'" + objeto.data + "', "
                        + "'" + objeto.pago + "', "
                        + "'" + objeto.formaDePagamento + "', "
                        + "'" + objeto.comentarios + "', "
                        + "'" + objeto.cliente_cpf + "', "
                        + "'" + objeto.funcionario_cpf + "', "
                        + "'" + objeto.franquia_id + "' "
                    + ")";
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao inserir dados de estados do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void update(Pedido objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = "UPDATE estado "
                        + "SET "
                            + "'" + objeto.data + "', "
                            + "'" + objeto.pago + "', "
                            + "'" + objeto.formaDePagamento + "', "
                            + "'" + objeto.comentarios + "', "
                            + "'" + objeto.cliente_cpf + "', "
                            + "'" + objeto.funcionario_cpf + "', "
                            + "'" + objeto.franquia_id + "' "
                        + "WHERE id = '" + objeto.id + "'";
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao atualizar dados de estados do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void delete(Pedido objeto) {
        try {
            String sql = "update pedido "
                    + "SET ativo = FALSE "
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
    public ArrayList<Pedido> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pedido> search(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pedido get(String id) {
        Pedido pedido = new Pedido();
        try {
            Statement statement = BDConnector.getInstance().getConnection().createStatement();
            
            String sql = ""
                    + "SELECT * "
                    + "FROM pedido "
                    + "WHERE "
                    + "id LIKE '" + id +"'"
                    + "AND ativo = TRUE";
            
            System.out.println("SQL: " + sql);
            
            this.resultadoQuery = statement.executeQuery(sql);
            
            this.resultadoQuery.next();
            
            pedido = this.queryToObject();
            
            
        } catch (Exception e) {
            MessageHelper.createWarningMessage(
                    "Aviso", 
                    "Houveram problemas ao recuperar os estados do banco.\n"
                  + "Por favor, tente novamente mais tarde"
            );
            System.err.println("Erro: \n" + e);
        }
        return pedido;
    }
    
    public void fillTable(JTable table, String criteria){
        Object [][] dadosTabela = null;
        Object [] cabecalho = new Object[7];
        cabecalho[0] = "ID";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Pago";
        cabecalho[3] = "Forma de Pagamento";
        cabecalho[4] = "Comentários";
        cabecalho[5] = "Funcionário";
        cabecalho[6] = "franquia";
        
        String like = criteria.equals("") ? "" : ("WHERE UCASE(sigla) LIKE UCASE('%" + criteria + "%')");
        
        try {
            this.resultadoQuery = BDConnector.getInstance()
                                    .getConnection()
                                    .createStatement()
                                    .executeQuery(""
                                            + "SELECT count(*) "
                                            + "FROM pedido "
                                            + like
                                    );
            
            this.resultadoQuery.next();
            
            dadosTabela = new Object[this.resultadoQuery.getInt(1)][7];
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
                                            + "FROM pedido "
                                            + like
                                    );
            int line = 0;
            while(this.resultadoQuery.next()){
                Pedido pedido = this.queryToObject();
                dadosTabela[line][0] = pedido.id;
                dadosTabela[line][1] = pedido;
                dadosTabela[line][2] = pedido.pago;
                dadosTabela[line][3] = pedido.formaDePagamento;
                dadosTabela[line][4] = pedido.comentarios;
                dadosTabela[line][5] = new FuncionarioDAO().get(pedido.funcionario_cpf);
                dadosTabela[line][6] = new FranquiaDAO().get(pedido.franquia_id + "");
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
    
    private Pedido queryToObject() throws Exception{
        try {
            Pedido pedido = new Pedido();
            pedido.id = this.resultadoQuery.getInt("id");
            pedido.data = DateHelper.stringToDate(this.resultadoQuery.getString("data"));
            pedido.pago = this.resultadoQuery.getBoolean("pago");
            pedido.formaDePagamento = this.getFormaPagamento();
            return pedido;
        } catch (Exception e) {
            System.err.println("Erro ao parsear objeto");
            throw e;
        }
        
    }
    
    private FormaDePagamento getFormaPagamento() throws SQLException{
        String formaDePagamento =  this.resultadoQuery.getString("forma_de_pagamento");
        if(FormaDePagamento.A_VISTA.toString().equals(formaDePagamento))
            return FormaDePagamento.A_VISTA;
        if(FormaDePagamento.CARTAO_DE_CREDITO.toString().equals(formaDePagamento))
            return FormaDePagamento.CARTAO_DE_CREDITO;
        if(FormaDePagamento.CARTAO_DE_DEBITO.toString().equals(formaDePagamento))
            return FormaDePagamento.CARTAO_DE_DEBITO;
        return FormaDePagamento.CHEQUE;
        
    }
}