abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public abstract double calculateInterest(); 
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double initialBalance, double interestRate) {
        super(accountNumber, holderName, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate / 100; 
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double initialBalance, double overdraftLimit) {
        super(accountNumber, holderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        // Typically lower interest rate or no interest on current accounts
        return balance * 0.01 / 100; 
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= (balance + overdraftLimit)) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }
}

interface Loanable {
    boolean applyForLoan(double loanAmount);
    String calculateLoanEligibility();
}

class LoanableSavingsAccount extends SavingsAccount implements Loanable {

    public LoanableSavingsAccount(String accountNumber, String holderName, double initialBalance, double interestRate) {
        super(accountNumber, holderName, initialBalance);
    }

    @Override
    public boolean applyForLoan(double loanAmount) {
        // Simple eligibility check (can be more complex)
        if (balance > 10000) { 
            System.out.println("Loan application successful.");
            return true;
        } else {
            System.out.println("Loan application rejected.");
            return false;
        }
    }

    @Override
    public String calculateLoanEligibility() {
        return "Eligible for loan based on account balance."; 
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount savings = new LoanableSavingsAccount("SA123", "John Doe", 15000, 0.05);
        CurrentAccount current = new CurrentAccount("CA456", "Jane Smith", 5000, 1000);

        savings.deposit(500);
        savings.withdraw(2000);
        System.out.println("Savings Account Interest: " + savings.calculateInterest());
        savings.applyForLoan(10000); // Example loan application

        current.deposit(2000);
        current.withdraw(6000); // Should not exceed overdraft limit
        System.out.println("Current Account Interest: " + current.calculateInterest());

        // Polymorphism
        BankAccount[] accounts = {savings, current};
        for (BankAccount account : accounts) {
            account.displayAccountType(); 
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Holder Name: " + account.getHolderName());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("");
        }
    }
}
