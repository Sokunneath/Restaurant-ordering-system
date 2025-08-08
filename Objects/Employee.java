package Objects;

import java.lang.reflect.Array;
import java.util.ArrayList;

// import authentication;

public class Employee {
    private int id;
    private String name;
    private String role;
    private double salary;
    private String phoneNumber;
    private String email;
    private String workingShift;
    private String password;
    private static int idcounter = 1; // Static counter to ensure unique IDs
    public static ArrayList<Employee> employees = new ArrayList<>();

    public Employee(int id, String name, String role, double salary, String phoneNumber, String email, String workingShift, String password) {
        this.id = idcounter++;
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        setEmail(email);
        this.workingShift = workingShift;
        setPassword(password);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    protected double getSalary() {
        return salary;
    }
    protected void setSalary(double salary) {
        if (salary < 100) {
            System.out.println("Salary cannot be less than 50. Setting to default value of 0.");
            this.salary = 100;
        } else {
            this.salary = salary;
        }
    }
    protected String getPhoneNumber() {
        return phoneNumber;
    }
    protected void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            System.out.println("Phone number cannot be null or empty. Setting to default value of 'Unknown'.");
            this.phoneNumber = "Unknown";
        } else {
            this.phoneNumber = phoneNumber;
        }
    }
    protected String getEmail() {
        return email;
    }
    private void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            System.out.println("Email cannot be null or empty. Setting to ");
            this.email = "Unknown";
        } else {
            this.email = email;
        }
    }

    protected String getWorkingShift() {
        return workingShift;
    }
    protected void setWorkingShift(String workingShift) {
        if ("Morning".equalsIgnoreCase(workingShift) ||
            "Afternoon".equalsIgnoreCase(workingShift) ||
            "Evening".equalsIgnoreCase(workingShift)) {
            this.workingShift = workingShift;
        } else {
            System.out.println("Invalid shift.");
        }
    }

    private String setPassword(String password) {
        if(password != null && !password.isEmpty()) {
            this.password = password;
            return "Password set successfully.";
        } else {
            return "Invalid password.";
        }
    }

 @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", employeeId=" + employeeId +
                ", role='" + role + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", workingShift='" + workingShift + '\'' +
                '}';
    }

    // Method for recording transactions (common utility method)
    public void recordTransaction(double amount) {
        if (amount > 0) {
            System.out.println("General transaction recorded: $" + amount);
        } else {
            System.out.println("Invalid transaction amount.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return this.employeeId == other.employeeId &&
               this.name.equals(other.name) &&
               this.role.equals(other.role);
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }
    
}