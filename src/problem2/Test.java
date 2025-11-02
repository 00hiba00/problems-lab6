package problem2;

public class Test {
    public static void main(String[] args) {
        Bank bank = new Bank("MyBank");

        bank.addCustomer("Alice");
        bank.addCustomer("Bob");

        bank.addTransaction("Alice", 200.0);  // credit
        bank.addTransaction("Alice", -50.0);  // debit
        bank.addTransaction("Bob", 1000.0);
        bank.addTransaction("Bob", -200.0);

        bank.printStatements();
    }
}
