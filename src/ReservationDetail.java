import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReservationDetail extends JFrame {
    private JLabel nomLabel;
    private JLabel prenomLabel;
    private JLabel nssLabel;
    private JLabel dateLabel;
    private JLabel typeLabel;
    private JLabel serviceLabel;

    private JButton editButton;

    public ReservationDetail(String nom,String prenom,String nss, String date, String type, String service) {
        super("Reservation Detail Frame");

        // Create the labels for the reservation details
        nomLabel = new JLabel("Nom: " + nom);
        prenomLabel = new JLabel("Prenom: " + prenom);
        nssLabel = new JLabel("NSS: " + nss);        
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
        panel.add(nomLabel);
        panel.add(prenomLabel);
        panel.add(nssLabel);
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
        JTextField nomField = new JTextField(nomLabel.getText().split(": ")[1]);
        JTextField prenomField = new JTextField(prenomLabel.getText().split(": ")[1]);
        JTextField nssField = new JTextField(nssLabel.getText().split(": ")[1]);
        JTextField dateField = new JTextField(dateLabel.getText().split(": ")[1]);
        JTextField typeField = new JTextField(typeLabel.getText().split(": ")[1]);
        JTextField serviceField = new JTextField(serviceLabel.getText().split(": ")[1]);

        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.add(new JLabel("nom: "));
        panel.add(nomField);
        panel.add(new JLabel("prenom: "));
        panel.add(prenomField);
        panel.add(new JLabel("nss: "));
        panel.add(nssField);
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
            nomLabel.setText("nom: " + nomField.getText());
            prenomLabel.setText("prenom: " + prenomField.getText());
            nssLabel.setText("nss: " + nssField.getText());
            dateLabel.setText("Date: " + dateField.getText());
            typeLabel.setText("Type: " + typeField.getText());
            serviceLabel.setText("Service Demande: " + serviceField.getText());
        }
    }

    public static void main(String[] args) {
        new ReservationDetail("mouloud","hamza","1234", "2023-05-07", "Type A", "Service X, Service Y");
    }
}
