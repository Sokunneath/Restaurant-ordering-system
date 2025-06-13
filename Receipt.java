import java.security.Timestamp;
import java.util.List;

public class Receipt {
    private int receiptID;
    private int orderID;
    private int tableNumber;
    private List<Order> items;
    private double totalPrice;
    private Timestamp dateTime;

    public Receipt(int receiptID, Order order) {
        this.receiptID = receiptID;
        this.orderID = orderID;
        this.tableNumber = tableNumber;
        this.items = items;
        this.totalPrice = totalPrice;
        this.dateTime = dateTime;
    }

}
