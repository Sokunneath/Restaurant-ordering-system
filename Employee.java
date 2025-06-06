import java.sql.Date;

public class Employee {
    String name;
    int idNumber;
    String role; //Cashier, manager
    double salary;
    String phoneNumber;
    String shift;
    String email;
    String password; //morning, afternoon, night
    
    //Constructor to add staff
    public Employee(String name, int idNumber, String role, double salary,
                    String phoneNumber, String shift, String email, String password) {
                this.name = name;
                this.idNumber = idNumber;
                this.role = role;
                this.salary = salary;
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
}