
/**
 * Account uses getter and setter methods to retrieve and reassign 
 * information for each unique account. Account allows the user to deposit 
 * and withdraw funds from the account, regardless of type.  
 *
 * @author Kyra and Yuneydy
 * @version 10/11/2023
 */
public abstract class Account {
    protected static double accountCount = 0;
    protected static double accountNum = 0; // for unique account numbers
    
    
    protected double id;
    protected double balance;
    
    protected String accountType;
    
    /**
     * Constructor for objects of class Account
     * 
     * @param initialDeposit, accountType, initial deposit for each account and account type (Savings or Checking)
     */
    public Account(double initialDeposit, String accountType) {
        this.accountType = accountType;
        
        balance = initialDeposit;
        id = accountNum;
        
        // Static variables will not reset with each account created
        accountNum++;
        accountCount++;
    }
    
    
    //Getters and Setters
    /**
     * Getter to retrieve the current balance in the account.
     * 
     * @return current balance of Account
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Getter to retrieve id of Account (it's specific accountNum).
     * 
     * @return current id of the Account
     */
    public double getID() {
       return id; 
    }
    
    /**
     * Setter to set balance for new Account.
     * 
     * @param new balance to be set to the Account
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
    
    // Deposit and Withdraw methods
    /**
     * Adds amount to current balance (Does not change depending on account).
     * 
     * @param amt, amount of money deposited to account
     */
    public void deposit(double amt) {
        balance += amt;
    }

    
    /**
     * Subtracts the amount from the current balance.
     * 
     * @param amount, amount of money withdrawned from account
     */
    public abstract void withdraw(double amount);
    
        
    /**
     * A string representation of an Account class.
     * 
     * @return String representation of Account class
     */
    public String toString(){
        return "*" + accountType +" Account Number: " + id + "   Balance $" + balance;
    }
    }