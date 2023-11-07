import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin {

    private static final String SECRET_CODE = "oops123";

    public static void openAdminDashboard(JFrame previousFrame) {
        // Ask for the secret code using a dialog
        String enteredCode = JOptionPane.showInputDialog(null, "Enter Admin Secret Code:");

        // Check if the entered code is correct
        if (enteredCode != null && enteredCode.equals(SECRET_CODE)) {
            // Correct code, open the admin dashboard
            AdminDashboard.openAdminDashboard(previousFrame);
            previousFrame.dispose(); // Close the previous frame (home page)
        } else {
            // Incorrect code, show an error message
            JOptionPane.showMessageDialog(null, "Incorrect Admin Secret Code");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Event Booking - Admin Login");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            frame.add(panel);
            placeComponents(panel, frame);

            frame.setVisible(true);
        });
    }

    private static void placeComponents(JPanel panel, JFrame frame) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Admin Login");
        titleLabel.setBounds(110, 10, 80, 25);
        panel.add(titleLabel);

        JLabel codeLabel = new JLabel("Enter Code:");
        codeLabel.setBounds(30, 40, 80, 25);
        panel.add(codeLabel);

        JTextField codeText = new JTextField(20);
        codeText.setBounds(120, 40, 120, 25);
        panel.add(codeText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredCode = codeText.getText();

                // Check if the entered code is correct
                if (enteredCode != null && enteredCode.equals(SECRET_CODE)) {
                    // Correct code, open the admin dashboard
                    openAdminDashboard(frame);
                } else {
                    // Incorrect code, show an error message
                    JOptionPane.showMessageDialog(null, "Incorrect Admin Secret Code");
                }
            }
        });
    }
}
