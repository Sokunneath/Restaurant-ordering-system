import java.sql.Date;
import java.util.LinkedList;

public class Employee {
    public String name;
    public int idNumber;
    public String role; //Cashier, manager
    private String phoneNumber;
    public String shift;
    private String email;
    private String password; //morning, afternoon, night


    private static LinkedList<Employee> staffList = new LinkedList<Employee>();

    //Constructor to add staff
    public Employee(String name, int idNumber, String role,
                    String phoneNumber, String shift, String email, String password) {
                this.name = name;
                this.idNumber = idNumber;
                this.role = role;
                this.phoneNumber = phoneNumber;
                this.shift = shift;
                this.email = email;
                this.password = password;
                }
    
    //Constructor to login
    public Employee(String email, String password) {
        this.email = email;
        this.password = password;
    }

    void addItem()
    {
        System.out.println("Add item to menu here: ");
    }

    public static LinkedList<Employee> getStaffList() {
        return staffList;
    }
    
}