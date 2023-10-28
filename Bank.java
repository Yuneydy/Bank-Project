
/**
 * Bank creates a collection of accounts where all accounts are stored 
 * in an array. Bank allows the user to find a specific account in the 
 * collection and calculate the total funds from all the accounts in the 
 * collection. The main method is used to test all methods and display the 
 * Bank.
 *
 * @author Yuneydy and Kyra
 * @version 10/11/2023
 */
public class Bank {
    private Account[] collection; 
    private int accountCount; // changes in addAccount AND specifically increases as more as accounts are added
    private double totalFunds;
    
    /**
     * Constructor for objects of class Bank
     */
    public Bank(int maxAccounts) {
        collection = new Account[maxAccounts];
        
        accountCount = 0;
        totalFunds = 0;
        
    }
    
    /**
     * Adds account (either Savings or Checking) to the collection (array of Accounts).
     * 
     * @param type, type of account, Savings or Checking
     */
    public void addAccount(Account type) {
        if (accountCount < collection.length){
            collection[accountCount] = type;
            accountCount++; // number of Accounts in Bank
        } else {
            System.out.println("Cannot add more accounts. \nBank is full.");
        }
        
    }
    
    /**
     * Calculates total funds from all accounts in Bank.
     * 
     * @return total funds from all accounts in Bank
     */
    public double calculateTotalFunds() {
        //calculate totalFunds here 
        // Iterate over list and add all balances
        // for totalFunds
        double total = 0;
        for (Account account: collection) {
           total += account.getBalance();
        }
        totalFunds = total;
        return totalFunds;
    }
    
    /**
     * Iterates over the collection of Accounts to find specific account and its information.
     * 
     * @param value, specific account user wants to find
     * @return The specific account and its information
     */
    public Account findAccount(double value) {
        for (int i = 0; i < accountCount; i++) {
            if (collection[i].getID() == value) {
                System.out.println("Account found:");
                return collection[i];
            }
        }
        System.out.println("This Account was not Found:");
        return null;
    }
    
    /**
     * String representation of Bank.
     * 
     * @return String representation of Bank
     */
    public String toString() {
        String s = "In our Bank we currently have these accounts: \n";
        
        for (int i= 0; i < accountCount; i++){
            s += collection[i];
        }
        
        if (accountCount == 0) {
            s += "There are no accounts in this Bank. \n";
        }
        return s;
    }
    
