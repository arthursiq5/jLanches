/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.views.internal.frame.helpers;

import javax.swing.JOptionPane;
import com.jlanches.src.dao.CidadeDAO;
import com.jlanches.src.helpers.ComboHelper;
import com.jlanches.src.helpers.ViewHelper;
import com.jlanches.src.model.Cidade;
import com.jlanches.src.model.Estado;
import com.jlanches.src.model.views.CidadeViewModel;
import com.jlanches.src.validators.testers.CidadeValidator;
import com.jlanches.src.views.extension.elements.ComboItem;

/**
 *
 * @author arthur
 */
public class CidadeViewHelper {

    public static void initButtons(
            CidadeViewModel cidadeView
    ) {
        ViewHelper.initButtons(cidadeView.btnEditar,
                cidadeView.btnExcluir,
                cidadeView.btnPesquisar,
                cidadeView.btnLimparBusca
        );

        ViewHelper.initFormButtons(
                cidadeView.btnLimparFormulario,
                cidadeView.btnCadastrar
        );
    }

    public static void resetInputs(
            CidadeViewModel cidadeView
    ) {
        cidadeView.campoPesquisarCidades.setText("");
        cidadeView.campoCidadeId.setText("");
        cidadeView.campoPesquisarCidades.setText("");
        cidadeView.campoCidadeNome.setText("");
    }

    public static void updateTable(CidadeViewModel cidadeView) {
        new CidadeDAO().fillTable(cidadeView.table, "");
    }

    public static void search(CidadeViewModel cidadeView) {
        new CidadeDAO().fillTable(cidadeView.table, cidadeView.campoPesquisarCidades.getText());
    }

    public static void cadastrar(CidadeViewModel cidadeView) {
        Cidade cidade = new Cidade();
        cidade.id = (cidadeView.campoCidadeId.getText().equals("")) ? 0 : Integer.parseInt(cidadeView.campoCidadeId.getText());
        cidade.nome = cidadeView.campoCidadeNome.getText();
        ComboItem estado = (ComboItem) cidadeView.selectEstado.getSelectedItem();

        cidade.estado_id = estado.id;

        if (cidade.id == 0) {
            if (CidadeValidator.insert(cidade)) {
                new CidadeDAO().save(cidade);
            } else {
                return;
            }
        } else {
            if (CidadeValidator.update(cidade)) {
                new CidadeDAO().update(cidade);
            } else {
                return;
            }
        }

        CidadeViewHelper.updateTable(cidadeView);

        CidadeViewHelper.resetInputs(cidadeView);
        ViewHelper.openViewTab(cidadeView.abasDoSistema);
    }

    public static void update(CidadeViewModel cidadeView) {
        Cidade cidade = new Cidade();
        cidade.id = Integer.parseInt(
                String.valueOf(cidadeView.table.getValueAt(cidadeView.table.getSelectedRow(), 0)));
        cidade.nome = String.valueOf(cidadeView.table.getValueAt(cidadeView.table.getSelectedRow(), 1));

        Estado estado = (Estado) (cidadeView.table.getValueAt(cidadeView.table.getSelectedRow(), 2));

        cidade.estado_id = estado.id;

        cidadeView.campoCidadeId.setText(cidade.id + "");
        cidadeView.campoCidadeNome.setText(cidade.nome);

        ComboHelper.setIndex(cidadeView.selectEstado, cidade.estado_id);

        ViewHelper.openFormTab(cidadeView.abasDoSistema);
    }

    public static void delete(CidadeViewModel cidadeView) {
        Cidade cidade = new Cidade();
        cidade.id = Integer.parseInt(
                String.valueOf(cidadeView.table.getValueAt(cidadeView.table.getSelectedRow(), 0)));
        cidade.nome = String.valueOf(cidadeView.table.getValueAt(cidadeView.table.getSelectedRow(), 1));

        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?") == JOptionPane.OK_OPTION) {
            new CidadeDAO().delete(cidade);
            CidadeViewHelper.updateTable(cidadeView);
        }
    }
}
