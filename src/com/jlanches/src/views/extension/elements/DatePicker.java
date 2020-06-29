/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.views.extension.elements;

import java.util.Calendar;
import com.jlanches.src.constants.media.Icons;
import com.jlanches.src.constants.SystemColors;
import com.jlanches.src.helpers.ComboHelper;
import com.jlanches.src.helpers.DateHelper;
import com.jlanches.src.helpers.ViewHelper;
import com.jlanches.src.helpers.MonthHelper;
import com.jlanches.src.helpers.TimeHelper;
import javax.swing.JTextField;

/**
 *
 * @author arthur
 */
public class DatePicker extends javax.swing.JFrame {

    public static class InternalDateHelper {

        public String getNow(){
            return ""
                    + this.getCurrentYear() +"-"
                    + this.remakeNumber(this.getCurrentCalendarMonth() + "") + "-"
                    + this.remakeNumber(this.getCurrentDay() + "") + " "
                    + this.remakeNumber(this.getCurrentHour() + "") + ":"
                    + this.remakeNumber(this.getCurrentMinute() + "") + ":00";
        }
        
        public String remakeNumber(String number) {
            String returned = number + "";
            if (returned.length() == 1) {
                returned = "0" + returned;
            }
            return returned;
        }

        public Calendar getCalendarNow() {
            return Calendar.getInstance();
        }

        public int getCurrentDay() {
            return this.getCalendarNow().get(Calendar.DATE);
        }

        public int getCurrentCalendarMonth() {
            Calendar data = Calendar.getInstance();
            return this.getCalendarNow().get(Calendar.MONTH);
        }

        public int getCurrentYear() {
            Calendar data = Calendar.getInstance();
            return this.getCalendarNow().get(Calendar.YEAR);
        }

        public int getCurrentHour() {
            Calendar data = Calendar.getInstance();
            return this.getCalendarNow().get(Calendar.HOUR);
        }

        public int getCurrentMinute() {
            Calendar data = Calendar.getInstance();
            return this.getCalendarNow().get(Calendar.MINUTE);
        }
    }

    public static interface FormUseDatePicker {

        public void setData(String data);
    }

    public static class ParseDate implements DatePicker.FormUseDatePicker {

        private final JTextField field;
        
        public ParseDate(JTextField field) {
            this.field = field;
            this.field.setText("");
        }

        @Override
        public void setData(String data) {
            this.field.setText(data);
        }

        public void clearData() {
            this.field.setText("");
        }

        public String getData() {
            return this.field.getText();
        }

    }

    private FormUseDatePicker form;

    /**
     * Creates new form DatePicker
     */
    public DatePicker() {
        this.form = new FormUseDatePicker() {
            @Override
            public void setData(String data) {
                System.out.println("Not supported yet");
            }
        };
        this.run();
        this.setToday();
    }

    public DatePicker(FormUseDatePicker form) {
        this.form = form;
        this.run();
        this.setToday();
    }

    private void run() {
        this.initComponents();
        ViewHelper.setButtonStyle(this.btnSelecionar, SystemColors.CONFIRM_GREEN, Icons.CLOCK_64);
        ViewHelper.setButtonStyle(this.btnCancelar, SystemColors.LIGHT_RED, Icons.CANCELAR_64);

        ComboHelper.fillCombo(this.selectAno, DateHelper.getPossibleYears());
        ComboHelper.fillCombo(this.selectMes, DateHelper.getPossibleMonths());
        ComboHelper.fillCombo(
                this.selectDia,
                DateHelper.monthToDays(((MonthHelper.ComboMonth) this.selectMes.getSelectedItem()).mes)
        );

        ComboHelper.fillCombo(this.selectHora, TimeHelper.getPossibleHours());
        ComboHelper.fillCombo(this.selectMinuto, TimeHelper.getPossibleMinutes());
    }

    private void setToday() {
        ComboHelper.setIndexComboMonth(this.selectMes, this.getCurrentCalendarMonth());
        ComboHelper.setIndexComboData(this.selectAno, this.getCurrentYear());
        ComboHelper.setIndexComboData(this.selectDia, this.getCurrentDay());

        ComboHelper.setIndexComboData(this.selectHora, this.getCurrentHour());
        ComboHelper.setIndexComboData(this.selectMinuto, this.getCurrentMinute());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        selectAno = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        selectMes = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        selectDia = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        selectHora = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        selectMinuto = new javax.swing.JComboBox<>();
        btnSelecionar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Date Picker");
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Ano"));

        selectAno.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        selectAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectAno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectAnoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectAno, 0, 171, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectAno)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Mês"));

        selectMes.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        selectMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectMesItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectMes, 0, 200, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectMes, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Dia"));

        selectDia.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        selectDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectDia, 0, 172, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectDia)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Hora"));

        selectHora.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        selectHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectHora, 0, 296, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectHora, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Minuto"));

        selectMinuto.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        selectMinuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectMinuto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectMinuto)
                .addContainerGap())
        );

        btnSelecionar.setText("Selecionar hora");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectAnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectAnoItemStateChanged

    }//GEN-LAST:event_selectAnoItemStateChanged

    private void selectMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectMesItemStateChanged
        try {
            ComboHelper.fillCombo(
                    this.selectDia,
                    DateHelper.monthToDays(
                            ((MonthHelper.ComboMonth) this.selectMes.getSelectedItem()).mes)
            );
        } catch (Exception e) {
            // e.printStackTrace();
        }

    }//GEN-LAST:event_selectMesItemStateChanged

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        String data = ""
                + this.selectAno.getSelectedItem() + "-"
                + ((MonthHelper.ComboMonth) this.selectMes.getSelectedItem()).mes.getMonth() + "-"
                + this.remakeNumber(this.selectDia.getSelectedItem().toString()) + " "
                + this.remakeNumber(this.selectHora.getSelectedItem().toString()) + ":"
                + this.remakeNumber(this.selectMinuto.getSelectedItem().toString()) + ":00";

        this.form.setData(data);
        this.dispose();
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private String remakeNumber(String number) {
        String returned = number + "";
        if (returned.length() == 1) {
            returned = "0" + returned;
        }
        return returned;
    }

    public Calendar getCalendarNow() {
        return Calendar.getInstance();
    }

    public int getCurrentDay() {
        return this.getCalendarNow().get(Calendar.DATE);
    }

    public int getCurrentCalendarMonth() {
        Calendar data = Calendar.getInstance();
        return this.getCalendarNow().get(Calendar.MONTH);
    }

    public int getCurrentYear() {
        Calendar data = Calendar.getInstance();
        return this.getCalendarNow().get(Calendar.YEAR);
    }

    public int getCurrentHour() {
        Calendar data = Calendar.getInstance();
        return this.getCalendarNow().get(Calendar.HOUR);
    }

    public int getCurrentMinute() {
        Calendar data = Calendar.getInstance();
        return this.getCalendarNow().get(Calendar.MINUTE);
    }

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
            java.util.logging.Logger.getLogger(DatePicker.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatePicker.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatePicker.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatePicker.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        DatePicker d = new DatePicker();

        System.out.println("data: " + d.getCurrentYear() + "-" + d.getCurrentCalendarMonth() + "-" + d.getCurrentDay());
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatePicker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JComboBox<String> selectAno;
    private javax.swing.JComboBox<String> selectDia;
    private javax.swing.JComboBox<String> selectHora;
    private javax.swing.JComboBox<String> selectMes;
    private javax.swing.JComboBox<String> selectMinuto;
    // End of variables declaration//GEN-END:variables
}
