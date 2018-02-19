package transaction;

import java.text.SimpleDateFormat;
import java.sql.Date;

public class TransactionHeader {
    String customerName;
    Date date;
    
    public TransactionHeader(String name, java.util.Date date){
        this.customerName = name;
        this.date = new java.sql.Date(date.getTime());        
    }
    
    public String getCustomerName(){
        return this.customerName;
    }
    
    public String getDateAsString(){
        return new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(date);
    }    // toString();
    
    public Date getDate(){
        return this.date;
    }
    
    @Override
    public String toString() {
        String s = "Customer Name: " + customerName + "  Date: " + this.getDateAsString();
        return s;
    }
}
