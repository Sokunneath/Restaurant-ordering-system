import java.security.Timestamp;
import java.util.List;

public class Receipt {
    public int receiptID;
    public int orderID;
    public int tableNumber;
    public List<Order> items;
    public double totalPrice;
    public Timestamp dateTime;

    public Receipt(int receiptID, Order order) {
        this.receiptID = receiptID;
        this.orderID = orderID;
        this.tableNumber = tableNumber;
        this.items = items;
        this.totalPrice = totalPrice;
        this.dateTime = dateTime;
    }

}
