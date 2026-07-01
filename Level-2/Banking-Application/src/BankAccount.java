import exception.InsufficientFundsException;
import exception.InvalidBalanceException;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            throw new InvalidBalanceException("Balance cannot be negative!");
        }
    }

    public double getBalance() {
        return this.balance;
    }


    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Successfully deposited!");
        System.out.println("Amount: $" + amount);
        System.out.println("New balance: $" + this.balance);
    }

    public void withdraw(double amount) {
        if (this.balance < amount) {
            throw new InsufficientFundsException("Insufficient funds!");
        }

        this.balance -= amount;
        System.out.println("Successfully withdrawn!");
        System.out.println("Amount: $" + amount);
        System.out.println("New balance: $" + this.balance);
    }

    public void checkBalance() {
        System.out.println("Balance: $" + this.balance);
    }
}
