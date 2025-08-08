package authenticationInterface;
import java.util.Scanner;


import Objects.Employee;
import Objects.Cashier;

public abstract class authentication {
    public abstract boolean login();
    public abstract void logout();
    public static Employee register(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter Email: ");
        String email = scanner2.nextLine();
        Scanner scanner3 = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = scanner3.nextLine();
        // This is a placeholder implementation

        Employee newaccount = new Employee(username, email, password);
        System.out.println("User registered successfully!");
        return newaccount; // Assuming Employee has this constructor
}
}
