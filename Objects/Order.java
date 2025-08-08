package Objects;

import java.util.ArrayList;
import java.util.List;

// Import the Orderitem class (adjust the package if needed)
import Objects.OrderItem;

public class Order {
    private int orderId;
    private String orderDate;
    private int tableNumber;
    private int itemId;
    private int quantity;
    private double subTotal;
    private List<OrderItem> orderItems = new ArrayList<>();
    private double totalAmount;

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        if (orderId <= 0) {
            System.out.println(" Invalid Order ID: must be positive.");
            return;
        }
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        if (orderDate == null || orderDate.trim().isEmpty()) {
            System.out.println(" Invalid Order Date: cannot be null or empty.");
            return;
        }
        this.orderDate = orderDate;
    }

    public int getTableNumber() {
        return tableNumber;
    }
    public void setTableNumber(int tableNumber) {
        if (tableNumber <= 0) {
            System.out.println(" Invalid Table Number: must be positive.");
            return;
        }
        this.tableNumber = tableNumber;
    }

    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        if (itemId <= 0) {
            System.out.println(" Invalid Item ID: must be positive.");
            return;
        }
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Invalid Quantity: cannot be negative.");
            return;
        }
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }
    public void setSubTotal(double subTotal) {
        if (subTotal < 0) {
            System.out.println(" Invalid SubTotal: cannot be negative.");
            return;
        }
        this.subTotal = subTotal;
    }

    public List<OrderItem> getOrderItems() {
        return new ArrayList<>(orderItems);  // return copy for safety
    }
    public void setOrderItems(List<OrderItem> orderItems) {
        if (orderItems == null) {
            System.out.println(" Invalid Order Items List: cannot be null.");
            return;
        }
        this.orderItems = new ArrayList<>(orderItems); // defensive copy
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        if (totalAmount < 0) {
            System.out.println(" Invalid Total Amount: cannot be negative.");
            return;
        }
        this.totalAmount = totalAmount;
    }
}