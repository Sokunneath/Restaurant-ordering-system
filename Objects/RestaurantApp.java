package Objects; // This class is in the same package as your other core objects

import java.util.Scanner;

import database.MySQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional; // Needed for stream operations inside authentication logic


public class RestaurantApp {

    private static Employee currentLoggedInUser = null; // Keeps track of the currently logged-in employee

    public static void main(String[] args) {
        
        database.MySQLConnection.getConnection(); // Initialize the database connection

        System.out.println("Input your email");
        String email = new Scanner(System.in).nextLine();
        System.out.println("Input your password");
        String password = new Scanner(System.in).nextLine();

        ResultSet resultSet = database.MySQLConnection.executeQuery("SELECT * FROM employee WHERE email = '" + email + "' AND password = '" + password + "'");
        try {
            if(resultSet != null && resultSet.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid email or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        
//To select and check the information of an employee, uncomment the following lines:
        /* 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your phone number:");
        String phoneNumber = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();

        Optional<Employee> employee = Employee.authenticate(phoneNumber, password);
        
        if (employee.isPresent()) {
            currentLoggedInUser = employee.get();
            System.out.println("Welcome " + currentLoggedInUser.getName() + "!");
            // You can add more functionality here for the logged-in user
        } else {
            System.out.println("Invalid phone number or password.");
        } */

    //To view all employees, uncomment the following lines:
/*         ResultSet resultSet = database.MySQLConnection.executeQuery("SELECT * FROM employee");

        try {
        while (resultSet != null && resultSet.next()) {
        String id = resultSet.getString("id");
        String name = resultSet.getString("name");
        String role = resultSet.getString("role");
        String phoneNumber = resultSet.getString("phone_number");
        String workingShift = resultSet.getString("working_shift");

        System.out.println(id + " | " + name + " | " + role + " | " + phoneNumber + " | " + workingShift);
    }
    } catch (SQLException e) {
    e.printStackTrace();
    } */

    //To insert the information of an employee into the database, uncomment the following lines:
/*     Scanner sc = new Scanner(System.in);
    System.out.println("Enter your name:");
    String name = sc.nextLine();
    System.out.println("Enter your working_shift:");
    String workingShift = sc.nextLine();
    System.out.println("Enter your phone number:");
    String phoneNumber = sc.nextLine();
    System.out.println("Enter your role:");
    String role = sc.nextLine();


    System.out.println(MySQLConnection.executeUpdate("INSERT INTO employee (name, role, phone_number, working_shift) VALUES ('" + name + "', '" + role + "', '" + phoneNumber + "', '" + workingShift + "')") + " row(s) inserted."); */
        database.MySQLConnection.closeConnection(); // Close the database connection
     
    }
}
}