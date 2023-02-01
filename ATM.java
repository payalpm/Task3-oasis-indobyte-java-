import java.util.Scanner;
import java.util.ArrayList;

class Transaction {
    private int amount;
    private String type;

    public Transaction(int amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}

class User {
    private int userId;
    private int pin;
    private int balance;
    private ArrayList<Transaction> transactions;

    public User(int userId, int pin, int balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
        transactions = new ArrayList<Transaction>();
    }

    public boolean validate(int userId, int pin) {
        return (this.userId == userId) && (this.pin == pin);
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction(amount, "withdraw"));
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient balance. Please try again.");
        }
    }

    public void deposit(int amount) {
        balance += amount;
        transactions.add(new Transaction(amount, "deposit"));
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public void transfer(int amount, User recipient) {
        if (balance >= amount) {
            balance -= amount;
            recipient.balance += amount;
            transactions.add(new Transaction(amount, "transfer"));
            recipient.transactions.add(new Transaction(amount, "deposit"));
            System.out.println("Transfer successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient balance. Please try again.");
        }
    }

    public void showTransactions() {
        System.out.println("Transactions");
        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            System.out.println((i + 1) + ". " + t.getType() + " " + t.getAmount());
        }
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User(12345, 1234, 500);
        User recipient = new User(56789, 1111, 1000);

        System.out.print("Enter user ID: ");
        int userId = sc.nextInt();
        System.out.print("Enter user pin: ");
        int pin = sc.nextInt();

        if (!user.validate(userId, pin)) {
            System.out.println("Incorrect user ID or pin. Exiting...");
            sc.close();
            System.exit(0);
                            return;
        }

        System.out.println("Welcome! Choose an operation: ");
        System.out.println("1. Transactions history");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");

        int choice = sc.nextInt();
        while (choice != 5) {
            switch (choice) {
                case 1:
                    user.showTransactions();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int amount = sc.nextInt();
                    user.withdraw(amount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    amount = sc.nextInt();
                    user.deposit(amount);
                    break;
                case 4:
                    System.out.print("Enter amount to transfer: ");
                    amount = sc.nextInt();
                    user.transfer(amount, recipient);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("Choose an operation: ");
            System.out.println("1. Transactions history");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            choice = sc.nextInt();
        }

        System.out.println("Thank you for using our ATM. Have a great day!");
        sc.close();
    }
}
