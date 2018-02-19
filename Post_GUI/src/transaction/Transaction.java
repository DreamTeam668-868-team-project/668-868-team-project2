package transaction;

import java.sql.Time;
import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;


/**
 *
 * @author Travis
 */
public class Transaction {
    public Transaction(){
        this.transactionItems = new ArrayList<>();
        this.index = 0;
    }
    
    public void setHeader(TransactionHeader header){
        this.header = header;
    }
    
    public TransactionHeader getHeader(){
        return this.header;
    }
    
    public void setPayment(Payment payment){
        this.payment = payment;
    }
    
    public Payment getPayment() {
        return this.payment;
    }
    
    // modification: if item is in the transaction, increase the quantity
    public void addTransactionItem(TransactionItem item){
        if(!this.transactionItems.contains(item)) this.transactionItems.add(item);
        else {
            int index = transactionItems.indexOf(item);
            TransactionItem alter = transactionItems.get(index);
            alter.setQuantity( alter.getQuantity() + item.getQuantity() );            
        }
    }
    
    public boolean hasMoreTransactionItems()
    {
        return (index < transactionItems.size());
    }
    
    public TransactionItem getNextTransactionItem(){
        TransactionItem tItem = null;
        try{
            tItem = transactionItems.get(index);
            index++;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return tItem;        
    }
    
    public String getTransactionXML(){
        String invoice = "";
        
        Date date = this.getHeader().getDate();
        Time time = new Time(date.getTime());
        invoice += "<salesrecord>  \n";
//        invoice += "     <id>" + getID() + "</id>  \n";
        invoice += "     <transactiondate>" + date + "</transactiondate>  \n";
        invoice += "     <transactiontime>" + time.toString() + "</transactiontime>  \n";
        invoice += "     <customername>"+ this.getHeader().getCustomerName() + "</customername>  \n";
        TransactionItem tItem = this.getNextTransactionItem();
        invoice += "     <transactionrecord>"; // transaction record is a list of pairs of the form (upc1,q1),(upc2,q2),...,(upcn,qn)
        invoice += "(" + (tItem.getUPC()) + "," + (tItem.getQuantity()) + ")"; // first transaction record guaranteed, can't buy 0 items
        while(this.hasMoreTransactionItems()){
            tItem = this.getNextTransactionItem();
            invoice += ",(" + (tItem.getUPC()) + "," + (tItem.getQuantity()) + ")";
        }
        invoice += "</transactionrecord>  \n";
        
        //  PAYMENT INFO
        invoice += "     <paymenttype>"+ this.getPayment().getType() +"</paymenttype>  \n";
        invoice += "     <paymenttotal>"+ this.getPayment().getTotal() +"</paymenttotal>  \n";
        
        invoice += "     <paymentamount>"+ ( this.getPayment()).getAmount() +"</paymentamount>  \n";
        invoice += "     <paymentchange>"+ ( this.getPayment()).getChange() +"</paymentchange>  \n";
        
            
        if(this.getPayment() instanceof CreditPayment){
            invoice += "     <paymentCCNumber>"+ ((CreditPayment) this.getPayment()).getCCNumber() +"</paymentCCNumber>  \n";
        }
        
        invoice += "</salesrecord>";
        
        return invoice;
    }
    
    
    private int index;
    private Payment payment;
    private TransactionHeader header;
    private ArrayList<TransactionItem> transactionItems;
}
