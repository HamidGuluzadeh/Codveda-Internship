import exception.InsufficientFundsException;
import exception.InvalidBalanceException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        BankAccount account = new BankAccount("AZ123456",5000);

        while (running) {
            System.out.println("BANK");
            System.out.println("---------------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println(" ");
            System.out.print("Enter choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        int depositAmount = scan.nextInt();
                        scan.nextLine();
                        account.deposit(depositAmount);
                        break;

                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        int withdrawAmount = scan.nextInt();
                        scan.nextLine();
                        account.withdraw(withdrawAmount);
                        break;

                    case 3:
                        account.checkBalance();
                        break;

                    case 4:
                        running = false;
                        System.out.println("Logging out...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                        break;
                }

            } catch (InvalidBalanceException exception) {
                System.out.println(exception.getMessage());
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
