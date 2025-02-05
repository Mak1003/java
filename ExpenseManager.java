import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ExpenseManager {
    private List<Expense> expenses;
    private String fileName;

    public ExpenseManager(String fileName) {
        this.expenses = new ArrayList<>();
        this.fileName = fileName;
        loadExpensesFromFile();
    }

    public void addExpense(double amount, String category, String description) {
        Expense expense = new Expense(amount, category, description);
        expenses.add(expense);
        saveExpensesToFile();
    }

    public double getTotalExpensesForDay() {
        Date today = new Date();
        return expenses.stream()
                .filter(e -> e.getDate().getDate() == today.getDate())
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public double getTotalExpensesForWeek() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date weekStartDate = cal.getTime();

        return expenses.stream()
                .filter(e -> e.getDate().after(weekStartDate))
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public double getTotalExpensesForMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date lastMonth = cal.getTime();

        return expenses.stream()
                .filter(e -> e.getDate().after(lastMonth))
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    private void loadExpensesFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] expenseData = line.split(",");
                double amount = Double.parseDouble(expenseData[0]);
                String category = expenseData[1];
                String description = expenseData[2];
                expenses.add(new Expense(amount, category, description));
            }
        } catch (IOException e) {
            System.out.println("Error loading data from file.");
        }
    }

    private void saveExpensesToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Expense expense : expenses) {
                bw.write(expense.getAmount() + "," + expense.getCategory() + "," + expense.getDescription());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data to file.");
        }
    }
}
