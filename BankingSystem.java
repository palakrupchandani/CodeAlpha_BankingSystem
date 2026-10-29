import java.util.ArrayList;
import java.util.Scanner;

public class BankingSystem {

    static Scanner sc = new Scanner(System.in);

    static String accountHolder;
    static int accountNumber;
    static double balance = 0;

    static ArrayList<String> transactions = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        System.out.println("===== WELCOME TO BANKING SYSTEM =====");

        createAccount();

        do {
            System.out.println("\n===== BANKING MENU =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. View Account Details");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    depositMoney();
                    break;

                case 2:
                    withdrawMoney();
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    viewAccountDetails();
                    break;

                case 5:
                    viewTransactionHistory();
                    break;

                case 6:
                    System.out.println("Thank you for using our Banking System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }

    static void createAccount() {

        sc.nextLine();

        System.out.print("Enter account holder name: ");
        accountHolder = sc.nextLine();

        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();

        System.out.print("Enter initial deposit amount: ");
        balance = sc.nextDouble();

        if (balance < 0) {
            balance = 0;
            System.out.println("Invalid amount. Balance set to zero.");
        }

        transactions.add("Account created with balance Rs. " + balance);

        System.out.println("\nAccount created successfully!");
    }

    static void depositMoney() {

        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        if (amount > 0) {

            balance += amount;

            transactions.add("Deposited Rs. " + amount);

            System.out.println("Money deposited successfully!");
            System.out.println("Current Balance: Rs. " + balance);

        } else {
            System.out.println("Please enter a valid amount.");
        }
    }

    static void withdrawMoney() {

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {

            System.out.println("Please enter a valid amount.");

        } else if (amount > balance) {

            System.out.println("Insufficient balance.");

        } else {

            balance -= amount;

            transactions.add("Withdrawn Rs. " + amount);

            System.out.println("Money withdrawn successfully!");
            System.out.println("Current Balance: Rs. " + balance);
        }
    }

    static void checkBalance() {

        System.out.println("Available Balance: Rs. " + balance);
    }

    static void viewAccountDetails() {

        System.out.println("\n===== ACCOUNT DETAILS =====");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Balance: Rs. " + balance);
    }

    static void viewTransactionHistory() {

        System.out.println("\n===== TRANSACTION HISTORY =====");

        if (transactions.isEmpty()) {

            System.out.println("No transactions available.");

        } else {

            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }
}
