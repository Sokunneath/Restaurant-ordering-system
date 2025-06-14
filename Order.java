import java.security.Timestamp;

public class Order {
    public int orderID;
    private int tableNumber;
    private int foodID;
    private int[] quantity;
    private String status;
    private Timestamp orderTime;
    private int[] subtotalprice;
    private double totalPrice;
    public Order(int orderID, int tableNumber, int foodID, int[] quantity, String status, 
                 Timestamp orderTime, int[] subtotalprice, int[] totalprice){
        this.orderID = orderID;
        this.tableNumber = tableNumber;
        this.foodID = foodID;
        this.quantity = quantity;
        this.status = status;
        this.orderTime = orderTime;
        this.subtotalprice = subtotalprice;
        this.totalPrice = totalPrice;
        }


}