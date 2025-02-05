import java.util.Date;

public class Expense {
    private double amount;
    private String category;
    private String description;
    private Date date;

    public Expense(double amount, String category, String description) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = new Date();  // Capture the current date of the expense
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Amount: " + amount + ", Category: " + category + ", Description: " + description + ", Date: " + date.toString();
    }
}
