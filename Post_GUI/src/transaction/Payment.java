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
public abstract class Payment {

    protected double total;
    protected double amount;
    protected double change;
    protected String type;
    
    public abstract String getType();

    public abstract double getTotal();

    public abstract double getAmount();

    public abstract double getChange();
}
