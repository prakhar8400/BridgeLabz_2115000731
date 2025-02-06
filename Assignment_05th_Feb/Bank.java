import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private List<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public String getBankName() {
        return bankName;
    }

    public void openAccount(Customer customer, Account account) {
        customer.addAccount(account); 
        // Assuming Customer class has a method to add accounts
    }
}

class Customer {
    private String customerName;
    private List<Account> accounts;

    public Customer(String customerName) {
        this.customerName = customerName;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void viewBalance(Account account) {
        System.out.println("Current Balance: " + account.getBalance()); 
    }
}

class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
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
}

public class Main {
    public static void main(String[] args) {
        // Create a Bank
        Bank bank = new Bank("XYZ Bank");

        // Create Customers
        Customer customer1 = new Customer("John Doe");
        Customer customer2 = new Customer("Jane Smith");

        // Create Accounts
        Account account1 = new Account(1000.0);
        Account account2 = new Account(500.0);

        // Associate Customers with the Bank and Accounts with Customers
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);
        bank.openAccount(customer1, account1);
        bank.openAccount(customer2, account2);

        // Customer views balance
        customer1.viewBalance(account1); 
    }
}
