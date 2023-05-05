import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame {

    private JLabel nameLabel;
    private JButton viewDetailsButton;

    public Client(String name) {
        setTitle("Client Details");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the labels
        nameLabel = new JLabel("Name: " + name);

        // Initialize the view details button
        viewDetailsButton = new JButton("View Details");
        viewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Add code to view more details
                JOptionPane.showMessageDialog(null, "View more details of client: " + name, "Details", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Add the label and button to a single panel with FlowLayout
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 60, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        panel.add(nameLabel);
        panel.add(viewDetailsButton);

        // Add the panel to the JFrame
        add(panel);

        // Display the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        Client clientDetails = new Client("John Doe");
    }
}