    /**
     * Testing main method
     */
    public  static void main(String [] args) {
        Savings s1 = new Savings(100);
        Checking c2 = new Checking(200);
        Checking c3 = new Checking(150);
        Savings s4 = new Savings(3000);
        Checking c5 = new Checking(400);
        
        Bank KyrasBank= new Bank(4);
        
        System.out.println("---------------Testing findAccount() with empty Bank------------");
        System.out.println(KyrasBank);
        
        // --------------------TESTING BANK METHODS-------------------
        System.out.println("\nTESTING BANK METHODS \n");
        //Testing addAccount()
        System.out.println("---------------Testing addAccount() method: (Adding first Account)------------");
        KyrasBank.addAccount(s1);
        System.out.println(KyrasBank);
        
        System.out.println("\n---------------Testing addAccount() method: (Adding second account)-----------");
        KyrasBank.addAccount(c2);
        System.out.println(KyrasBank);
        
        // Adding all five accounts to Bank:
        System.out.println("\n---------------Testing addAccount() method: (Adding past maxAmount of Accounts)-----------");
        KyrasBank.addAccount(c3);
        KyrasBank.addAccount(s4);
        KyrasBank.addAccount(c5);
        
        System.out.println(KyrasBank);
        
        
        //Testing findAccount
        System.out.println("\n---------------Testing findAccount() method: (A KNOWN account: s1)-----------");
        System.out.println(KyrasBank.findAccount(1));
        
        System.out.println("\n---------------Testing findAccount() method: (An UNKNOWN account)-----------");
        System.out.println(KyrasBank.findAccount(7) + "\n");
        
        
        //Testing calculateTotalFunds()
        System.out.println("\n---------------Testing calculateTotalFunds() method with KyrasBank-----------");
        System.out.println("Expected total funds: $3450 \nActual total funds: $" + KyrasBank.calculateTotalFunds());
        
        
        
        // -------------------TESTING ACCOUNT METHODS-------------------
        
        //Testing Account method deposit()
        System.out.println("\n\nTESTING ACCOUNT METHODS \n");
        System.out.println("---------------Testing deposit() method on Account c2 -----------");
        System.out.println("Starting Account c2 balance: $" + c2.getBalance() + 
        "\nAdding $123 deposit");
        c2.deposit(123);
        System.out.println("(Expected: $323) Actual balance: $" + c2.getBalance());
        
        System.out.println("\n---------------Testing deposit() method on Account s4 (Not in Bank) -----------");
        System.out.println("Starting Account s4 balance: $" + s4.getBalance() + 
        "\nAdding $102 deposit...");
        s4.deposit(102);
        System.out.println("(Expected: $402) Actual balance: $" + s4.getBalance());
        
        //Testing Account method withdraw()
        
        //Case will withdraw
        System.out.println("\n---------------Testing withdraw() method on Savings Account s1 -----------");
        System.out.println("Starting Account s1 balance: $" + s1.getBalance() + 
        "\nSubtracting $75 withdrawal...");
        s1.withdraw(75);
        System.out.println("(Expected: $25) Actual balance: $" + s1.getBalance());
        
        //Case will NOT withdraw
        System.out.println("\n---------------Testing withdraw() method on Savings Account s1 -----------");
        System.out.println("Starting Account s1 balance: $" + s1.getBalance() + 
        "\nSubtracting another $75 withdrawal...");
        s1.withdraw(75);
        System.out.println("(Expected: $25) Actual balance: $" + s1.getBalance());
        
        
        //Case will withdraw and charge fee
        System.out.println("\n---------------Testing withdraw() method on Checking Account c3 (Uses chargeFee() in Checking class) -----------");
        System.out.println("Starting Account c3 balance: $" + c3.getBalance() + 
        "\nSubtracting $90 withdrawal...");
        c3.withdraw(90);
        System.out.println("(Expected: $60) Actual balance: $" + c3.getBalance());
        
        //Case will withdraw and end with negative value and charge fee
        System.out.println("\n---------------Testing withdraw() method on Checking Account c3 (Uses chargeFee() in Checking class) -----------");
        System.out.println("Starting Account c3 balance: $" + c3.getBalance() + 
        "\nSubtracting another $90 withdrawal...");
        c3.withdraw(90);
        System.out.println("(Expected: $-80) Actual balance: $" + c3.getBalance());
        
        //Case will withdraw and not charge fee
        System.out.println("\n---------------Testing withdraw() method on Checking Account c5 (Uses chargeFee() in Checking class) -----------");
        System.out.println("Starting Account c5 balance: $" + c5.getBalance() + 
        "\nSubtracting $90 withdrawal...");
        c5.withdraw(90);
        System.out.println("(Expected: $310) Actual balance: $" + c5.getBalance());
        
        
        //Testing Savings Account method accrueInterest()
        
        System.out.println("\n---------------Testing accrueInterest() method on Savings Account s4 -----------");
        System.out.println("Starting Account s4 balance: $" + s4.getBalance() + 
        "\nAccruing interest after 1 month...");
        s4.accrueInterest();
        System.out.println("(Expected: $3102.13) Actual balance: $" + s4.getBalance());
        
        
        System.out.println("\n---------------ENDING STATE OF BANK -----------");
        System.out.println(KyrasBank);
        
        System.out.println("\n---------------TOTAL FUNDS-----------");
        System.out.println("Expected total funds: $3370.13 \nActual total funds: $" + KyrasBank.calculateTotalFunds());
        
    }
}
