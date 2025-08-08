package Objects; // This class is in the same package as your other core objects

import java.util.Scanner;
import java.util.Optional; // Needed for stream operations inside authentication logic


public class RestaurantApp {

    private static Employee currentLoggedInUser = null; // Keeps track of the currently logged-in employee

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🍽 Welcome to the Restaurant App! 🍽");

        // --- 1. Initial Setup: Create some dummy employee accounts for demonstration ---
        System.out.println("\n--- Initializing Dummy Employee Accounts ---");
        System.out.println("Please sign up Dara Manager (email: dara@email.com, password: admin)");
        // Call the internal static signUp method for initial setup
        registerNewEmployee(scanner);

        System.out.println("\nPlease sign up Sok Cashier (email: sok@email.com, password: 1234)");
        // Call the internal static signUp method for another dummy employee
        registerNewEmployee(scanner);

        System.out.println("\nInitial employees created (you just entered them):");
        for(Employee emp : Employee.employees) { // Loop through the static list to display created employees
            System.out.println(emp.getName() + " (" + emp.getRole() + ") - ID: " + emp.getEmployeeID());
        }

        // --- Main Application Loop ---
        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Login");
            System.out.println("2. Sign Up (New Employee)");
            System.out.println("3. View All Employees");
            System.out.println("4. Perform My Duties (if logged in)");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue; // Skip the rest of the current loop iteration
            }

            switch (choice) {
                case 1: // Login
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    // Call the internal static login method
                    Employee loggedIn = authenticateUser(email, password);
                    if (loggedIn != null) {
                        currentLoggedInUser = loggedIn; // Set the static field in RestaurantApp
                        // Success/failure messages are handled by authenticateUser() itself
                    }
                    break;

                case 2: // Sign Up
                    // Call the internal static signUp method
                    Employee newEmployee = registerNewEmployee(scanner); // Pass scanner to it
                    if (newEmployee != null) {
                        System.out.println("New employee signed up successfully: " + newEmployee.getName() + ".");
                    } else {
                        // Failure message is handled by registerNewEmployee()
                    }
                    break;

                case 3: // View All Employees
                    System.out.println("\n--- All Registered Employees ---");
                    if (Employee.employees.isEmpty()) {
                        System.out.println("No employees registered yet.");
                    } else {
                        for (Employee emp : Employee.employees) {
                            System.out.println("ID: " + emp.getEmployeeID() + ", Name: " + emp.getName() + ", Role: " + emp.getRole() + ", Email: " + emp.getEmail());
                        }
                    }
                    break;

                case 4: // Perform My Duties
                    if (currentLoggedInUser != null) {
                        currentLoggedInUser.performDuties(); // Calls the specific performDuties based on the actual type (Cashier or Manager)
                    } else {
                        System.out.println("Please log in first to perform duties.");
                    }
                    break;

                case 5: // Logout
                    if (currentLoggedInUser != null) {
                        System.out.println(currentLoggedInUser.getName() + " has logged out.");
                        currentLoggedInUser = null; // Clear the logged-in user reference
                    } else {
                        System.out.println("No one is currently logged in.");
                    }
                    break;

                case 6: // Exit
                    running = false;
                    System.out.println("Exiting Restaurant System. Goodbye! 👋");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }

        scanner.close(); // Close the scanner to release system resources
    }

    /**
     * Handles the login logic directly within the RestaurantApp class.
     * Searches for an employee by email and verifies their password.
     *
     * @param email The email address of the user.
     * @param password The password of the user.
     * @return The logged-in Employee object if successful, null otherwise.
     */
    private static Employee authenticateUser(String email, String password) {
        Optional<Employee> foundEmployee = Employee.employees.stream()
            .filter(e -> e.getEmail().equalsIgnoreCase(email))
            .findFirst();

        if (foundEmployee.isPresent()) {
            if (foundEmployee.get().verifyPassword(password)) {
                System.out.println("Login successful for " + foundEmployee.get().getName() + " (" + foundEmployee.get().getRole() + ")");
                return foundEmployee.get();
            } else {
                System.out.println("Login failed: Incorrect password.");
            }
        } else {
            System.out.println("Login failed: Employee with email '" + email + "' not found.");
        }
        return null;
    }

    /**
     * Handles the new employee sign-up logic directly within the RestaurantApp class.
     * Prompts for user details and creates a new Employee account, ensuring email uniqueness.
     *
     * @param scanner The Scanner instance to read user input.
     * @return The newly created Employee object if successful, or null if sign-up fails.
     */
    private static Employee registerNewEmployee(Scanner scanner) {
        System.out.println("\n--- New Employee Sign Up ---");
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check if an employee with this email already exists
        boolean emailExists = Employee.employees.stream()
            .anyMatch(e -> e.getEmail().equalsIgnoreCase(email));

        if (emailExists) {
            System.out.println("Sign-up failed: An account with this email already exists.");
            return null;
        }

        Employee newEmployee = new Employee(name, email, password); // Creates a new Employee object
        System.out.println("Account created successfully for " + newEmployee.getName() + ".");
        return newEmployee;
    }
}
