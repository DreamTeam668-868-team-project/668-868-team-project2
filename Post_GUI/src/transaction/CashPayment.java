package transaction;

/**
 *
 * @author Travis
 */
public class CashPayment extends Payment {

    // provide total + amount paid
    public CashPayment(double total, double amount) {
        this.type = "CASH";
        this.total = total;
        this.amount = amount;
        this.change = amount - total;
    }

    public void setChange(double change){
        this.change = change;
    }
    
    @Override
    public double getTotal(){
        return this.total;
    }
    @Override
    public double getAmount(){
        return this.amount;
    }
    @Override
    public double getChange(){
        return this.change;
    }
    @Override
    public String getType(){
        return this.type;
    }
    
    @Override
    public String toString() {
        return "$" + amount + "\n$" + change;
    }
}
