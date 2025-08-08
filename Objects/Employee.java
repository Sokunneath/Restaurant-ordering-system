package Objects;
public class Employee {
    private int id;
    private String name;
    private String role;
    private double salary;
    private String phoneNumber;
    private String email;
    private String workingShift;
    private String password;


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
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
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

    public String getWorkingShift() {
        return workingShift;
    }
    public void setWorkingShift(String workingShift) {
        this.workingShift = workingShift;
    }

    private String setPassword(String password) {
        if(password != null && !password.isEmpty()) {
            this.password = password;
            return "Password set successfully.";
        } else {
            return "Invalid password.";
        }
    }


    
}