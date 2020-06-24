/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.dao;

import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import com.jlanches.src.dao.models.ModelWithComboDao;
import com.jlanches.src.helpers.MessageHelper;
import com.jlanches.src.model.Cliente;
import com.jlanches.src.model.Lanche;
import com.jlanches.src.views.extension.elements.ComboItem;

/**
 *
 * @author arthur
 */
public class LancheDAO implements ModelWithComboDao<Lanche> {

    private ResultSet resultadoQuery = null;

    @Override
    public void save(Lanche objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();

            String sql = ""
                    + "INSERT INTO lanche (nome, ingredientes, valor, disponivel, categoria_id) "
                    + "VALUES "
                    + " ("
                    + "'" + objeto.nome + "', "
                    + "'" + objeto.ingredientes + "', "
                    + "" + objeto.valor + ", "
                    + "" + objeto.disponivel + ", "
                    + "'" + objeto.categoria_id + "' "
                    + ")";
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao inserir dados de lanche do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void update(Lanche objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();

            String sql = ""
                    + "UPDATE lanche "
                    + "SET "
                    + " nome = '" + objeto.nome + "', "
                    + " ingredientes = '" + objeto.ingredientes + "', "
                    + " valor = '" + objeto.valor + "', "
                    + " disponivel = " + objeto.disponivel + ", "
                    + " categoria_id = '" + objeto.categoria_id
                    + "WHERE id = '" + objeto.id + "'";
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao atualizar dados de lanche do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void delete(Lanche objeto) {
        try {
            String sql = ""
                    + "UPDATE lanche "
                    + "SET "
                    + "disponivel = FALSE"
                    + "WHERE id = '" + objeto.id + "'";
            BDConnector.getInstance()
                    .getConnection()
                    .createStatement()
                    .executeUpdate(sql);
        } catch (SQLIntegrityConstraintViolationException e) {
            MessageHelper.createInfoMessage(
                    "Falha",
                    "Não foi possível remover o lanche, pois ele está atrelado a um pedido"
            );
            System.err.println("Falha: " + e);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao remover dados de cliente do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public ArrayList<Lanche> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Lanche> search(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Lanche get(String id) {
        Lanche lanche;
        try {
            Statement statement = BDConnector.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM lanche "
                    + "WHERE "
                    + "id LIKE '" + id + "'";

            this.resultadoQuery = statement.executeQuery(sql);

            this.resultadoQuery.next();

            lanche = this.queryToLanche();

        } catch (Exception e) {
            MessageHelper.createWarningMessage(
                    "Aviso",
                    "Houveram problemas ao recuperar os lanches do banco.\n"
                    + "Por favor, tente novamente mais tarde"
            );
            System.err.println("Erro: \n" + e);
            lanche = new Lanche();
        }
        return lanche;
    }

    public void fillTable(JTable table, String criteria) {
        Object[][] dadosTabela = null;
        Object[] cabecalho = new Object[6];
        cabecalho[0] = "ID";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Ingredientes";
        cabecalho[3] = "Valor";
        cabecalho[4] = "Disponível";
        cabecalho[5] = "Categoria";

        String like = criteria.equals("")
                ? ""
                : ("WHERE "
                + "UCASE(nome) LIKE UCASE('%" + criteria + "%') OR"
                + "UCASE(ingredientes) LIKE UCASE('%" + criteria + "%') OR"
                + "");

        try {
            this.resultadoQuery = BDConnector.getInstance()
                    .getConnection()
                    .createStatement()
                    .executeQuery(""
                            + "SELECT count(*) "
                            + "FROM lanche "
                            + like
                    );

            this.resultadoQuery.next();

            dadosTabela = new Object[this.resultadoQuery.getInt(1)][6];
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao puxar quantidade de lanches do banco");
            System.err.println("Erro: \n" + e);
        }

        try {
            this.resultadoQuery = BDConnector.getInstance()
                    .getConnection()
                    .createStatement()
                    .executeQuery(""
                            + "SELECT * "
                            + "FROM lanche "
                            + like
                    );
            int line = 0;

            while (this.resultadoQuery.next()) {
                Lanche lanche = this.queryToLanche();

                dadosTabela[line][0] = lanche.id;
                dadosTabela[line][1] = lanche;
                dadosTabela[line][2] = lanche.ingredientes;
                dadosTabela[line][3] = lanche.valor;
                dadosTabela[line][4] = lanche.disponivel ? "Sim" : "Não";
                dadosTabela[line][5] = new CategoriaDAO().get(lanche.categoria_id + "");

                line++;
            }
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao puxar dados de lanches do banco");
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
                    .executeQuery(""
                            + "SELECT * FROM lanche"
                    );
            if (this.resultadoQuery.isBeforeFirst()) {
                while (this.resultadoQuery.next()) {
                    Lanche cliente = this.queryToLanche();
                    item = new ComboItem();

                    item.id = cliente.id;
                    item.descricao = cliente.toString();

                    combo.addItem(item);
                }
            }

        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao tentar popular o campo \"select\"");
            System.err.println("Erro: \n" + e);
        }
    }

    private Lanche queryToLanche() throws Exception {
        try {
            Lanche lanche = new Lanche();
            lanche.id = this.resultadoQuery.getInt("id");
            lanche.nome = this.resultadoQuery.getString("nome");
            lanche.ingredientes = this.resultadoQuery.getString("ingredientes");
            lanche.valor = this.resultadoQuery.getString("valor");
            lanche.disponivel = this.resultadoQuery.getBoolean("disponivel");
            lanche.categoria_id = this.resultadoQuery.getInt("categoria_id");
            return lanche;
        } catch (Exception e) {
            throw e;
        }
    }
}
