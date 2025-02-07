public class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void displayAccountType() {
        System.out.println("Account Type: Bank Account");
    }
}

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}

public class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double initialBalance, double withdrawalLimit) {
        super(accountNumber, initialBalance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= withdrawalLimit && balance >= amount) {
            balance -= amount;
        } else if (amount > withdrawalLimit) {
            System.out.println("Withdrawal amount exceeds limit.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }
}

public class FixedDepositAccount extends BankAccount {
    private double interestRate;
    private int tenureInMonths;

    public FixedDepositAccount(String accountNumber, double initialBalance, double interestRate, int tenureInMonths) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
        this.tenureInMonths = tenureInMonths;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTenureInMonths() {
        return tenureInMonths;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("SA123", 1000, 0.05);
        savingsAccount.displayAccountType();

        CheckingAccount checkingAccount = new CheckingAccount("CA456", 5000, 1000);
        checkingAccount.displayAccountType();

        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("FD789", 20000, 0.07, 12);
        fixedDepositAccount.displayAccountType();
    }
}
