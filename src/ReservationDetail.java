import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReservationDetail extends JFrame {
    private JLabel numeroLabel;
    private JLabel dateLabel;
    private JLabel typeLabel;
    private JLabel serviceLabel;

    private JButton editButton;

    public ReservationDetail(String numero, String date, String type, String service) {
        super("Reservation Detail Frame");

        // Create the labels for the reservation details
        numeroLabel = new JLabel("Numero: " + numero);
        dateLabel = new JLabel("Date: " + date);
        typeLabel = new JLabel("Type: " + type);
        serviceLabel = new JLabel("Service Demande: " + service);

        // Create the edit button
        editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show an edit dialog to modify the reservation details
                showEditDialog();
            }
        });

        // Add the components to the frame
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(numeroLabel);
        panel.add(dateLabel);
        panel.add(typeLabel);
        panel.add(serviceLabel);
        panel.add(editButton);
        add(panel);

        // Set the frame properties
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showEditDialog() {
        // Show a dialog to edit the reservation details
        JTextField numeroField = new JTextField(numeroLabel.getText().split(": ")[1]);
        JTextField dateField = new JTextField(dateLabel.getText().split(": ")[1]);
        JTextField typeField = new JTextField(typeLabel.getText().split(": ")[1]);
        JTextField serviceField = new JTextField(serviceLabel.getText().split(": ")[1]);

        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.add(new JLabel("Numero: "));
        panel.add(numeroField);
        panel.add(new JLabel("Date: "));
        panel.add(dateField);
        panel.add(new JLabel("Type: "));
        panel.add(typeField);
        panel.add(new JLabel("Service Demande: "));
        panel.add(serviceField);

        int result = JOptionPane.showConfirmDialog(
                this,
                panel,
                "Edit Reservation Details",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            // Update the reservation details labels with the new values
            numeroLabel.setText("Numero: " + numeroField.getText());
            dateLabel.setText("Date: " + dateField.getText());
            typeLabel.setText("Type: " + typeField.getText());
            serviceLabel.setText("Service Demande: " + serviceField.getText());
        }
    }

    public static void main(String[] args) {
        new ReservationDetail("1234", "2023-05-07", "Type A", "Service X, Service Y");
    }
}
