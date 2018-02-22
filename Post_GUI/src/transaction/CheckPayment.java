package transaction;

/**
 *
 * @author Travis
 */
public class CheckPayment extends Payment {

    public CheckPayment(double total, double amount) {   
        this.type = "CHECK";
        this.total = total;
        this.amount = total;
        this.change = 0.0;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Paid by Check";
    }
    
    @Override
    public double getTotal(){
        return this.total;
    }
    @Override
    public double getAmount(){
        return this.total;
    }
    @Override
    public double getChange(){
        return this.change;
    }
    @Override
    public String getType(){
        return this.type;
    }
    
    private double amount;
   
}
