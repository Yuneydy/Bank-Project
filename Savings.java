
/**
 * Savings allows a user to deposit and withdraw money from the account. 
 * A withdrawal transaction will not be completed if the balance falls below $0. 
 * There must be sufficient funds in the account. There is an interest rate of 
 * 0.5% added every month. 
 *
 * @author Yuneydy and Kyra
 * @version 10/11/2023
 */
public class Savings extends Account {
    private double interestRate;
    
    /**
     * Constructor for objects of class Savings
     */
    public Savings(double initialDeposit) {
        super(initialDeposit, "Savings");
        interestRate = 0.05;
    }
    
    
    /**
     * Adds interest with interestRate by 1 month.
     */
    public void accrueInterest() {
        double percentPerMonth = (interestRate/100)/12;
    
        balance = balance*(1+percentPerMonth);
        
    }
    
    /**
     * Subtracts the amount from the current balance.
     * 
     * @param amount, amount of money withdrawn from account
     */
    public void withdraw(double amount) {
        
        if ((amount > 0) && ((balance-amount) > 0) ) {
            balance -= amount;
            System.out.println("A withdraw of " + amount +" is ordered. Transaction COMPLETE");
        } else {
            System.out.println("A withdraw of $" + amount +" is ordered. Transaction DENIED. \nInsufficient Funds");
        }
        
        }
        
    public String toString() {
        String s = super.toString();
        return s + "    Interest Rate: " + interestRate + "\n";
    }
    }
