import java.util.ArrayList;

public class Receipt {
    private int receiptId;
    private double totalCost;
    private int employeeId;
    private int tableNumber;
    private ArrayList<Integer> orderIds; // why do you want to use the arraylist instead of other type like set or map
    private int timestamp;

    // Constructor
    public Receipt(int receiptId, double totalCost, int employeeId, int tableNumber,
                  ArrayList<Integer> orderIds, int timestamp) {
        this.receiptId = receiptId;
        this.totalCost = totalCost;
        this.employeeId = employeeId;
        this.tableNumber = tableNumber;
        this.orderIds = orderIds;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public int getReceiptId() {
        return receiptId;
    }

//if you set something you have to have the condition
    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
    if (totalCost < 0) {
        System.out.println("Total cost can't be negative");
        return;
    }
    this.totalCost = totalCost;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
    if (tableNumber <= 0 || tableNumber > 20) {
        System.out.println("Table number must be between 1 and 20.");
        return;
    }
    this.tableNumber = tableNumber;
    }

    public ArrayList<Integer> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(ArrayList<Integer> orderIds) {
    if (orderIds == null || orderIds.isEmpty()) {
        System.out.println("Order list can't be null or empty.");
        return;
    }
    for (Integer id : orderIds) {
        if (id == null || id <= 0) {
            System.out.println("Order IDs must be positive numbers.");
            return;
        }
    }
    this.orderIds = orderIds;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}