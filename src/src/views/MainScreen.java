/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.views;

import src.views.internalFrame.CategoriaView;
import src.views.internalFrame.ClienteView;
import src.views.internalFrame.ContatoView;
import javax.swing.JInternalFrame;
import src.helpers.FrameHelper;
import src.model.Funcionario;
import src.views.internalFrame.CidadeView;
import src.views.internalFrame.CreditosView;
import src.views.internalFrame.FranquiaView;
import src.views.internalFrame.FuncionarioView;
import src.views.internalFrame.LanchesView;
import src.views.internalFrame.PedidoView;
import src.views.internalFrame.admin.ClienteAdminView;

/**
 *
 * @author arthur
 */
public class MainScreen extends javax.swing.JFrame {

    private Funcionario funcionario;
    
    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        
        FrameHelper.setLookAndFeel();
        
        this.funcionario = null;
        initComponents();
    }
    
    public MainScreen(Funcionario funcionario){
        this.funcionario = funcionario;
        this.initComponents();
    }
    
    private void openView(JInternalFrame view){
    // o "frameInterno" referencia o JDesktopPane
    this.frameInterno.removeAll();
    //Tente algo nessas linhas para começo de conversa
    this.repaint();
    revalidate();
    validate(); 
    this.revalidate();
    this.validate();
    //Além disso, sugiro inverter a ordem abaixo: primeiro deixar visivel e depois adicionar ao Frame.
    this.frameInterno.add(view);
    view.setVisible(true);
}
    
    public void closeAllWindows(){
        this.frameInterno.removeAll();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        frameInterno = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        itemFuncionario = new javax.swing.JMenuItem();
        itemCliente = new javax.swing.JMenuItem();
        itemFranquia = new javax.swing.JMenuItem();
        menuPedido = new javax.swing.JMenu();
        itemPedido = new javax.swing.JMenuItem();
        itemLanche = new javax.swing.JMenuItem();
        itemCategoria = new javax.swing.JMenuItem();
        menuEnderecoContato = new javax.swing.JMenu();
        itemContato = new javax.swing.JMenuItem();
        itemCidadeEstado = new javax.swing.JMenuItem();
        menuOutros = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        itemCreditos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("jLanches");
        setResizable(false);

        javax.swing.GroupLayout frameInternoLayout = new javax.swing.GroupLayout(frameInterno);
        frameInterno.setLayout(frameInternoLayout);
        frameInternoLayout.setHorizontalGroup(
            frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1252, Short.MAX_VALUE)
        );
        frameInternoLayout.setVerticalGroup(
            frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 871, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 255));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        menuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-editar-arquivo-16.png"))); // NOI18N
        menuCadastro.setText("Cadastro");

        itemFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-nome-16.png"))); // NOI18N
        itemFuncionario.setText("Funcionário");
        itemFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFuncionarioActionPerformed(evt);
            }
        });
        menuCadastro.add(itemFuncionario);

        itemCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-nome-16.png"))); // NOI18N
        itemCliente.setText("Cliente");
        itemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemClienteActionPerformed(evt);
            }
        });
        menuCadastro.add(itemCliente);

        itemFranquia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-mapa-do-tesouro-16.png"))); // NOI18N
        itemFranquia.setText("Franquia");
        itemFranquia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFranquiaActionPerformed(evt);
            }
        });
        menuCadastro.add(itemFranquia);

        jMenuBar1.add(menuCadastro);

        menuPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-lancheira-16.png"))); // NOI18N
        menuPedido.setText("Pedidos");

        itemPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-papel-16.png"))); // NOI18N
        itemPedido.setText("Pedido");
        itemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPedidoActionPerformed(evt);
            }
        });
        menuPedido.add(itemPedido);

        itemLanche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-lancheira-16.png"))); // NOI18N
        itemLanche.setText("Lanches");
        itemLanche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLancheActionPerformed(evt);
            }
        });
        menuPedido.add(itemLanche);

        itemCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-abrir-pasta-16.png"))); // NOI18N
        itemCategoria.setText("Categorias");
        itemCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCategoriaActionPerformed(evt);
            }
        });
        menuPedido.add(itemCategoria);

        jMenuBar1.add(menuPedido);

        menuEnderecoContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-mapa-do-tesouro-16.png"))); // NOI18N
        menuEnderecoContato.setText("Endereço e contatos");

        itemContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-telefone-sem-uso-16.png"))); // NOI18N
        itemContato.setText("Contato");
        itemContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemContatoActionPerformed(evt);
            }
        });
        menuEnderecoContato.add(itemContato);

        itemCidadeEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-pedido-entregue-16.png"))); // NOI18N
        itemCidadeEstado.setText("Cidades e Estados");
        itemCidadeEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCidadeEstadoActionPerformed(evt);
            }
        });
        menuEnderecoContato.add(itemCidadeEstado);

        jMenuBar1.add(menuEnderecoContato);

        menuOutros.setText("Outros");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-pdf-2-16.png"))); // NOI18N
        jMenuItem1.setText("Relatórios");
        menuOutros.add(jMenuItem1);

        itemCreditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-arquivo-de-fichas-16.png"))); // NOI18N
        itemCreditos.setText("Créditos");
        itemCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreditosActionPerformed(evt);
            }
        });
        menuOutros.add(itemCreditos);

        jMenuBar1.add(menuOutros);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frameInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(frameInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFuncionarioActionPerformed
        /*this.openView(
                        this.funcionario.administrador 
                            ? new FuncionarioAdminView() : 
                        new FuncionarioView(this.funcionario)
                    );*/
        this.openView(new FuncionarioView(funcionario));
    }//GEN-LAST:event_itemFuncionarioActionPerformed

    private void itemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemClienteActionPerformed
        this.openView(this.funcionario.administrador ? new ClienteAdminView() : new ClienteView());
    }//GEN-LAST:event_itemClienteActionPerformed

    private void itemCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCategoriaActionPerformed
        this.openView(new CategoriaView());
    }//GEN-LAST:event_itemCategoriaActionPerformed

    private void itemContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemContatoActionPerformed
        this.openView(new ContatoView());
    }//GEN-LAST:event_itemContatoActionPerformed

    private void itemCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCreditosActionPerformed
        this.openView(new CreditosView(this));
    }//GEN-LAST:event_itemCreditosActionPerformed

    private void itemCidadeEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCidadeEstadoActionPerformed
        this.openView(new CidadeView());
    }//GEN-LAST:event_itemCidadeEstadoActionPerformed

    private void itemFranquiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFranquiaActionPerformed
        this.openView(new FranquiaView());
    }//GEN-LAST:event_itemFranquiaActionPerformed

    private void itemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPedidoActionPerformed
        this.openView(new PedidoView());
    }//GEN-LAST:event_itemPedidoActionPerformed

    private void itemLancheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLancheActionPerformed
        this.openView(new LanchesView());
    }//GEN-LAST:event_itemLancheActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane frameInterno;
    private javax.swing.JMenuItem itemCategoria;
    private javax.swing.JMenuItem itemCidadeEstado;
    private javax.swing.JMenuItem itemCliente;
    private javax.swing.JMenuItem itemContato;
    private javax.swing.JMenuItem itemCreditos;
    private javax.swing.JMenuItem itemFranquia;
    private javax.swing.JMenuItem itemFuncionario;
    private javax.swing.JMenuItem itemLanche;
    private javax.swing.JMenuItem itemPedido;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuEnderecoContato;
    private javax.swing.JMenu menuOutros;
    private javax.swing.JMenu menuPedido;
    // End of variables declaration//GEN-END:variables
}
