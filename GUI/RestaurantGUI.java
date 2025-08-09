package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Optional;

public class RestaurantGUI extends JFrame {

    // --- Simulated Core Java Objects (Employee, Manager, Cashier) ---
    // These are simplified for the GUI demo, mimicking your core logic.
    static class Employee {
        private static int idCounter = 1;
        public static final ArrayList<Employee> employees = new ArrayList<>();

        private int employeeID;
        private String name;
        private String email;
        private String password;
        private String role; // e.g., "Cashier", "Manager"

        public Employee(String name, String email, String password, String role) {
            this.employeeID = idCounter++;
            this.name = name;
            this.email = email;
            this.password = password;
            this.role = role;
            employees.add(this);
            System.out.println("New Employee registered (simulated): " + name + " as " + role);
        }

        public String getEmail() { return email; }
        public String getName() { return name; }
        public String getRole() { return role; }
        public boolean verifyPassword(String inputPassword) {
            return this.password != null && this.password.equals(inputPassword);
        }
    }

    static class Manager extends Employee {
        public Manager(String name, String email, String password) {
            super(name, email, password, "Manager");
        }
    }

    static class Cashier extends Employee {
        public Cashier(String name, String email, String password) {
            super(name, email, password, "Cashier");
        }
    }

    // --- GUI Components ---
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JLabel statusLabel; // For displaying messages

    public RestaurantGUI() {
        setTitle("Simple Employee Login/Sign Up");
        setSize(350, 300); // Smaller frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Initialize dummy employees for testing
        if (Employee.employees.isEmpty()) {
            new Manager("Alice Manager", "alice@example.com", "manager123");
            new Cashier("Bob Cashier", "bob@example.com", "cashier123");
            System.out.println("Dummy employees initialized in background.");
        }

        // --- Main Panel Layout ---
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10)); // Rows, 2 columns, gaps
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        // Components
        panel.add(new JLabel("Full Name (for Sign Up):"));
        nameField = new JTextField(15);
        panel.add(nameField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField(15);
        panel.add(emailField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
        panel.add(loginButton);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSignUp();
            }
        });
        panel.add(signUpButton);

        statusLabel = new JLabel("", SwingConstants.CENTER);
        statusLabel.setForeground(Color.BLUE.darker());
        panel.add(statusLabel); // Add status label to display messages

        add(panel); // Add the main panel to the frame
        setVisible(true);
    }

    // --- Event Handlers ---
    private void handleLogin() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        statusLabel.setText(""); // Clear previous message

        Optional<Employee> foundEmployee = Employee.employees.stream()
            .filter(emp -> emp.getEmail().equalsIgnoreCase(email))
            .findFirst();

        if (foundEmployee.isPresent()) {
            if (foundEmployee.get().verifyPassword(password)) {
                statusLabel.setText("Login successful! Welcome, " + foundEmployee.get().getName() + " (" + foundEmployee.get().getRole() + ").");
                JOptionPane.showMessageDialog(this, "Login Successful!\nWelcome, " + foundEmployee.get().getName(), "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                statusLabel.setText("Login failed: Incorrect password.");
                JOptionPane.showMessageDialog(this, "Login Failed: Incorrect password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            statusLabel.setText("Login failed: Employee not found.");
            JOptionPane.showMessageDialog(this, "Login Failed: Employee not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        // Clear password field for security
        passwordField.setText("");
    }

    private void handleSignUp() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        statusLabel.setText(""); // Clear previous message

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Sign-up failed: All fields are required.");
            JOptionPane.showMessageDialog(this, "Sign-up Failed: All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean emailExists = Employee.employees.stream()
            .anyMatch(emp -> emp.getEmail().equalsIgnoreCase(email));

        if (emailExists) {
            statusLabel.setText("Sign-up failed: An account with this email already exists.");
            JOptionPane.showMessageDialog(this, "Sign-up Failed: Email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // For simplicity, new sign-ups are Cashiers by default in this GUI
            new Cashier(name, email, password); // This creates the employee and adds to the static list
            statusLabel.setText("Sign-up successful! Please try logging in.");
            JOptionPane.showMessageDialog(this, "Sign-up Successful!\nAccount created for " + name, "Success", JOptionPane.INFORMATION_MESSAGE);
            // Clear all fields after successful sign-up
            nameField.setText("");
            emailField.setText("");
            passwordField.setText("");
        }
    }

    // --- Main method to run the GUI ---
    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (EDT) for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RestaurantGUI();
            }
        });
    }
}
