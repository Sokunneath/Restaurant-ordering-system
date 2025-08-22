package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import database.MySQLConnection;

public class AuthenticationFrame extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;

    public AuthenticationFrame() {
        setTitle("Restaurant System - Login");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color startColor = Color.decode("#6dc8b0ff");
                Color endColor = new Color(0, 191, 140);
                GradientPaint gp = new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(null);
        setContentPane(panel);

        JLabel title = new JLabel("Welcome!", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setBounds(50, 20, 350, 40);
        panel.add(title);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(50, 80, 100, 25);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 80, 220, 25);
        panel.add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        passLabel.setBounds(50, 120, 100, 25);
        panel.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 120, 220, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 170, 150, 35);
        styleButton(loginButton, new Color(46, 204, 113), Color.WHITE);
        panel.add(loginButton);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(220, 170, 150, 35);
        styleButton(signUpButton, new Color(52, 152, 219), Color.WHITE);
        panel.add(signUpButton);

        JLabel resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setBounds(50, 220, 320, 25);
        panel.add(resultLabel);

        loginButton.addActionListener(e -> login(resultLabel));
        signUpButton.addActionListener(e -> signUpDialog());

        setVisible(true);
    }

    private void login(JLabel resultLabel) {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if(email.isEmpty() ||  password.isEmpty()) {
            resultLabel.setForeground(Color.RED);
            resultLabel.setText("Please enter email and password.");
            return;
        }

        boolean success = MySQLConnection.login(email, password); 
        if(success) {
            resultLabel.setForeground(Color.GREEN);
            resultLabel.setText("Login successful!");

            // ✅ Fetch employee ID as String
            String employeeId = MySQLConnection.getEmployeeIdByEmail(email);
            if(employeeId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Failed to retrieve employee info!");
                return;
            }

            dispose(); // close login window
            new EmployeeDashboard(employeeId, email); // open dashboard
        } else {
            resultLabel.setForeground(Color.RED);
            resultLabel.setText("Invalid email or password.");
        }
    }

    private void signUpDialog() {
        JDialog dialog = new JDialog(this, "Sign Up", true);
        dialog.setSize(400, 300);
        dialog.setLayout(null);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.decode("#ADD8E6")); // Light blue
        dialog.setContentPane(panel);

        JLabel empLabel = new JLabel("Employee ID:");
        empLabel.setBounds(30, 30, 100, 25);
        panel.add(empLabel);

        JTextField empField = new JTextField();
        empField.setBounds(150, 30, 200, 25);
        panel.add(empField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 70, 100, 25);
        panel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(150, 70, 200, 25);
        panel.add(emailField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 110, 100, 25);
        panel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 110, 200, 25);
        panel.add(passField);

        JButton createButton = new JButton("Create Account");
        createButton.setBounds(120, 160, 150, 35);
        styleButton(createButton, new Color(46, 204, 113), Color.WHITE);
        panel.add(createButton);

        createButton.addActionListener(e -> {
            String empId = empField.getText();
            String email = emailField.getText();
            String password = new String(passField.getPassword());

            if(empId.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Please fill all fields!");
                return;
            }

            int result = MySQLConnection.signUp(empId, email, password);
            if(result == 1) {
                JOptionPane.showMessageDialog(dialog, "Account created successfully!");
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Sign Up failed! Email may already exist.");
            }
        });

        dialog.setVisible(true);
    }

    private void styleButton(JButton button, Color bg, Color fg) {
        button.setBackground(bg);
        button.setForeground(fg);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { button.setBackground(bg.darker()); }
            @Override
            public void mouseExited(MouseEvent e) { button.setBackground(bg); }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AuthenticationFrame());
    }
}