public class Employee {
    private int id;
    private String name;
    private String workingShift;
    private String phoneNumber;
    private String role; //Can be cashier or the manager
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
}