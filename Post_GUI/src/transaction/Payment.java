/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import java.util.HashMap;

/**
 *
 * @author Travis
 */
public abstract class Payment {

    protected double total;
    protected double amount;
    protected double change;
    protected String type;
    private static HashMap<String, Payment> payments = new HashMap();

    static {
        payments.put("cash", new CashPayment(0, 0));
        payments.put("check", new CheckPayment(0, 0));
        payments.put("credit", new CreditPayment(0, ""));
    }

    public Payment verifyPayment(String type) {
        return payments.get(type);
    }

    public abstract String getType();

    public abstract double getTotal();

    public abstract double getAmount();

    public abstract double getChange();
}
