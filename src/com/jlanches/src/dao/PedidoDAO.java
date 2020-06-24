/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.dao;

import java.util.ArrayList;
import com.jlanches.src.model.Estado;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import com.jlanches.src.constants.FormaDePagamento;
import com.jlanches.src.dao.models.ModelDAO;
import com.jlanches.src.dao.models.ModelWithComboDao;
import com.jlanches.src.helpers.DateHelper;
import com.jlanches.src.helpers.MessageHelper;
import com.jlanches.src.model.Cliente;
import com.jlanches.src.model.Pedido;
import com.jlanches.src.views.extension.elements.ComboItem;

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
                    + "(id, data, pago, forma_de_pagamento, comentarios, cliente_cpf, funcionario_cpf, franquia_id)"
                    + " VALUES ("
                    + "DEFAULT, "
                    + "'" + objeto.data + "', "
                    + "" + objeto.pago + ", "
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
                    + "id LIKE '" + id + "'"
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

    public void fillTable(JTable table, boolean showInactive, String criteria) {
        Object[][] dadosTabela = null;
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "ID";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Pago";
        cabecalho[3] = "Forma de Pagamento";
        cabecalho[4] = "Comentários";
        cabecalho[5] = "Funcionário";
        cabecalho[6] = "franquia";

        String like = criteria.equals("") ? "" : ("WHERE UCASE(descricao) LIKE UCASE('%" + criteria + "%')");

        if (!like.equals("") && !showInactive) {
            like += " AND ativo = TRUE";
        } else if (!showInactive) {
            like = "WHERE ativo = TRUE";
        }

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
            while (this.resultadoQuery.next()) {
                Pedido pedido = this.queryToObject();
                dadosTabela[line][0] = pedido.id;
                dadosTabela[line][1] = pedido;
                dadosTabela[line][2] = pedido.pago ? "sim" : "não";
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

    private Pedido queryToObject() throws Exception {
        try {
            Pedido pedido = new Pedido();
            pedido.id = this.resultadoQuery.getInt("id");
            pedido.data = DateHelper.stringToDate(this.resultadoQuery.getString("data"));
            pedido.pago = this.resultadoQuery.getBoolean("pago");
            pedido.cliente_cpf = this.resultadoQuery.getString("cliente_cpf");
            pedido.funcionario_cpf = this.resultadoQuery.getString("funcionario_cpf");
            pedido.franquia_id = this.resultadoQuery.getInt("franquia_id");
            pedido.comentarios = this.resultadoQuery.getString("comentarios");
            pedido.formaDePagamento = this.getFormaPagamento();
            return pedido;
        } catch (Exception e) {
            System.err.println("Erro ao parsear objeto");
            e.printStackTrace(System.err);
            throw e;
        }

    }

    private FormaDePagamento getFormaPagamento() throws SQLException {
        String formaDePagamento = this.resultadoQuery.getString("forma_de_pagamento");
        if (FormaDePagamento.A_VISTA.toString().equals(formaDePagamento)) {
            return FormaDePagamento.A_VISTA;
        }
        if (FormaDePagamento.CARTAO_DE_CREDITO.toString().equals(formaDePagamento)) {
            return FormaDePagamento.CARTAO_DE_CREDITO;
        }
        if (FormaDePagamento.CARTAO_DE_DEBITO.toString().equals(formaDePagamento)) {
            return FormaDePagamento.CARTAO_DE_DEBITO;
        }
        return FormaDePagamento.CHEQUE;

    }

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.cpf = "00000000000";
        cliente.nome = "teste";
        cliente.cidade_id = 1;
        cliente.contato_id = 1;
        cliente.endereco = "testeqwe123";

        //new ClienteDAO().save(cliente);
        Pedido pedido = new Pedido();
        pedido.cliente_cpf = cliente.cpf;
        pedido.data = new Date(System.currentTimeMillis());
        pedido.franquia_id = 1;
        pedido.funcionario_cpf = "99999999999";
        pedido.comentarios = "uma porcaria";
        pedido.formaDePagamento = FormaDePagamento.A_VISTA;

        Pedido pedido2 = new Pedido();
        pedido2.cliente_cpf = cliente.cpf;
        pedido2.data = new Date(System.currentTimeMillis());
        pedido2.franquia_id = 1;
        pedido2.funcionario_cpf = "99999999999";
        pedido2.comentarios = "uma porcaria";
        pedido2.formaDePagamento = FormaDePagamento.A_VISTA;

        Pedido pedido3 = new Pedido();
        pedido3.cliente_cpf = cliente.cpf;
        pedido3.data = new Date(System.currentTimeMillis());
        pedido3.franquia_id = 1;
        pedido3.funcionario_cpf = "99999999999";
        pedido3.comentarios = "uma porcaria";
        pedido3.formaDePagamento = FormaDePagamento.A_VISTA;

        new PedidoDAO().save(pedido);
        new PedidoDAO().save(pedido2);
        new PedidoDAO().save(pedido3);

    }
}
