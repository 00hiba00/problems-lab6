package problem2;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public boolean addCustomer(String customerName) {
        if (findCustomer(customerName) == null) {
            customers.add(new Customer(customerName));
            System.out.println("Customer " + customerName + " added to the bank.");
            return true;
        } else {
            System.out.println("Customer " + customerName + " already exists.");
            return false;
        }
    }

    public boolean addTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            System.out.println("Transaction of " + amount + " added for " + customerName);
            return true;
        } else {
            System.out.println("Customer " + customerName + " not found.");
            return false;
        }
    }

    private Customer findCustomer(String name) {
        for (Customer c : customers) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public void printStatements() {
        System.out.println("\n=== Bank Statement for " + name + " ===");
        for (Customer c : customers) {
            c.printTransactions();
            System.out.println();
        }
    }
    
}
