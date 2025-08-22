package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Objects.Employee;

import java.sql.ResultSet;

public class MySQLConnection {

    private static Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/restaurant";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Wiikyben66^^";

    // Establish the connection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Connected to MySQL successfully!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Login method
    public static boolean login(String email, String password) {
        String sql = "SELECT * FROM loginaccount WHERE email=? AND password_hash=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // returns true if a record is found
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // in case of error, treat as failed login
        }
    }


    // Sign-Up method
    public static int signUp(String employeeId, String email, String password) {
        String sql = "INSERT INTO loginaccount (employee_id, email, password_hash) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, employeeId);
            stmt.setString(2, email);
            stmt.setString(3, password);
            return stmt.executeUpdate(); // returns 1 if inserted successfully
        } catch (SQLException e) {
            e.printStackTrace();
            return 0; // failed to insert
        }
    }

    // Get Employee ID by email
    public static String getEmployeeIdByEmail(String email) {
        String sql = "SELECT employee_id FROM loginaccount WHERE email=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("employee_id");
                System.out.println("Employee ID fetched from DB: " + id); // debug
                return String.valueOf(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    // Fetch employee info by ID
    public static Map<String, String> getEmployeeInfo(String employeeId) {
        Map<String, String> employeeData = new HashMap<>();
        String query = "SELECT id, name, working_shift, phone_number, role FROM employee WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, Integer.parseInt(employeeId)); // fix for int column
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                employeeData.put("employee_id", String.valueOf(rs.getInt("id")));
                employeeData.put("name", rs.getString("name"));
                employeeData.put("shift", rs.getString("working_shift"));
                employeeData.put("phone", rs.getString("phone_number"));
                employeeData.put("role", rs.getString("role"));
            } else {
                System.out.println("No employee found with ID: " + employeeId); // debug
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeData;
    }

public static boolean updateEmployeeField(String employeeId, String columnName, String newValue) {
        // Only allow certain columns to be updated
        List<String> allowedColumns = Arrays.asList("name", "working_shift", "phone_number", "role");
        if (!allowedColumns.contains(columnName)) {
            System.out.println("Invalid column name!");
            return false;
        }

        String query = "UPDATE employee SET `" + columnName + "` = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, newValue);
            stmt.setInt(2, Integer.parseInt(employeeId));

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Close the connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.out.println("Failed to close the connection!");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        getConnection();
    }
}