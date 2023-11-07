import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Event Booking - Signup");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 250);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            frame.add(panel);
            placeComponents(panel, frame);

            frame.setVisible(true);
        });
    }

    private static void placeComponents(JPanel panel, JFrame frame) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Event Booking");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(120, 10, 200, 30);
        panel.add(titleLabel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 60, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(150, 60, 200, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 100, 200, 25);
        panel.add(passwordText);

        JButton signupButton = new JButton("Signup");
        signupButton.setBounds(180, 150, 80, 30);
        panel.add(signupButton);

        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                // Perform signup logic and store in a text file
                datastore.signup(username, password);

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);

                // Open the home page
                Home.openHomePage(frame);
            }
        });
    }
}
