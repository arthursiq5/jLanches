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
import com.jlanches.src.model.Contato;
import com.jlanches.src.views.extension.elements.ComboItem;

/**
 *
 * @author arthur
 */
public class ContatoDAO implements ModelWithComboDao<Contato> {

    private ResultSet resultadoQuery = null;

    @Override
    public void save(Contato objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO contato (id, fone, email) VALUES ("
                    + "DEFAULT, "
                    + "'" + objeto.fone + "', "
                    + "'" + objeto.email + "')";
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao inserir dados de contatos do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void update(Contato objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();

            String sql = "UPDATE contato "
                    + "SET fone = '" + objeto.fone + "', "
                    + "email = '" + objeto.email + "' "
                    + "WHERE id = '" + objeto.id + "'";
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao atualizar dados de contatos do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void delete(Contato objeto) {
        try {
            String sql = "DELETE "
                    + "FROM contato "
                    + "WHERE id = " + objeto.id;
            BDConnector.getInstance()
                    .getConnection()
                    .createStatement()
                    .executeUpdate(sql);
        } catch (SQLIntegrityConstraintViolationException e) {
            MessageHelper.createInfoMessage(
                    "Falha",
                    "Não foi possível remover o contato, pois ele está atrelado a um usuário ou cliente"
            );
            System.err.println("Falha: " + e);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao remover dados de contatos do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public ArrayList<Contato> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Contato> search(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contato get(String id) {
        Contato contato = new Contato();
        try {
            Statement statement = BDConnector.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM contato "
                    + "WHERE "
                    + "id LIKE '" + id + "'";

            System.out.println("SQL: " + sql);

            this.resultadoQuery = statement.executeQuery(sql);

            this.resultadoQuery.next();

            contato.id = this.resultadoQuery.getInt("id");
            contato.fone = this.resultadoQuery.getString("fone");
            contato.email = this.resultadoQuery.getString("email");

        } catch (Exception e) {
            MessageHelper.createWarningMessage(
                    "Aviso",
                    "Houveram problemas ao recuperar os contatos do banco.\n"
                    + "Por favor, tente novamente mais tarde"
            );
            System.err.println("Erro: \n" + e);
            contato.id = 0;
            contato.fone = "";
            contato.email = "";
        }
        return contato;
    }

    public void fillTable(JTable table, String criteria) {
        Object[][] dadosTabela = null;
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "ID";
        cabecalho[1] = "Fone";
        cabecalho[2] = "Email";

        String like = criteria.equals("")
                ? ""
                : ("WHERE UCASE(fone) LIKE UCASE('%" + criteria + "%') "
                + "OR UCASE(email) LIKE UCASE('%" + criteria + "%')");

        try {
            this.resultadoQuery = BDConnector.getInstance()
                    .getConnection()
                    .createStatement()
                    .executeQuery(""
                            + "SELECT count(*) "
                            + "FROM contato "
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
                            + "FROM contato "
                            + like
                    );

            int line = 0;
            while (this.resultadoQuery.next()) {
                Contato contato = new Contato();
                contato.id = this.resultadoQuery.getInt("id");
                contato.fone = this.resultadoQuery.getString("fone");
                contato.email = this.resultadoQuery.getString("email");

                dadosTabela[line][0] = contato.id;
                dadosTabela[line][1] = contato.fone;
                dadosTabela[line][2] = contato.email;

                line++;
            }
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao puxar dados de contatos do banco");
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
                            + "SELECT * FROM contato"
                    );
            if (this.resultadoQuery.isBeforeFirst()) {
                while (this.resultadoQuery.next()) {
                    Contato contato = new Contato(
                            this.resultadoQuery.getInt("id"),
                            this.resultadoQuery.getString("fone"),
                            this.resultadoQuery.getString("email")
                    );
                    item = new ComboItem(
                            contato.id,
                            contato + ""
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
