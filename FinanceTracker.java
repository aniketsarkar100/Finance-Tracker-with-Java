import java.util.*;

public class FinanceTracker {
    static class Transaction {
        String description;
        double amount;
        Date date;

        Transaction(String description, double amount) {
            this.description = description;
            this.amount = amount;
            this.date = new Date();
        }

        public String toString() {
            return date + " | " + description + " | ₹" + amount;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Transaction> transactions = new ArrayList<>();
        double balance = 0.0;

        while (true) {
            System.out.println("\n--- Personal Finance Tracker ---");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. View Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter income description: ");
                    String incomeDesc = scanner.nextLine();
                    System.out.print("Enter income amount: ₹");
                    double incomeAmt = Double.parseDouble(scanner.nextLine());
                    transactions.add(new Transaction("Income - " + incomeDesc, incomeAmt));
                    balance += incomeAmt;
                    break;

                case 2:
                    System.out.print("Enter expense description: ");
                    String expenseDesc = scanner.nextLine();
                    System.out.print("Enter expense amount: ₹");
                    double expenseAmt = Double.parseDouble(scanner.nextLine());
                    transactions.add(new Transaction("Expense - " + expenseDesc, -expenseAmt));
                    balance -= expenseAmt;
                    break;

                case 3:
                    System.out.println("\n--- Transactions ---");
                    for (Transaction t : transactions) {
                        System.out.println(t);
                    }
                    break;

                case 4:
                    System.out.printf("Current Balance: ₹%.2f\n", balance);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
