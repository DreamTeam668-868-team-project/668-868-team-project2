/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post_gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;
import transaction.TransactionItem;

/**
 *
 * @author Travis
 */
public class ProductPanel extends javax.swing.JPanel {

    Mediator mediator;

    /**
     * Creates new form ProductPanel
     */
    public ProductPanel() {
        initComponents();
        
        
        Integer [] quantityList = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        this.jComboBox_quantity.setModel(new DefaultComboBoxModel(quantityList));
    }

    public void init(String[] upcs) {
        mediator = (Mediator) SwingUtilities.getAncestorOfClass(Mediator.class, this);
        this.jComboBox_upc.setModel(new DefaultComboBoxModel(upcs));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enter_button = new javax.swing.JButton();
        jComboBox_upc = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBox_quantity = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        enter_button.setText("Enter");
        enter_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enter_buttonActionPerformed(evt);
            }
        });

        jLabel1.setText("UPC");

        jLabel2.setText("quantity");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(enter_button)
                .addContainerGap(153, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox_upc, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox_upc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(enter_button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void enter_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enter_buttonActionPerformed
        String upc = this.jComboBox_upc.getSelectedItem().toString();
        int quantity = Integer.valueOf(this.jComboBox_quantity.getSelectedItem().toString());
        
        TransactionItem tItem = new TransactionItem(upc, quantity);
        mediator.passItem(tItem);
    }//GEN-LAST:event_enter_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enter_button;
    private javax.swing.JComboBox<String> jComboBox_quantity;
    private javax.swing.JComboBox<String> jComboBox_upc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
