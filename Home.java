import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Home {

    private static List<JPanel> eventPanels = new ArrayList<>();

    public static void openHomePage(JFrame previousFrame) {
        previousFrame.dispose(); // Close the signup page

        JFrame homeFrame = new JFrame("Event Booking - Home Page");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setSize(600, 400);
        homeFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        homeFrame.add(panel);
        placeComponents(panel);

        homeFrame.setVisible(true);
    }

    public static void placeComponents(JPanel panel) {
        panel.setLayout(new GridLayout(0, 1, 10, 10));

        for (JPanel eventPanel : eventPanels) {
            panel.add(eventPanel);
        }

        JButton adminLoginButton = new JButton("Admin Login");
        adminLoginButton.addActionListener(e -> Admin.openAdminDashboard((JFrame) SwingUtilities.getWindowAncestor(panel)));
        panel.add(adminLoginButton);
    }
    public static void addEventToHomePage(String eventName, String imageLink, String eventInfo, String eventPrice, int seats) {
        JPanel eventPanel = new JPanel();
        eventPanel.setLayout(new GridLayout(6, 1));

        JLabel nameLabel = new JLabel("Event Name: " + eventName);
        JLabel imageLabel = new JLabel("Image Link: " + imageLink);
        JLabel infoLabel = new JLabel("Event Information: " + eventInfo);
        JLabel priceLabel = new JLabel("Event Price: " + eventPrice);

        // Use an array to store a mutable integer (seats[0])
        final int[] remainingSeats = {seats};
        JLabel seatsLabel = new JLabel("Number of Seats: " + remainingSeats[0]);

        JButton bookButton = new JButton("Book");
        JLabel seatsRemainingLabel = new JLabel("Seats Remaining: " + remainingSeats[0]);

        eventPanel.add(nameLabel);
        eventPanel.add(imageLabel);
        eventPanel.add(infoLabel);
        eventPanel.add(priceLabel);
        eventPanel.add(seatsLabel);
        eventPanel.add(bookButton);
        eventPanel.add(seatsRemainingLabel);

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle booking logic
                if (remainingSeats[0] > 0) {
                    // Decrease the number of seats
                    remainingSeats[0]--;
                    seatsRemainingLabel.setText("Seats Remaining: " + remainingSeats[0]);

                    // Show booking confirmation
                    JOptionPane.showMessageDialog(eventPanel, "Event Booked!");
                } else {
                    // All seats booked, show a message
                    JOptionPane.showMessageDialog(eventPanel, "Seats Full!");
                }
            }
        });

        eventPanels.add(eventPanel);
    }



}
