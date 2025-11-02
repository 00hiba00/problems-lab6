package problem2;
import java.util.ArrayList;
public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double amount) {
        transactions.add(amount); // Autoboxing: double → Double
    }

    public void printTransactions() {
        System.out.println("Transactions for " + name + ":");
        for (Double amount : transactions) { // Unboxing: Double → double
            System.out.println("  " + amount);
        }
    }
}
