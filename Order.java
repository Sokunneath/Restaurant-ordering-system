import java.security.Timestamp;

public class Order {
    int orderID;
    int tableNumber;
    int foodID;
    int[] quantity;
    String status;
    Timestamp orderTime;
    int[] subtotalprice;
    double totalPrice;
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