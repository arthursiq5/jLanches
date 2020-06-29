/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.dao;

import com.jlanches.src.dao.models.ModelDAO;
import com.jlanches.src.helpers.MessageHelper;
import com.jlanches.src.helpers.TableHelper;
import com.jlanches.src.model.Estado;
import com.jlanches.src.model.LanchePedido;
import com.jlanches.src.model.Pedido;
import com.jlanches.src.views.extension.elements.ComboItem;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author arthur
 */
public class LanchePedidoDAO implements ModelDAO<LanchePedido> {
    private ResultSet resultadoQuery = null;

    @Override
    public void save(LanchePedido objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO lanche_pedido (id, lanche_id, pedido_id, quantidade, valor, desconto, acrescimo, modificacoes) VALUES ("
                    + "DEFAULT, "
                    +  "" + objeto.lanche_id + ", "
                    +  "" + objeto.pedido_id + ", "
                    +  "" + objeto.quantidade + ", "
                    + "'" + objeto.valor + "', "
                    + "'" + objeto.desconto + "', "
                    + "'" + objeto.acrescimo + "', "
                    + "'" + objeto.modificacoes.replace("'", "\\'") + "' "
                    + ")";
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao inserir dados de lanche_pedido no banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void update(LanchePedido objeto) {
        try {
            Statement st = BDConnector.getInstance().getConnection().createStatement();

            String sql = "UPDATE lanche_pedido "
                    + "SET lanche_id = '"  + objeto.lanche_id + "', "
                    + " quantidade = '"    + objeto.quantidade + "', "
                    + " desconto = '"      + objeto.desconto + "', "
                    + " acrescimo = '"     + objeto.acrescimo + "', "
                    + " modificacoes = '"     + objeto.modificacoes.replace("'", "\\'") + "' "
                    + "WHERE id = '"       + objeto.id + "'";
            st.executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao atualizar dados de lanche_pedido do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public void delete(LanchePedido objeto) {
        try {
            String sql = "DELETE "
                    + "FROM lanche_pedido "
                    + "WHERE id = '" + objeto.id + "'";
            BDConnector.getInstance()
                    .getConnection()
                    .createStatement()
                    .executeUpdate(sql);
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao remover dados de lanche_pedido do banco");
            System.err.println("Erro: " + e);
        }
    }

    @Override
    public ArrayList<LanchePedido> getAll() {
        ArrayList<LanchePedido> list = new ArrayList<LanchePedido>();
        
        try {
            this.resultadoQuery = BDConnector.getInstance()
                    .getConnection()
                    .createStatement()
                    .executeQuery(""
                            + "SELECT * "
                            + "FROM lanche_pedido"
                    );
            
            while(this.resultadoQuery.next()){
                list.add(this.queryToObject());
            }
            
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao puxar lanche_pedidos do banco");
            e.printStackTrace();
        }
        
        return list;
    }
    
    public ArrayList<LanchePedido> getFromPedido(String id){
        ArrayList<LanchePedido> list = new ArrayList<LanchePedido>();
        
        try {
            this.resultadoQuery = BDConnector.getInstance()
                    .getConnection()
                    .createStatement()
                    .executeQuery(""
                            + "SELECT * "
                            + "FROM lanche_pedido "
                            + "WHERE pedido_id = " + Integer.parseInt(id)
                    );
            
            while(this.resultadoQuery.next()){
                list.add(this.queryToObject());
            }
            
        } catch (Exception e) {
            MessageHelper.createErrorMessage("Erro", "Erro ao puxar lanche_pedidos do banco");
            e.printStackTrace();
        }
        
        return list;
    }
    
    public ArrayList<Pedido> getPedidoFromLanche(String id_lanche){
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        ArrayList<Integer> ids_lanche_pedido = new ArrayList<>();
        
        try {
            this.resultadoQuery = BDConnector.getInstance()
                    .getConnection()
                    .createStatement()
                    .executeQuery(""
                            + "SELECT * "
                            + "FROM lanche_pedido "
                            + "WHERE lanche_id = " + Integer.parseInt(id_lanche)
                    );
            
            while(this.resultadoQuery.next()){
                LanchePedido lanche = this.queryToObject();
                boolean exists = false;
                if(ids_lanche_pedido.size() == 0){
                    for (int i = 0; i < ids_lanche_pedido.size(); i++) {
                        if(ids_lanche_pedido.get(i) == lanche.pedido_id)
                            exists = true;
                    }
                }
                if(!exists)
                    ids_lanche_pedido.add(lanche.pedido_id);
            }
            
            for (int i = 0; i < ids_lanche_pedido.size(); i++) {
                try {
                    pedidos.add(
                        new PedidoDAO().get(
                            "" + ids_lanche_pedido.get(i) + ""
                        )
                    );
                } catch (Exception e) {
                    e.printStackTrace(System.out);
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        
        
        return pedidos;
    }

    @Override
    public ArrayList<LanchePedido> search(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LanchePedido get(String id) {
        LanchePedido lanchePedido = null;
        try {
            Statement statement = BDConnector.getInstance().getConnection().createStatement();

            String sql = ""
                    + "SELECT * "
                    + "FROM lanche_pedido "
                    + "WHERE "
                    + "id LIKE '" + id + "'";

            this.resultadoQuery = statement.executeQuery(sql);

            this.resultadoQuery.next();

            lanchePedido = this.queryToObject();

        } catch (Exception e) {
            MessageHelper.createWarningMessage(
                    "Aviso",
                    "Houveram problemas ao recuperar os estados do banco.\n"
                    + "Por favor, tente novamente mais tarde"
            );
            System.err.println("Erro: \n" + e);
            lanchePedido = new LanchePedido();
        }
        return lanchePedido;
    }

    public void fillTable(JTable table, String criteria) {
        TableHelper.populaTabelaLanchePedido(table, this.getAll());
    }

    private LanchePedido queryToObject() throws Exception {
        try {
            LanchePedido lanchePedido = new LanchePedido();
            lanchePedido.id = this.resultadoQuery.getInt("id");
            lanchePedido.acrescimo = this.resultadoQuery.getDouble("acrescimo");
            lanchePedido.desconto = this.resultadoQuery.getDouble("desconto");
            lanchePedido.valor = this.resultadoQuery.getDouble("valor");
            lanchePedido.lanche_id = this.resultadoQuery.getInt("lanche_id");
            lanchePedido.pedido_id = this.resultadoQuery.getInt("pedido_id");
            lanchePedido.modificacoes = this.resultadoQuery.getString("modificacoes").replace("\\'", "'");
            lanchePedido.quantidade = this.resultadoQuery.getInt("quantidade");
            return lanchePedido;
        } catch (Exception e) {
            System.err.println("Erro ao parsear objeto");
            throw e;
        }

    }
}
