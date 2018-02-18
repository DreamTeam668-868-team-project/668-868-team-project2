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

    private String invoice;
    private Store store;
    NumberFormat formatter;
    Transaction transaction;
        
    Post(Store store, PostNetworkInterface client){
        formatter = NumberFormat.getCurrencyInstance();
        total = 0;
        this.productCatalog = productCatalog;
        this.store = store;
    }
    
    public void login(TransactionHeader th) {
        this.transaction.setHeader(th); // customer info for invoice -- network item
//        invoice = store.getName() + "\n";
//        invoice += th.getCustomerName() + "  " + th.getDate() + "\n";
//        invoice += "---------------------------------------------------\n";
    }

    public void scanItem(TransactionItem tItem) {
        if (validateUPC(tItem.getUPC())) {
            scannedProduct = productCatalog.getProduct(tItem.getUPC());
            updateInvoice(tItem);
        }
    }
    
    public void pay(Payment payment){
//        invoice += "---------------------------------------------------\n";
//        invoice += "Total: $" + String.format("%-10.2f", total) + "\n"; // needs formatting
        if(payment instanceof CashPayment){
//            invoice += "Amount Tendered: " + String.format("%-10s", formatter.format(((CashPayment) payment).getAmount())) + "\n";
//            invoice += "Amount Returned: " + String.format("%-10s", formatter.format((Math.round((((CashPayment) payment).getAmount() - total) * 100.0) / 100.0)));
                    
            // check if payment can cover total, return change (if any)
        } else if (payment instanceof CheckPayment) {
            // check if amount of payment can cover bill
//            invoice += "Amount Tendered: " + ((CheckPayment) payment).toString();
        } else if (payment instanceof CreditPayment) {
            // verify credit number, reject or accept vased on result
//            invoice += "Amount Tendered: " + ((CreditPayment) payment).toString();
        }
        
        this.transaction.setPayment(payment); // payment info for transaction -- network item
        
    }

    public void startTransaction() {
        transaction = new Transaction();
        invoice = "";
        total = 0;
        scannedProduct = null;
    }

    boolean validateUPC(String upc) {
        return this.productCatalog.validateUPC(upc);
    }

    private void updateInvoice(TransactionItem tItem) {
        this.transaction.addTransactionItem(tItem); // add transactions for invoice -- network item
        double subTotal = 0;
        String desc = scannedProduct.getDescription();
        int quantity = tItem.getQuantity();
        double price = scannedProduct.getPrice();
        subTotal = quantity * price;
        String invoiceLine = "<" + desc + " " + String.format("%1$-2s",quantity) + " @ " + String.format("%-11s",formatter.format(price)) + String.format(" %11s",formatter.format((Math.round(subTotal * 100.0) / 100.0))) + ">\n";
        
        invoice += invoiceLine;

        // <desc      # @ price     subtotal>
        this.total += subTotal;
    }
    
    public boolean checkTransactionIsValid(Transaction trans){
        return false;
    }
}
