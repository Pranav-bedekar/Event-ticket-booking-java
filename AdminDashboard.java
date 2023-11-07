import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard {

    public static void openAdminDashboard(JFrame previousFrame) {
        JFrame adminFrame = new JFrame("Admin Dashboard");
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(400, 400);
        adminFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));

        JLabel titleLabel = new JLabel("Create Event");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel eventNameLabel = new JLabel("Event Name:");
        JTextField eventNameField = new JTextField();

        JLabel imageLinkLabel = new JLabel("Image Link:");
        JTextField imageLinkField = new JTextField();

        JLabel eventInfoLabel = new JLabel("Event Information:");
        JTextArea eventInfoArea = new JTextArea();
        JScrollPane eventInfoScrollPane = new JScrollPane(eventInfoArea);

        JLabel eventPriceLabel = new JLabel("Event Price:");
        JTextField eventPriceField = new JTextField();

        JLabel seatsLabel = new JLabel("Number of Seats:");
        JTextField seatsField = new JTextField();

        JButton createEventButton = new JButton("Create Event");

        panel.add(titleLabel);
        panel.add(new JLabel()); // Empty space
        panel.add(eventNameLabel);
        panel.add(eventNameField);
        panel.add(imageLinkLabel);
        panel.add(imageLinkField);
        panel.add(eventInfoLabel);
        panel.add(eventInfoScrollPane);
        panel.add(eventPriceLabel);
        panel.add(eventPriceField);
        panel.add(seatsLabel);
        panel.add(seatsField);
        panel.add(new JLabel()); // Empty space
        panel.add(createEventButton);

        createEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eventName = eventNameField.getText();
                String imageLink = imageLinkField.getText();
                String eventInfo = eventInfoArea.getText();
                String eventPrice = eventPriceField.getText();
                String seatsText  = seatsField.getText();
                int seats = Integer.parseInt(seatsText);

                // Validate and handle event creation logic (you can customize this)

                // Update the home page dynamically
                Home.addEventToHomePage(eventName, imageLink, eventInfo, eventPrice, seats);

                // Display a message or update UI to show the created event
                JOptionPane.showMessageDialog(adminFrame, "Event Created:\nName: " + eventName +
                        "\nImage Link: " + imageLink + "\nInformation: " + eventInfo +
                        "\nPrice: " + eventPrice + "\nSeats: " + seats);

                // Take the admin back to the home page
                adminFrame.dispose();  // Close the admin dashboard frame
                Home.openHomePage(previousFrame);
            }
        });

        adminFrame.add(panel);
        adminFrame.setVisible(true);
    }
}
