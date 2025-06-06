import java.util.Date;

public class Table {
    String sessionID;
    int tableNumber;
    String status;

    public Table(String sessionID, int tableNumber, String status) {
        this.sessionID = sessionID;
        this.tableNumber = tableNumber;
        this.status = status;
    }
}