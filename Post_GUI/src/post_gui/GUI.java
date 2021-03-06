
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post_gui;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import transaction.Transaction;
import store.Post;
import transaction.TransactionItem;

/**
 *
 * @author jiawenzhu
 */
public class GUI extends javax.swing.JFrame {

//    public void actionPerformed(ActionEvent e){
//        
//    }
    /**
     * Creates new form GUI
     */
    public GUI(Post post) {
        initComponents();
        // todo get data from database
        jComboBox_upc.removeAllItems();
        jComboBox_quantity.removeAllItems();
        jComboBox_payType.removeAllItems();
        this.post = post;
        
        // Dynamically set upcs for gui
        String upcs[] = post.getCatalog().getUpcs();
        jComboBox_upc.setModel(new DefaultComboBoxModel(upcs));
        
        
        int quantity[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < quantity.length; i++) {
            jComboBox_quantity.addItem(quantity[i] + "");
        }
        String payments[] = {"cash", "credit", "check"};
        for (int i = 0; i < payments.length; i++) {
            jComboBox_payType.addItem(payments[i]);
        }
        //default setting//
        creditCardNum.setVisible(false);
        //select a payment type 
        jComboBox_payType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enter_comboxBox_payType();
            }
        });

    }

    private void enter_comboxBox_payType() {
        String selectType = jComboBox_payType.getSelectedItem().toString();
        if (selectType == "cash") {
            cashVisitility();
        } else if (selectType == "check") {
            checkVisitility();
        } else { // credit card
            creditVisitility();
        }

    }

    private void cashVisitility() {
        jTextField_amount.setVisible(true);
        amount.setVisible(true);
        change.setVisible(true);
        creditCardNum.setVisible(false);
    }

    private void checkVisitility() {
        jTextField_amount.setVisible(true);
        amount.setVisible(true);
        change.setVisible(false);
        creditCardNum.setVisible(false);
    }

    private void creditVisitility() {
        jTextField_amount.setVisible(false);
        amount.setVisible(false);
        change.setVisible(false);
        creditCardNum.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        product_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Enter_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox_upc = new javax.swing.JComboBox<>();
        jComboBox_quantity = new javax.swing.JComboBox<>();
        post_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        payment_panel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        pay_button = new javax.swing.JButton();
        jComboBox_payType = new javax.swing.JComboBox<>();
        jTextField_amount = new javax.swing.JTextField();
        change = new javax.swing.JLabel();
        creditCardNum = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Title Terminal");

        product_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        product_panel.setToolTipText("Product");
        product_panel.setName("Product"); // NOI18N

        jLabel1.setText("UPC");

        Enter_button.setText("Enter");
        Enter_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enter_buttonActionPerformed(evt);
            }
        });

        jLabel2.setText("quantity");

        jComboBox_upc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox_quantity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout product_panelLayout = new javax.swing.GroupLayout(product_panel);
        product_panel.setLayout(product_panelLayout);
        product_panelLayout.setHorizontalGroup(
            product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(product_panelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_upc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(product_panelLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(product_panelLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel13))
                    .addComponent(Enter_button))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        product_panelLayout.setVerticalGroup(
            product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(product_panelLayout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(product_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox_upc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(Enter_button)
                .addGap(35, 35, 35))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setText("ITEM");

        jLabel4.setText("QTY");

        jLabel5.setText("UNIT_PRICE");

        jLabel6.setText("EXTENED_PRICE");

        jLabel7.setText("TOTAL");

        total.setText("$0.00");

        javax.swing.GroupLayout post_panelLayout = new javax.swing.GroupLayout(post_panel);
        post_panel.setLayout(post_panelLayout);
        post_panelLayout.setHorizontalGroup(
            post_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, post_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(69, 69, 69)
                .addComponent(total)
                .addGap(48, 48, 48))
            .addGroup(post_panelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(67, 67, 67)
                .addComponent(jLabel5)
                .addGap(71, 71, 71)
                .addComponent(jLabel6)
                .addGap(46, 46, 46))
            .addComponent(jScrollPane1)
        );
        post_panelLayout.setVerticalGroup(
            post_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(post_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(post_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(post_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(total))
                .addGap(17, 17, 17))
        );

        jLabel12.setText("Customer Name");

        jLabel9.setText("Payment type");

        amount.setText("Amount");

        pay_button.setText("Pay");
        pay_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_buttonActionPerformed(evt);
            }
        });

        jComboBox_payType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField_amount.setText("0.00");

        change.setText("change");

        creditCardNum.setText("123456789");
        creditCardNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditCardNumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout payment_panelLayout = new javax.swing.GroupLayout(payment_panel);
        payment_panel.setLayout(payment_panelLayout);
        payment_panelLayout.setHorizontalGroup(
            payment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, payment_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(payment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(payment_panelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_payType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, payment_panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pay_button)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(payment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(payment_panelLayout.createSequentialGroup()
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(payment_panelLayout.createSequentialGroup()
                        .addComponent(creditCardNum, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(change)))
                .addGap(53, 53, 53))
        );
        payment_panelLayout.setVerticalGroup(
            payment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payment_panelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(payment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(amount)
                    .addComponent(jComboBox_payType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(payment_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creditCardNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(change)
                    .addComponent(pay_button))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jTextField1.setText("John");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(payment_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(94, 94, 94)
                            .addComponent(jLabel12)
                            .addGap(66, 66, 66)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(83, 83, 83)
                            .addComponent(product_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(post_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(231, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(product_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(post_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payment_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Enter_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enter_buttonActionPerformed
        if(!post.getTransactionStatus()) post.startTransaction();
        
        String selectUPC = jComboBox_upc.getSelectedItem().toString();
        int select_quantity = Integer.parseInt(jComboBox_quantity.getSelectedItem().toString());
        TransactionItem TranItm = new TransactionItem(selectUPC, select_quantity);
        post.scanItem(TranItm);
        // clear perious text to avoid redundant 
        jTextArea1.setText("");
        // display posts in the textField 
        jTextArea1.append(post.getInvoice() + "\n");
//        transaction.addTransactionItem(TranItm);
        total.setText(post.getTotal() + "");
    }//GEN-LAST:event_Enter_buttonActionPerformed

    private void pay_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_buttonActionPerformed
        String selectType = jComboBox_payType.getSelectedItem().toString();
        double amount = Double.parseDouble(jTextField_amount.getSelectedText().trim());
    }//GEN-LAST:event_pay_buttonActionPerformed

    private void creditCardNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditCardNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creditCardNumActionPerformed
    private void select_jComboBox_payType() {

        double amount = Double.parseDouble(jTextField_amount.getSelectedText().trim());
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Enter_button;
    private javax.swing.JLabel amount;
    private javax.swing.JLabel change;
    private javax.swing.JTextField creditCardNum;
    private javax.swing.JComboBox<String> jComboBox_payType;
    private javax.swing.JComboBox<String> jComboBox_quantity;
    private javax.swing.JComboBox<String> jComboBox_upc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField_amount;
    private javax.swing.JButton pay_button;
    private javax.swing.JPanel payment_panel;
    private javax.swing.JPanel post_panel;
    private javax.swing.JPanel product_panel;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
    private Post post;
    private Transaction transaction;

}
