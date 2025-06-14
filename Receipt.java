import java.security.Timestamp;


public class Receipt {
    private int receiptID;
    private int orderID;
    private int tableNumber;
    private int foodID;
    private double totalPrice;
    private Timestamp dateTime;

    public Receipt(int receiptID, Order order) {
        this.receiptID = receiptID;
        this.orderID = orderID;
        this.tableNumber = tableNumber;
        this.foodID = foodID;
        this.totalPrice = totalPrice;
        this.dateTime = dateTime;
    }

}
