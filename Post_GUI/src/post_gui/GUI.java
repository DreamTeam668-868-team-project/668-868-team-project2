
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post_gui;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import transaction.Transaction;
import store.Post;
import transaction.Payment;
import transaction.TransactionHeader;
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
        // clear all initial setting 
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
        enter_button = new javax.swing.JButton();
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
        jTextField_name = new javax.swing.JTextField();
        date_time = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Title Terminal");

        product_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        product_panel.setToolTipText("Product");
        product_panel.setName("Product"); // NOI18N

        jLabel1.setText("UPC");

        enter_button.setText("Enter");
        enter_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enter_buttonActionPerformed(evt);
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
                    .addComponent(enter_button))
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
                .addComponent(enter_button)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(67, 67, 67)
                .addComponent(jLabel5)
                .addGap(71, 71, 71)
                .addComponent(jLabel6)
                .addGap(46, 46, 46))
            .addGroup(post_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addGap(27, 27, 27)
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTextField_name.setText("John");

        date_time.setText("date_time");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(post_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(date_time, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(payment_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel12)
                        .addGap(66, 66, 66)
                        .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145)
                        .addComponent(product_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(product_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(post_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(payment_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(date_time)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enter_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enter_buttonActionPerformed
        if (!post.getTransactionStatus()) {
            post.startTransaction();
        }

        String selectUPC = jComboBox_upc.getSelectedItem().toString();
        int select_quantity = Integer.parseInt(jComboBox_quantity.getSelectedItem().toString());
        TransactionItem TranItm = new TransactionItem(selectUPC, select_quantity);
        post.scanItem(TranItm);
        // clear perious text to avoid redundant 
        jTextArea1.setText("");
        // display posts in the textField 
        jTextArea1.append(post.getInvoice() + "\n");
        total.setText(post.getTotal() + "");
        //scan a tem to transaction
        post.scanItem(TranItm);
    }//GEN-LAST:event_enter_buttonActionPerformed

    private void pay_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_buttonActionPerformed
        String name =jTextField_name.getText().toString();
        date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        TransactionHeader th = new TransactionHeader(name, date);
        
        String selectType = jComboBox_payType.getSelectedItem().toString();
        double amount = Double.parseDouble(jTextField_amount.getSelectedText().trim());
        
        date_time.setText(th.getDateAsString());
        // payment will be easier to create a new instance of payment type insteand of a abstract class 
//        post.pay(payment);

    }//GEN-LAST:event_pay_buttonActionPerformed

    private void checkCreditCard() {
        try {
            creditCardNumber = Double.parseDouble(creditCardNum.getText().toString());
            validCreditCard = true;
        } catch (Exception e) {
            System.out.println(creditCardNumber + "is not a credit number");
            validCreditCard = false;
        }
    }
    private void creditCardNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditCardNumActionPerformed

    }//GEN-LAST:event_creditCardNumActionPerformed

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
    private javax.swing.JLabel amount;
    private javax.swing.JLabel change;
    private javax.swing.JTextField creditCardNum;
    private javax.swing.JLabel date_time;
    private javax.swing.JButton enter_button;
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
    private javax.swing.JTextField jTextField_amount;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JButton pay_button;
    private javax.swing.JPanel payment_panel;
    private javax.swing.JPanel post_panel;
    private javax.swing.JPanel product_panel;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
    private Post post;
    private Transaction transaction;
    private Date date;
    private Double creditCardNumber;
    private boolean validCreditCard;
    private Payment payment;

}
