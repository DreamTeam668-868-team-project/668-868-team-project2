package transaction;

/**
 *
 * @author Travis
 */
public class CashPayment extends Payment {

    double amount;
    double change;

    // provide total + amount paid
    public CashPayment(double amount, double total) {
        this.amount = amount;
        this.change = total - amount;
    }

    public double getAmount() {
        return amount;
    }

    public double getChange() {
        return change;
    }
    
    public void setChange(double change){
        this.change = change;
    }
    
    @Override
    public String toString() {
        return "$" + amount + "\n$" + change;
    }
}
