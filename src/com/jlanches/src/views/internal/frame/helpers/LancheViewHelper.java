/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.views.internal.frame.helpers;

import javax.swing.JOptionPane;
import com.jlanches.src.constants.media.Icons;
import com.jlanches.src.dao.CategoriaDAO;
import com.jlanches.src.dao.LancheDAO;
import com.jlanches.src.helpers.ComboHelper;
import com.jlanches.src.helpers.IconHelper;
import com.jlanches.src.helpers.ViewHelper;
import com.jlanches.src.model.Categoria;
import com.jlanches.src.model.Lanche;
import com.jlanches.src.model.views.LancheViewModel;
import com.jlanches.src.validators.testers.LancheValidator;
import com.jlanches.src.views.extension.elements.ComboItem;

/**
 *
 * @author arthur
 */
public class LancheViewHelper {

    private enum AbasDoSistema {
        VISUALIZAR(0),
        CADASTRAR(1);

        private int id;

        private AbasDoSistema(int id) {
            this.id = id;
        }
    }

    public static void initButtons(LancheViewModel lancheView) {
        ViewHelper.initButtons(
                lancheView.btnEditar,
                lancheView.btnExcluir,
                lancheView.btnPesquisar,
                lancheView.btnLimpar
        );

        ViewHelper.initFormButtons(
                lancheView.btnLimpar,
                lancheView.btnCadastrar
        );
    }

    public static void resetInputs(
            LancheViewModel lancheView
    ) {
        lancheView.campoId.setText("");
        lancheView.campoIngredientes.setText("");
        lancheView.campoNome.setText("");
        lancheView.campoPesquisar.setText("");
        lancheView.campoValor.setText("");
    }

    public static void changeEstado(LancheViewModel lancheView) {
        if (lancheView.disponivel) {
            lancheView.disponivel = false;
            lancheView.btnAtivo.setIcon(
                    IconHelper.getPngIcon(Icons.CANCELAR_64.getPath())
            );
        } else {
            lancheView.disponivel = true;
            lancheView.btnAtivo.setIcon(
                    IconHelper.getPngIcon(Icons.SELECIONADO_64.getPath())
            );
        }
    }

    public static void updateTable(LancheViewModel lancheView) {
        LancheViewHelper.getLanchesData(lancheView, "");
    }

    public static void getLanchesData(LancheViewModel lancheView, String params) {
        new LancheDAO().fillTable(lancheView.tableLanches, params);
    }

    public static void fillSelectEstado(LancheViewModel lancheView) {
        new CategoriaDAO().fillCombo(lancheView.selectCategoria);
    }

    public static Lanche getItemFromTable(LancheViewModel lancheView) {
        return (Lanche) (lancheView.tableLanches.getValueAt(lancheView.tableLanches.getSelectedRow(), 1));
    }

    public static void cadastrarLanche(LancheViewModel lancheView) {
        Lanche lanche = new Lanche();
        lanche.id = (lancheView.campoId.getText().equals("")) ? 0 : Integer.parseInt(lancheView.campoId.getText());
        lanche.nome = lancheView.campoNome.getText();
        lanche.valor = lancheView.campoValor.getText().replaceAll(",", ".");
        lanche.disponivel = lancheView.disponivel;
        lanche.ingredientes = lancheView.campoIngredientes.getText();

        ComboItem categoria = (ComboItem) lancheView.selectCategoria.getSelectedItem();

        lanche.categoria_id = categoria.id;

        if (lanche.id == 0) {
            if (LancheValidator.insert(lanche)) {
                new LancheDAO().save(lanche);
            } else {
                return;
            }
        } else {
            if (LancheValidator.update(lanche)) {
                new LancheDAO().update(lanche);
            } else {
                return;
            }
        }
        LancheViewHelper.updateTable(lancheView);
        LancheViewHelper.resetInputs(lancheView);
        LancheViewHelper.changeTabToVisualizar(lancheView);
    }

    public static void edit(LancheViewModel lancheView) {
        Lanche lanche = LancheViewHelper.getItemFromTable(lancheView);

        Categoria categoria = LancheViewHelper.getCategoriaToEdit(lancheView);

        lancheView.campoId.setText(lanche.id + "");
        lancheView.campoNome.setText(lanche.nome);

        ComboHelper.setIndex(lancheView.selectCategoria, lanche.categoria_id);

        LancheViewHelper.changeTabToCadastrar(lancheView);
    }

    public static void insert(LancheViewModel lancheView) {
        Lanche lanche = new Lanche();
        lanche.id = lancheView.campoId.getText().equals("") ? 0 : Integer.parseInt(lancheView.campoId.getText());
        lanche.nome = lancheView.campoNome.getText();
        lanche.valor = lancheView.campoValor.getText().replaceAll(",", ".");
        lanche.disponivel = lancheView.disponivel;
        lanche.ingredientes = lancheView.campoIngredientes.getText();

        ComboItem categoria = (ComboItem) lancheView.selectCategoria.getSelectedItem();

        lanche.categoria_id = categoria.id;

        if (lanche.id == 0) {
            if (LancheValidator.insert(lanche)) {
                new LancheDAO().save(lanche);
            } else {
                return;
            }
        } else {
            if (LancheValidator.update(lanche)) {
                new LancheDAO().update(lanche);
            } else {
                return;
            }
        }
        LancheViewHelper.updateTable(lancheView);
        LancheViewHelper.resetInputs(lancheView);
        LancheViewHelper.changeTabToVisualizar(lancheView);
    }

    public static void delete(LancheViewModel lancheView) {
        Lanche lanche = LancheViewHelper.getItemFromTable(lancheView);

        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?") == JOptionPane.OK_OPTION) {
            new LancheDAO().delete(lanche);
            LancheViewHelper.updateTable(lancheView);
        }
    }

    private static Categoria getCategoriaToEdit(LancheViewModel lancheView) {
        return (Categoria) (lancheView.tableLanches.getValueAt(
                lancheView.tableLanches.getSelectedRow(), 5));
    }

    public static void changeTabToVisualizar(LancheViewModel lancheView) {
        LancheViewHelper.changeTab(lancheView, AbasDoSistema.VISUALIZAR);
    }

    public static void changeTabToCadastrar(LancheViewModel lancheView) {
        LancheViewHelper.changeTab(lancheView, AbasDoSistema.CADASTRAR);
    }

    public static void changeTab(LancheViewModel lancheView, AbasDoSistema aba) {
        lancheView.abasDoSistema.setSelectedIndex(
                aba.id
        );
    }

    public static void search(LancheViewModel lancheView) {
        new LancheDAO().fillTable(lancheView.tableLanches, lancheView.campoPesquisar.getText());
    }

    public static void clearSearch(LancheViewModel lancheView) {
        lancheView.campoPesquisar.setText("");
        LancheViewHelper.updateTable(lancheView);
    }

    public static void initLanches(LancheViewModel lancheView) {
        LancheViewHelper.initButtons(lancheView);
        LancheViewHelper.resetInputs(lancheView);
        LancheViewHelper.updateTable(lancheView);
        LancheViewHelper.fillSelectEstado(lancheView);
    }

    public static void main(String[] args) {
        AbasDoSistema aba1 = AbasDoSistema.CADASTRAR;
        AbasDoSistema aba2 = AbasDoSistema.VISUALIZAR;

        System.out.println("id: " + aba1.id);
        System.out.println("id: " + aba2.id);
    }
}
