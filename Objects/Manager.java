package Objects;


import java.util.ArrayList;
import java.util.Optional; // Needed for stream operations

public class Manager extends Employee {

    public Manager(String name, String email, String password) {
        // Call the superclass constructor, leveraging the full constructor of Employee
        // with appropriate default values and setting the role explicitly to "Manager".
        super(name, "Manager", 0.0, "Unknown", email, "Morning", password);
        System.out.println("Manager account created: " + name);
    }

    public Manager(String name, double salary, String phoneNumber, String email, String workingShift, String password) {
        // Call the superclass constructor with all details, setting the role explicitly.
        super(name, "Manager", salary, phoneNumber, email, workingShift, password);
        System.out.println("Manager account created: " + name);
    }

    public void manageStaff() {
        System.out.println(getName() + " (Manager) is managing staff operations.");
        // Implement staff management logic here
    }

    public void viewReports() {
        System.out.println(getName() + " (Manager) is viewing financial reports.");
        // Implement report viewing logic here
    }

    public void addMenuItem(Menu item) {
        if (item != null) {
            // Check if an item with the same ID already exists (though ID should be unique)
            boolean exists = Menu.menuItems.stream().anyMatch(m -> m.getId() == item.getId());
            if (!exists) {
                Menu.menuItems.add(item);
                System.out.println(getName() + " (Manager) added menu item: " + item.getName());
            } else {
                System.out.println(getName() + " (Manager) failed to add menu item: " + item.getName() + ". Item with this ID already exists.");
            }
        } else {
            System.out.println(getName() + " (Manager) cannot add a null menu item.");
        }
    }

    public void removeMenuItem(Menu item) {
        if (item != null) {
            if (Menu.menuItems.remove(item)) { // Uses the equals() method of Menu
                System.out.println(getName() + " (Manager) removed menu item: " + item.getName());
            } else {
                System.out.println(getName() + " (Manager) failed to remove menu item: " + item.getName() + ". Item not found.");
            }
        } else {
            System.out.println(getName() + " (Manager) cannot remove a null menu item.");
        }
    }

    public void viewEmployees() {
        System.out.println("\n--- Current Employee List (Managed by " + getName() + ") ---");
        if (Employee.employees.isEmpty()) {
            System.out.println("No employees registered yet.");
        } else {
            for (Employee emp : Employee.employees) {
                System.out.println("ID: " + emp.getEmployeeID() + ", Name: " + emp.getName() + ", Role: " + emp.getRole() + ", Email: " + emp.getEmail());
            }
        }
        System.out.println("----------------------------------------");
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " is overseeing all restaurant operations and managing staff.");
    }
}