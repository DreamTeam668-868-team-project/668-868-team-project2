package store;

import transaction.CashPayment;
import transaction.CheckPayment;
import transaction.CreditPayment;
import transaction.Payment;
import transaction.Transaction;
import transaction.TransactionHeader;
import transaction.TransactionItem;

import java.text.NumberFormat;

public class Post {
    private PostNetworkInterface client;
    private ProductCatalog productCatalog;
    private ProductSpec scannedProduct;
    private double total;

    private String receipt;
    private Store store;
    NumberFormat formatter;
    Transaction transaction;
        
    Post(Store store, PostNetworkInterface client){
        formatter = NumberFormat.getCurrencyInstance();
        total = 0.0;
        this.productCatalog = productCatalog;
        this.store = store;
    }
    
    
    public void startTransaction() {
        transaction = new Transaction();
        receipt = "";
        total = 0.0;
        scannedProduct = null;
    }
    
    // accept customer information -- could be rolled into startTransaction, or the inverse
    public void login(TransactionHeader th) {
        this.transaction.setHeader(th); // customer info for invoice -- network item
        receipt = store.getName() + "\n";
        receipt += th.getCustomerName() + "  " + th.getDate() + "\n";
        receipt += "---------------------------------------------------\n";
    }

    public void scanItem(TransactionItem tItem) {
        if (validateUPC(tItem.getUPC())) {
            scannedProduct = productCatalog.getProduct(tItem.getUPC());
            addItem(tItem);
        }
    }
    
    public boolean pay(Payment payment){
        if(!verifyPayment(payment)) return false;

        receipt += "---------------------------------------------------\n";
        receipt += "Total: $" + String.format("%-10.2f", total) + "\n"; // needs formatting
        if(payment instanceof CashPayment){
            receipt += "Amount Tendered: " + String.format("%-10s", formatter.format(((CashPayment) payment).getAmount())) + "\n";
            receipt += "Amount Returned: " + String.format("%-10s", formatter.format((Math.round((((CashPayment) payment).getAmount() - total) * 100.0) / 100.0)));
            // check if payment can cover total, return change (if any)
        } else if (payment instanceof CheckPayment) {
            // check if amount of payment can cover bill
            receipt += "Amount Tendered: " + ((CheckPayment) payment).toString();
        } else if (payment instanceof CreditPayment) {
            // verify credit number, reject or accept vased on result
            receipt += "Amount Tendered: " + ((CreditPayment) payment).toString();
        }
        this.transaction.setPayment(payment); // payment info for transaction -- network item 
        postTransaction(transaction);
        return true;
    }
   
    // for gui to display running total
    public double getTotal(){
        return this.total;
    }
    
    public String getReceipt(){
        return this.receipt;
    }
    
    private boolean verifyPayment(Payment payment){
        if((payment instanceof CashPayment) || (Math.random() * 100.0) >= 10) return true;
        return false;
    }
    
    private void postTransaction(Transaction trans){
        client.postInvoice(transaction);
    }

    private boolean validateUPC(String upc) {
        return this.productCatalog.validateUPC(upc);
    }

    private void addItem(TransactionItem tItem) {
        this.transaction.addTransactionItem(tItem); // add transactions for invoice -- network item
        
        String desc = scannedProduct.getDescription();
        int quantity = tItem.getQuantity();
        double price = scannedProduct.getPrice();
        double subTotal = quantity * price;
        
        String receiptLine = "<" + desc + " " + String.format("%1$-2s",quantity) + " @ " + String.format("%-11s",formatter.format(price)) + String.format(" %11s",formatter.format((Math.round(subTotal * 100.0) / 100.0))) + ">\n";
        receipt += receiptLine;

        // <desc      # @ price     subtotal>
        this.total += subTotal;
    }    
}
