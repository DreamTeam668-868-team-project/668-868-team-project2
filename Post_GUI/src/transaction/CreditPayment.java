/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

/**
 *
 * @author Travis
 */
public class CreditPayment extends Payment {

    public CreditPayment(double total, String creditCardNumber) {
        this.type = "CREDIT";
        this.total = total;
        this.amount = total;
        this.change = 0.0;
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public String toString() {
        return "Credit Card " + this.creditCardNumber;
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
    
    public String getCCNumber(){
        return this.creditCardNumber;
    }
    
    private String creditCardNumber;
}
