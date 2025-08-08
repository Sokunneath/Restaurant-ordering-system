package Objects;

import java.util.ArrayList;
import java.util.List;

public class Cashier extends Employee {

    // Cashier-specific fields
    private List<Double> transactions; // List to store amounts of individual transactions
    private int transactionsHandled;  // Count of transactions processed
    private double totalSale;         // Sum of all sales handled

    // Static counter for all Cashier instances (optional, for specific cashier counts)
    private static int cashierCount = 0;

    public Cashier(String name, String email, String password) {
        // Call the superclass (Employee) constructor to set common employee details.
        // We explicitly set the role to "Cashier" here, and use default values
        // for salary, phoneNumber, and workingShift.
        super(name, "Cashier", 0.0, "Unknown", email, "Morning", password);

        // Initialize Cashier-specific fields
        this.transactions = new ArrayList<>();
        this.transactionsHandled = 0;
        this.totalSale = 0.0;
        cashierCount++; // Increment the static cashier count
        System.out.println("Cashier account created: " + name);
    }


    public Cashier(String name, double salary, String phoneNumber, String email, String workingShift, String password) {
        // Call the superclass constructor with all provided details, explicitly setting the role.
        super(name, "Cashier", salary, phoneNumber, email, workingShift, password);

        // Initialize Cashier-specific fields
        this.transactions = new ArrayList<>();
        this.transactionsHandled = 0;
        this.totalSale = 0.0;
        cashierCount++; // Increment the static cashier count
        System.out.println("Cashier account created: " + name);
    }

    // --- Getters for Cashier-specific fields (made public for external access) ---
    public List<Double> getTransactions() {
        // Return a copy to prevent external modification of the internal list
        return new ArrayList<>(transactions);
    }

    public int getTransactionsHandled() {
        return transactionsHandled;
    }

    public double getTotalSale() {
        return totalSale;
    }

    // --- Setters for Cashier-specific fields with validation (made public for external modification) ---
    public void setTransactions(List<Double> transactions) {
        if (transactions != null) {
            this.transactions = new ArrayList<>(transactions); // Store a new ArrayList to prevent external modification
        } else {
            System.out.println("Warning: Attempted to set transactions to null. Initializing with empty list.");
            this.transactions = new ArrayList<>(); // Initialize to an empty list
        }
    }

    public void setTransactionsHandled(int transactionsHandled) {
        if (transactionsHandled >= 0) {
            this.transactionsHandled = transactionsHandled;
        } else {
            System.out.println("Error: Transaction count cannot be negative. Value not updated.");
            // Optionally, you might throw an IllegalArgumentException here.
        }
    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        } else {
            System.out.println("Error: Total sale cannot be negative. Value not updated.");
        }
    }

    @Override
    public void recordTransaction(double amount) {
        // Call the superclass method first for any general employee transaction logging
        super.recordTransaction(amount);

        if (amount > 0) {
            this.transactions.add(amount); // Add to cashier's specific transaction list
            this.transactionsHandled++;     // Increment handled count
            this.totalSale += amount;       // Add to total sales
            System.out.println(getRole() + " " + getName() +
                               " recorded transaction #" + transactionsHandled + ": $" + String.format("%.2f", amount));
        } else {
            System.out.println("Invalid transaction amount for " + getName() + ". Amount must be positive.");
        }
    }

    /**
     * Prints the transaction history for this cashier.
     */
    public void printTransactionHistory() {
        System.out.println("\n--- Transaction History for " + getName() + " (ID: " + getEmployeeID() + ") ---");
        if (transactions.isEmpty()) {
            System.out.println("No transactions recorded yet.");
        } else {
            int i = 1;
            for (Double transaction : transactions) {
                System.out.println("Transaction " + (i++) + ": $" + String.format("%.2f", transaction));
            }
        }
        System.out.println("Total Transactions Handled: " + transactionsHandled);
        System.out.println("Total Sales: $" + String.format("%.2f", totalSale));
        System.out.println("----------------------------------------");
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " is processing customer orders and payments.");
    }

    @Override
    public String toString() {
        // Use String.format for better formatting of totalSale and transactions list
        return super.toString() +
               String.format("\nCashier Details {" +
                             "Transactions Handled: %d, " +
                             "Total Sales: $%.2f, " +
                             "Individual Transactions: %s}",
                             transactionsHandled, totalSale, transactions);
    }

    @Override
    public boolean equals(Object obj) {
        // First, check if the superclass considers them equal (based on employeeID)
        // This implicitly handles null, same instance, and class type checks.
        return super.equals(obj);
    }

    // Static method to get the total count of Cashier objects created
    public static int getCashierCount() {
        return cashierCount;
    }
}
