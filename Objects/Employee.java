package Objects;
import java.util.ArrayList;
import java.util.Objects; // Import Objects for hash() and equals() utility methods

public class Employee {

    // 1. Data Encapsulation: Fields are private to protect data integrity.
    private int employeeID;
    private String name;
    private String role; // e.g., "Cashier", "Manager", "Chef"
    private double salary;
    private String phoneNumber;
    private String email;
    private String workingShift; // e.g., "Morning", "Afternoon", "Evening"
    private String password;     // NOTE: In a real system, passwords should be hashed, not stored in plain text.

    // 2. Static Counter: A single counter shared by all Employee objects to ensure unique IDs.
    private static int idCounter = 1;

    // 3. Static List: A list to keep track of all created Employee objects.
    public static final ArrayList<Employee> employees = new ArrayList<>(); // Use 'final' as the list reference shouldn't change.

    public Employee(String name, String role, double salary, String phoneNumber, String email, String workingShift, String password) {
        this.employeeID = idCounter++; // Assign unique ID and then increment counter.
        setName(name);             // Use setter for validation
        setRole(role);             // Use setter for validation
        setSalary(salary);         // Use setter for validation
        setPhoneNumber(phoneNumber); // Use setter for validation
        setEmail(email);           // Use setter for validation
        setWorkingShift(workingShift); // Use setter for validation
        setPassword(password);     // Use setter for validation
        employees.add(this);       // Add this new employee to the static list.
    }
    
    public Employee(String name, String email, String password) {
        // Call the main constructor with default values for other fields.
        this(name, "Unassigned", 0.0, "Unknown", email, "Morning", password);
    }

    // Removed the constructor public Employee(int id, String name, ...)
    // as the ID should be automatically generated, not passed in manually.


    // --- Getters and Setters with Validation (made public for broader access where appropriate) ---

    protected int getEmployeeID() {
        return employeeID;
    }
    // No public setId() method, as the employeeID should be unique and immutable after creation.

    public String getName() {
        return name;
    }
    protected void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            System.out.println("Error: Employee name cannot be null or empty. Name not set.");
            // In a real application, you might throw an IllegalArgumentException.
        }
    }

    protected String getRole() {
        return role;
    }
    protected void setRole(String role) {
        if (role != null && !role.trim().isEmpty()) {
            this.role = role.trim();
        } else {
            System.out.println("Error: Employee role cannot be null or empty. Role not set.");
        }
    }

    protected double getSalary() {
        return salary;
    }
    protected void setSalary(double salary) {
        if (salary >= 0) { // Salary can be 0, but not negative
            this.salary = salary;
        } else {
            System.out.println("Error: Salary cannot be negative. Salary not updated.");
        }
    }

    protected String getPhoneNumber() {
        return phoneNumber;
    }
    protected void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
            this.phoneNumber = phoneNumber.trim();
        } else {
            System.out.println("Error: Phone number cannot be null or empty. Setting to 'Unknown'.");
            this.phoneNumber = "Unknown";
        }
    }

    public String getEmail() {
        return email;
    }
    protected void setEmail(String email) { // Made public for external modification if needed
        if (email != null && email.contains("@") && email.contains(".")) { // Basic email format validation
            this.email = email.trim();
        } else {
            System.out.println("Error: Invalid email format or empty. Email not set.");
            // You might default to "Unknown" if this is acceptable.
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
            System.out.println("Error: Invalid shift. Please choose 'Morning', 'Afternoon', or 'Evening'. Shift not set.");
        }
    }

    // Password management: No getter for password for security reasons.
    // The setter is for internal use within the class or by trusted methods.
    private void setPassword(String password) { // Remains private
        if (password != null && !password.trim().isEmpty()) {
            // In a real application, you would hash the password here (e.g., using BCrypt).
            this.password = password.trim();
        } else {
            System.out.println("Error: Password cannot be null or empty. Password not set.");
        }
    }


    protected boolean verifyPassword(String inputPassword) {
        return this.password != null && this.password.equals(inputPassword);
    }


    protected void recordTransaction(double amount) {
        if (amount > 0) {
            System.out.println("General transaction recorded by " + getName() + ": $" + String.format("%.2f", amount));
        } else {
            System.out.println("Invalid transaction amount for " + getName() + ". Amount must be positive.");
        }
    }


    protected void performDuties() {
        System.out.println(getName() + " is performing general employee duties.");
    }


    @Override
    public String toString() {
        return String.format("Employee ID: %d, Name: %s, Role: %s, Salary: $%.2f, Phone: %s, Email: %s, Shift: %s",
                             employeeID, name, role, salary, phoneNumber, email, workingShift);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same object instance
        if (obj == null || getClass() != obj.getClass()) return false; // Null or different class
        Employee employee = (Employee) obj; // Cast to Employee
        return employeeID == employee.employeeID; // Equality based on unique employee ID
    }


    @Override
    public int hashCode() {
        return Objects.hash(employeeID); // Use Objects.hash() for a robust hash code.
    }
}
