import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor to initialize the balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Get the current balance
    public double getBalance() {
        return balance;
    }

    // Deposit amount to the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + String.format("%.2f", amount));
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw amount from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + String.format("%.2f", amount));
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
        return false;
    }
}

public class ATMInterface {

    private BankAccount account;

    // Constructor to initialize ATM with a bank account
    public ATMInterface(BankAccount account) {
        this.account = account;
    }

    // Check current balance
    public void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", account.getBalance());
    }

    // Deposit amount
    public void deposit(double amount) {
        account.deposit(amount);
        checkBalance();
    }

    // Withdraw amount
    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            checkBalance();
        }
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(500.0); // Initial balance set to $500
        ATMInterface atm = new ATMInterface(userAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Welcome to the ATM ====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Validate menu input
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next(); // Clear invalid input
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    if (scanner.hasNextDouble()) {
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                    } else {
                        System.out.println("Invalid amount. Please try again.");
                        scanner.next(); // Clear invalid input
                    }
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    if (scanner.hasNextDouble()) {
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Invalid amount. Please try again.");
                        scanner.next(); // Clear invalid input
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
