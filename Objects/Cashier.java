package Objects;

import java.util.ArrayList;
import java.util.List;

public class Cashier extends Employee {
    private List<Double> transactions;
    private int transactionsHandled;
    private double totalSale;
    private static int cashierCount = 0;

    public Cashier(String name, int employeeId, String phoneNumber, String workingShift) {
    super(name, employeeId, "Cashier", phoneNumber, workingShift);
    setTransactions(new ArrayList<>());
    setTransactionsHandled(0);
    setTotalSale(0.0);
    cashierCount++;
    }

    //getter
    protected List<Double> getTransactions() {
    return transactions;
    }

    protected int getTransactionsHandled() {
    return transactionsHandled;
    }

    protected double getTotalSale() {
    return totalSale;
    }

    //setter
    protected void setTransactions(List<Double> transactions) {
    if (transactions != null) {
        this.transactions = transactions;
    } else {
        this.transactions = new ArrayList<>();
    }
    }

    protected void setTransactionsHandled(int transactionsHandled) {
    if (transactionsHandled >= 0) {
        this.transactionsHandled = transactionsHandled;
    } else {
        System.out.println("Transaction count cannot be negative.");
        this.transactionsHandled = 0;
    }
    }

    protected void setTotalSale(double totalSale) {
    if (totalSale >= 0) {
        this.totalSale = totalSale;
    } else {
        System.out.println("Total sale cannot be negative.");
        this.totalSale = 0.0;
    }
    }

    // Reuse superclass method and add custom logic
    @Override
    public void recordTransaction(double amount) {
        super.recordTransaction(amount);  // Optional general logging
        if (amount > 0) {
            transactions.add(amount);
            transactionsHandled++;
            totalSale += amount;
            System.out.println(getRole() + " " + getName() +
                   " handled transaction #" + transactionsHandled + ": $" + amount);
        } else {
            System.out.println("Invalid transaction amount for cashier.");
        }
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for " + getName() + ":");
        for (Double transaction : transactions) {
            System.out.println("$" + transaction);
        }
    }

    public void registerCashier() {
        System.out.println("New Cashier Registered:");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCashier Details {" +
                "transactionsHandled=" + transactionsHandled +
                ", totalSale=" + totalSale +
                ", transactions=" + transactions +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Cashier)) return false;
        Cashier other = (Cashier) obj;
        return transactions.equals(other.transactions);
    }

    public static int getCashierCount() {
        return cashierCount;
    }
}