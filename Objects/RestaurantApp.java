package Objects;

import Objects.Employee;
import java.util.ArrayList;

public class RestaurantApp {
    public static void main(String[] args) {
        // Initialize the restaurant application
        System.out.println("Welcome to the Restaurant Ordering System!");
        // Here you can create instances of Employee, Cashier, Order, and OrderItem
        // and implement the logic to handle orders, payments, etc.
        // Create an Employee
        Employee emp1 = new Employee("Vuthy", 1, "Manager", "012345678", "Morning");
        System.out.println(emp1);

        // Create another Employee
        Employee emp2 = new Employee("Rith", 2, "Chef", "098765432", "Evening");
        System.out.println(emp2);

        // Compare Employees
        System.out.println("emp1 equals emp2? " + emp1.equals(emp2));

        // Record a general transaction
        emp1.recordTransaction(50.0);
        emp2.recordTransaction(-10.0);  // Invalid case

        // Display employee count
        System.out.println("Total employees: " + Employee.getEmployeeCount());
    }
}
