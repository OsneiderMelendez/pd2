/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.pd2.vista;

import edu.cecar.pd2.logica.Consulta;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {
    
    Consulta consulta ;

    /**
     * Creates new form Main
     */
    public Main() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        rdTotal = new javax.swing.JRadioButton();
        rdAnio = new javax.swing.JRadioButton();
        rdMes = new javax.swing.JRadioButton();
        rdTrimestre = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTrimestre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                inicio(evt);
            }
        });

        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventoCalcular(evt);
            }
        });

        buttonGroup1.add(rdTotal);
        rdTotal.setText("ImporteTotal");

        buttonGroup1.add(rdAnio);
        rdAnio.setText("Importe año");

        buttonGroup1.add(rdMes);
        rdMes.setText("importe año mes");

        buttonGroup1.add(rdTrimestre);
        rdTrimestre.setText("importe año trimestre");

        jLabel1.setText("Año");

        jLabel2.setText("Mes");

        txtAnio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarAnio(evt);
            }
        });

        txtMes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarMes(evt);
            }
        });

        jLabel3.setText("Trimestre");

        txtTrimestre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                validarTrimestre(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTrimestre, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(txtMes)
                    .addComponent(txtAnio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdAnio)
                        .addGap(18, 18, 18)
                        .addComponent(rdTrimestre))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdTotal)
                        .addGap(18, 18, 18)
                        .addComponent(rdMes))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTrimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdTotal)
                    .addComponent(rdMes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdAnio)
                    .addComponent(rdTrimestre))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void validarAnio(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_validarAnio
        // TODO add your handling code here:
        
        if(!Character.isDigit(evt.getKeyChar())|| txtAnio.getText().length()>=4){
            evt.consume();
        }
    }//GEN-LAST:event_validarAnio

    private void validarMes(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_validarMes
        if(!Character.isDigit(evt.getKeyChar())|| txtMes.getText().length()>=2){
            evt.consume();
        }
    }//GEN-LAST:event_validarMes

    private void validarTrimestre(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_validarTrimestre
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar())|| txtTrimestre.getText().length()>=1){
            evt.consume();
        }
        
    }//GEN-LAST:event_validarTrimestre

    private void eventoCalcular(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventoCalcular
        // TODO add your handling code here:
        if(rdTotal.isSelected()){
            
            
            JOptionPane.showMessageDialog(this, consulta.importeTotal());
                    
        }else if(rdAnio.isSelected()){
            
            if(txtAnio.getText().length()==4){
                JOptionPane.showMessageDialog(this, consulta.importeAni(Integer.valueOf(txtAnio.getText())));
            }
            
        }else if(rdMes.isSelected()){
            if(txtAnio.getText().length()==4 && (txtMes.getText().length()>0)){
            JOptionPane.showMessageDialog(this, consulta.importeAnioMes(Integer.valueOf(txtAnio.getText()), Integer.valueOf(txtMes.getText())));
            }
        }else if(rdTrimestre.isSelected()){
            if(txtAnio.getText().length()==4 && (txtTrimestre.getText().length()>0)){
            JOptionPane.showMessageDialog(this, consulta.importeAnioMes(Integer.valueOf(txtAnio.getText()), Integer.valueOf(txtTrimestre.getText())));
        }
        }
    }//GEN-LAST:event_eventoCalcular

    private void inicio(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_inicio
        consulta = new Consulta();
    }//GEN-LAST:event_inicio

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton rdAnio;
    private javax.swing.JRadioButton rdMes;
    private javax.swing.JRadioButton rdTotal;
    private javax.swing.JRadioButton rdTrimestre;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtTrimestre;
    // End of variables declaration//GEN-END:variables
}
