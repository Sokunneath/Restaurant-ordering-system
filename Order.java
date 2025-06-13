import java.security.Timestamp;
import java.util.List;

public class Order {
    private int orderID;
    private int tableNumber;
    private List<Order> items;
    private int[] quantity;
    private String status;
    private Timestamp orderTime;
    int[] subtotalprice;
    double totalPrice;
    public Order(int orderID, int tableNumber, int foodID, int[] quantity, String status, 
                 Timestamp orderTime, int[] subtotalprice, int[] totalprice){
        this.orderID = orderID;
        this.tableNumber = tableNumber;
        this.items = items;
        this.quantity = quantity;
        this.status = status;
        this.orderTime = orderTime;
        this.subtotalprice = subtotalprice;
        this.totalPrice = totalPrice;
        }


}