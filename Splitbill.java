import java.security.Timestamp;


public class Splitbill {
    int invoiceID;
    int sessionID;
    String name;
    int tableNumber;
    int[] splitID;
    Timestamp orderTime;

    public Splitbill(int invoiceID, int sessionID, String name, 
                int tableNumber, int[] splitID, Timestamp orderTime) {
        this.invoiceID = invoiceID;
        this.sessionID = sessionID;
        this.name = name;
        this.tableNumber = tableNumber;
        this.splitID = splitID;
        this.orderTime = orderTime;
    }

}