public class Order {
    private int orderId;
    private String status; 
    private int tableNumber;
    private String itemId;
    private double itemPrice;
    private int quantity;
    private double totalCost;
    private String orderTiming;
    private String remark;
    private int receiptId;

    // Static field to auto-generate order IDs
    private static int nextOrderId = 1001;

    // Static method to generate unique order ID
    public static int generateOrderId() {
        return nextOrderId++;
    }

    // Constructor
    public Order(int orderId, String status, int tableNumber, String itemId,
                 double itemPrice, int quantity, double totalCost,
                 String orderTiming, String remark, int receiptId) {
        this.orderId = orderId;
        this.status = status;
        this.tableNumber = tableNumber;
        this.itemId = itemId;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        this.totalCost = totalCost;
        this.orderTiming = orderTiming;
        this.remark = remark;
        this.receiptId = receiptId;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getOrderTiming() {
        return orderTiming;
    }

    public void setOrderTiming(String orderTiming) {
        this.orderTiming = orderTiming;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }
}