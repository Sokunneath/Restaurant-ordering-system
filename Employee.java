public class Employee {
    private int id;
    private String name;
    private String workingShift;
    private String phoneNumber;
    private String role;
    private String password;

    // Constructor
    public Employee(int id, String name, String workingShift, String phoneNumber, String role, String password) {
        this.id = id;
        this.name = name;
        this.workingShift = workingShift;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.password = password;
    }

    // Getters and Setters
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

    public String getWorkingShift() {
        return workingShift;
    }

    public void setWorkingShift(String workingShift) {
        this.workingShift = workingShift;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Main
    public static void main(String[] args) {
        // Create an Employee object
        Employee employee = new Employee(1, "Nary", "Morning & Afternoon", "012 345 678", "Cashier", "password123");

        // Print employee details
        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Working Shift: " + employee.getWorkingShift());
        System.out.println("Phone Number: " + employee.getPhoneNumber());
        System.out.println("Role: " + employee.getRole());
        System.out.println("Password: " + employee.getPassword());
    }
}