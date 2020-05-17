/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.views;

import javax.swing.JInternalFrame;

/**
 *
 * @author arthur
 */
public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
    }
    
    private void openView(JInternalFrame view){
        this.frameInterno.removeAll();
        this.frameInterno.add(view);
        view.setVisible(true);
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
        jMenu1 = new javax.swing.JMenu();
        itemFuncionario = new javax.swing.JMenuItem();
        itemCliente = new javax.swing.JMenuItem();
        itemPedido = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        itemLanche = new javax.swing.JMenuItem();
        itemCategoria = new javax.swing.JMenuItem();
        itemContato = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        itemCidade = new javax.swing.JMenuItem();
        itemEstado = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        itemCreditos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("jLanches");

        javax.swing.GroupLayout frameInternoLayout = new javax.swing.GroupLayout(frameInterno);
        frameInterno.setLayout(frameInternoLayout);
        frameInternoLayout.setHorizontalGroup(
            frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1246, Short.MAX_VALUE)
        );
        frameInternoLayout.setVerticalGroup(
            frameInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 255));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-editar-arquivo-16.png"))); // NOI18N
        jMenu1.setText("Cadastro");

        itemFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-nome-16.png"))); // NOI18N
        itemFuncionario.setText("Funcionário");
        itemFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFuncionarioActionPerformed(evt);
            }
        });
        jMenu1.add(itemFuncionario);

        itemCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-nome-16.png"))); // NOI18N
        itemCliente.setText("Cliente");
        itemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemClienteActionPerformed(evt);
            }
        });
        jMenu1.add(itemCliente);

        jMenuBar1.add(jMenu1);

        itemPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-lancheira-16.png"))); // NOI18N
        itemPedido.setText("Pedidos");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-papel-16.png"))); // NOI18N
        jMenuItem4.setText("Pedido");
        itemPedido.add(jMenuItem4);

        itemLanche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-lancheira-16.png"))); // NOI18N
        itemLanche.setText("Lanches");
        itemPedido.add(itemLanche);

        itemCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-abrir-pasta-16.png"))); // NOI18N
        itemCategoria.setText("Categorias");
        itemCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCategoriaActionPerformed(evt);
            }
        });
        itemPedido.add(itemCategoria);

        jMenuBar1.add(itemPedido);

        itemContato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-mapa-do-tesouro-16.png"))); // NOI18N
        itemContato.setText("Endereço e contatos");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-telefone-sem-uso-16.png"))); // NOI18N
        jMenuItem3.setText("Contato");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        itemContato.add(jMenuItem3);

        itemCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-pedido-entregue-16.png"))); // NOI18N
        itemCidade.setText("Cidade");
        itemContato.add(itemCidade);

        itemEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-mapa-do-tesouro-16.png"))); // NOI18N
        itemEstado.setText("Estado");
        itemEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEstadoActionPerformed(evt);
            }
        });
        itemContato.add(itemEstado);

        jMenuBar1.add(itemContato);

        jMenu4.setText("Outros");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-pdf-2-16.png"))); // NOI18N
        jMenuItem1.setText("Relatórios");
        jMenu4.add(jMenuItem1);

        itemCreditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icons/icons8-arquivo-de-fichas-16.png"))); // NOI18N
        itemCreditos.setText("Créditos");
        jMenu4.add(itemCreditos);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(frameInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(frameInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemFuncionarioActionPerformed

    private void itemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemClienteActionPerformed
        this.openView(new ClienteView());
    }//GEN-LAST:event_itemClienteActionPerformed

    private void itemEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEstadoActionPerformed
        this.openView(new EstadoView());
    }//GEN-LAST:event_itemEstadoActionPerformed

    private void itemCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCategoriaActionPerformed
        this.openView(new CategoriaView());
    }//GEN-LAST:event_itemCategoriaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.openView(new ContatoView());
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
    private javax.swing.JMenuItem itemCidade;
    private javax.swing.JMenuItem itemCliente;
    private javax.swing.JMenu itemContato;
    private javax.swing.JMenuItem itemCreditos;
    private javax.swing.JMenuItem itemEstado;
    private javax.swing.JMenuItem itemFuncionario;
    private javax.swing.JMenuItem itemLanche;
    private javax.swing.JMenu itemPedido;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables
}
