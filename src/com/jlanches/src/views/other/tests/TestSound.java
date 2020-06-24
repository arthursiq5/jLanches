/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.views.other.tests;

import com.jlanches.src.helpers.SoundHelper;

/**
 *
 * @author arthur
 */
public class TestSound extends javax.swing.JInternalFrame {

    /**
     * Creates new form TestSound
     */
    public TestSound() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBeep = new javax.swing.JButton();
        btnBell = new javax.swing.JButton();
        btnBroke = new javax.swing.JButton();
        btnCoin = new javax.swing.JButton();

        btnBeep.setText("Beep");
        btnBeep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBeepActionPerformed(evt);
            }
        });

        btnBell.setText("Bell");
        btnBell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBellActionPerformed(evt);
            }
        });

        btnBroke.setText("Broke");
        btnBroke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrokeActionPerformed(evt);
            }
        });

        btnCoin.setText("Coin");
        btnCoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBeep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBroke, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addComponent(btnCoin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBeep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBell)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBroke)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCoin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBeepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBeepActionPerformed
        SoundHelper.playBeepSound();
    }//GEN-LAST:event_btnBeepActionPerformed

    private void btnBellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBellActionPerformed
        SoundHelper.playBellSound();
    }//GEN-LAST:event_btnBellActionPerformed

    private void btnBrokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrokeActionPerformed
        SoundHelper.playBrokeSound();
    }//GEN-LAST:event_btnBrokeActionPerformed

    private void btnCoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoinActionPerformed
        SoundHelper.playCoinSound();
    }//GEN-LAST:event_btnCoinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBeep;
    private javax.swing.JButton btnBell;
    private javax.swing.JButton btnBroke;
    private javax.swing.JButton btnCoin;
    // End of variables declaration//GEN-END:variables
}
