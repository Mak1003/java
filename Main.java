import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager("expenses.txt");

        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. View Total Expenses for Today");
            System.out.println("3. View Total Expenses for This Week");
            System.out.println("4. View Total Expenses for This Month");
            System.out.println("5. View All Expenses");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter category (e.g., food, travel): ");
                    String category = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    manager.addExpense(amount, category, description);
                    System.out.println("Expense added.");
                    break;
                case 2:
                    System.out.println("Total expenses for today: " + manager.getTotalExpensesForDay());
                    break;
                case 3:
                    System.out.println("Total expenses for the week: " + manager.getTotalExpensesForWeek());
                    break;
                case 4:
                    System.out.println("Total expenses for the month: " + manager.getTotalExpensesForMonth());
                    break;
                case 5:
                    System.out.println("All Expenses:");
                    for (Expense e : manager.getExpenses()) {
                        System.out.println(e);
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
