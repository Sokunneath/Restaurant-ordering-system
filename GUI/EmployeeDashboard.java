package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import database.MySQLConnection;

public class EmployeeDashboard extends JFrame {
    private String employeeId;
    private String email;

    private JLabel empIdLabel, nameLabel, shiftLabel, phoneLabel, roleLabel;
    private JButton mainEditButton;
    private JButton editNameBtn, editShiftBtn, editPhoneBtn, editRoleBtn;

    private boolean editMode = false;

    public EmployeeDashboard(String employeeId, String email) {
        this.employeeId = employeeId;
        this.email = email;

        setTitle("Employee Dashboard");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        setContentPane(panel);

        JLabel title = new JLabel("Employee Dashboard", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setBounds(150, 20, 250, 30);
        panel.add(title);

        // Fetch employee info
        Map<String, String> empInfo = MySQLConnection.getEmployeeInfo(employeeId);
        System.out.println("Employee data: " + empInfo); // debug

        empIdLabel = new JLabel("Employee ID: " + empInfo.getOrDefault("employee_id", "N/A"));
        empIdLabel.setBounds(50, 80, 300, 25);
        panel.add(empIdLabel);

        nameLabel = new JLabel("Name: " + empInfo.getOrDefault("name", "N/A"));
        nameLabel.setBounds(50, 120, 300, 25);
        panel.add(nameLabel);

        shiftLabel = new JLabel("Shift: " + empInfo.getOrDefault("shift", "N/A"));
        shiftLabel.setBounds(50, 160, 300, 25);
        panel.add(shiftLabel);

        phoneLabel = new JLabel("Phone: " + empInfo.getOrDefault("phone", "N/A"));
        phoneLabel.setBounds(50, 200, 300, 25);
        panel.add(phoneLabel);

        roleLabel = new JLabel("Role: " + empInfo.getOrDefault("role", "N/A"));
        roleLabel.setBounds(50, 240, 300, 25);
        panel.add(roleLabel);

        // Edit buttons
        editNameBtn = createEditButton(360, 120);
        panel.add(editNameBtn);
        editNameBtn.setVisible(false);

        editShiftBtn = createEditButton(360, 160);
        panel.add(editShiftBtn);
        editShiftBtn.setVisible(false);

        editPhoneBtn = createEditButton(360, 200);
        panel.add(editPhoneBtn);
        editPhoneBtn.setVisible(false);

        editRoleBtn = createEditButton(360, 240);
        panel.add(editRoleBtn);
        editRoleBtn.setVisible(false);

        mainEditButton = createEditButton(480, 20);
        panel.add(mainEditButton);
        mainEditButton.addActionListener(e -> toggleEditMode());

        editNameBtn.addActionListener(e -> editField("name", nameLabel));
        editShiftBtn.addActionListener(e -> editField("working_shift", shiftLabel));
        editPhoneBtn.addActionListener(e -> editField("phone_number", phoneLabel));
        editRoleBtn.addActionListener(e -> editField("role", roleLabel));

        setVisible(true);
    }
// edit sign 
private JButton createEditButton(int x, int y) {
    JButton btn = new JButton("Edit");
    btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    btn.setBounds(x, y, 70, 30);
    return btn;
}

    private void toggleEditMode() {
        editMode = !editMode;
        editNameBtn.setVisible(editMode);
        editShiftBtn.setVisible(editMode);
        editPhoneBtn.setVisible(editMode);
        editRoleBtn.setVisible(editMode);
    }

    private void editField(String dbColumn, JLabel label) {
        String[] parts = label.getText().split(": ");
        String fieldName = parts[0];
        String oldValue = parts.length > 1 ? parts[1] : "";

        String newValue = JOptionPane.showInputDialog(this, "Enter new " + fieldName + ":", oldValue);


if (newValue != null && !newValue.trim().isEmpty()) {
            boolean success = MySQLConnection.updateEmployeeField(employeeId, dbColumn, newValue);
            if (success) {
                label.setText(fieldName + ": " + newValue);
                JOptionPane.showMessageDialog(this, fieldName + " updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update " + fieldName);
            }
        }
    }
}