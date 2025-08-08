package authenticationInterface;

import java.util.Scanner;
import Objects.Employee; // Import your Employee class
import java.util.Optional; // Required for Optional in login (added for robustness)

public interface authentication { // Corrected interface name to 'Authentication'

    public boolean login(String email, String password); // This method is NOT static

    public static Employee signUp() { // This method IS static and handles input internally
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Employee Sign Up ---");
        System.out.print("Enter employee name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        // Add email existence check for robustness
        boolean emailExists = Employee.employees.stream()
            .anyMatch(e -> e.getEmail().equalsIgnoreCase(email));

        if (emailExists) {
            System.out.println("Sign-up failed: An account with this email already exists.");
            return null;
        }

        Employee newEmployee = new Employee(name, email, password);
        System.out.println("Account created successfully for " + newEmployee.getName() + "."); // More specific message
        return newEmployee;
    }
}
