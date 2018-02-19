package store;

import transaction.CashPayment;
import transaction.Payment;
import transaction.Transaction;
import transaction.TransactionHeader;
import transaction.TransactionItem;

import java.text.NumberFormat;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class Post {

    private PostNetworkInterface client;
    private ProductCatalog productCatalog;
    private ProductSpec scannedProduct;
    private double total;

    private boolean transactionStatus;
    private String invoice;
    private Store store;
    NumberFormat formatter;
    Transaction transaction;

    Post(Store store, PostNetworkInterface client) {
        formatter = NumberFormat.getCurrencyInstance();
        total = 0.0;
        try {
            this.productCatalog = client.getCatalog();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        this.store = store;
        transactionStatus = false;
    }

    public void startTransaction() {
        transaction = new Transaction();
        transactionStatus = true;
        invoice = "";
        total = 0.0;
        scannedProduct = null;
    }

    // accept customer information -- could be rolled into startTransaction, or the inverse
    public void login(TransactionHeader th) {
        this.transaction.setHeader(th); // customer info for invoice -- network item
    }

    public void scanItem(TransactionItem tItem) {
        if (validateUPC(tItem.getUPC())) {
            scannedProduct = productCatalog.getProduct(tItem.getUPC());
            addItem(tItem);
        }
    }

    public boolean pay(Payment payment) {
        if (!verifyPayment(payment)) {
            return false;
        }
        this.transaction.setPayment(payment); // payment info for transaction -- network item
        postTransaction(transaction);
        transactionStatus = false;
        return true;
    }

    // for gui to display running total
    public double getTotal() {
        return this.total;
    }

    public String getInvoice() {
        return this.invoice;
    }

    // private helper functions
    private boolean verifyPayment(Payment payment) {
        if ((payment instanceof CashPayment) || (Math.random() * 100.0) >= 10.0) {
            return true;
        }
        return false;
    }

    private void postTransaction(Transaction transaction) {
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

        String receiptLine = "<" + desc + " " + String.format("%1$-2s", quantity) + " @ " + String.format("%-11s", formatter.format(price)) + String.format(" %11s", formatter.format((Math.round(subTotal * 100.0) / 100.0))) + ">\n";
        invoice += receiptLine;
        this.total += subTotal;
    }

    public ProductCatalog getCatalog() {
        return this.productCatalog;
    }
    
    public boolean getTransactionStatus(){
        return this.transactionStatus;
    }
    
    
}
