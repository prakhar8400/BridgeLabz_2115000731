
public class BankAccount {
    private static int totalAccounts = 0; 
    private final int accountNumber;
    private String accountHolderName;
    private double balance;
    private static final String bankName = "XYZ Bank"; 

    public BankAccount(String accountHolderName) {
        this.accountNumber = ++totalAccounts; 
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount. Must be greater than 0.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Must be greater than 0.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public static void displayAccountDetails(Object account) {
        if (account instanceof BankAccount) {
            BankAccount acc = (BankAccount) account; 
            System.out.println("Account Number: " + acc.accountNumber);
            System.out.println("Account Holder: " + acc.accountHolderName);
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("Bank Name: " + bankName); 
        } else {
            System.out.println("Invalid account object.");
        }
    }
}

