
/**
 * Checking allows a user to deposit and withdraw money from the account 
 * but if the balance falls below $100, an overdraft fee of $25 is applied. 
 * The transaction is still completed even if the balance falls below $0.
 *
 * @author Yuneydy and Kyra
 * @version 10/13/2023
 */
public class Checking extends Account {

    private double overdraftFee;
    private double minimumBalance;

    
    /**
     * Constructor for objects of class Checking
     */
    public Checking(double initialDeposit) {
        super(initialDeposit,"Checking");
        overdraftFee = 25.0;
        minimumBalance = 100.0;
        
    }
    
    
        
    /**
     * Subtracts the overdraftFee from the current balance if 
     * the account balance is below the minimumBalance.
     */
    private void chargeFee() {
        
        if (balance < minimumBalance) { 
            balance -= overdraftFee; 
            System.out.println("Checking Account below Minimum Balance: Overdraft Fee has been charged \nCurrent balance is now: $" + this.balance);
        } else {
            System.out.println("Checking Account above Minimum Balance: Overdraft Fee has NOT been charged\nCurrent balance is: $" + this.balance);
        }
        
    }
    
    
    /**
     * Subtracts the amount from the current balance.
     * 
     * @param amount, amount of money withdrawned from account
     */
    public void withdraw(double amount) {
        
        if (amount > 0) {
            balance -= amount;
            System.out.println("A withdraw of $" + amount +" is ordered. Transaction COMPLETE");
        } else {
            System.out.println("A withdraw of $" + amount +" is ordered. Transaction DENIED. \nInsufficient Funds");
        }
        
        chargeFee();
        }
        
    public String toString() {
        String s = super.toString();
        return s + "   Minimum Balance: " + minimumBalance + "    Overdraft Fee: " + overdraftFee + "\n";
    }
    }
    

