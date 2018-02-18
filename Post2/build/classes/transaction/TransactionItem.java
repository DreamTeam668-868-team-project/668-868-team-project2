package transaction;


/**
 *
 * @author Travis
 */
public class TransactionItem {
    public TransactionItem(String upc, int quantity){
        this.upc = upc;
        this.quantity = quantity;
    }
    
    public String getUPC(){
        return this.upc;
    }
    
    public int getQuantity(){
        return this.quantity;
    
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    @Override
    public String toString(){
        return getUPC() + " " + getQuantity();
    }
    
    private String upc;
    private int quantity;
}
