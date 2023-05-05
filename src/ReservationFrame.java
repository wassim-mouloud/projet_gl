import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class ReservationFrame extends JFrame {

    private JLabel numeroLabel, dateLabel, typeLabel, serviceDemandeLabel;
    private JTextField numeroField, dateField, typeField, serviceDemandeField;
    private JButton submitButton;

    public ReservationFrame() {
        setTitle("Form Example");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the labels
        numeroLabel = new JLabel("Numero:");
        dateLabel = new JLabel("Date (dd/mm/yyyy):");
        typeLabel = new JLabel("Type:");
        serviceDemandeLabel = new JLabel("Service demande:");

        // Initialize the fields
        numeroField = new JTextField(20);
        dateField = new JTextField(20);
        typeField = new JTextField(20);
        serviceDemandeField = new JTextField(20);

        // Initialize the submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the values entered by the user
                String numero = numeroField.getText();
                String date = dateField.getText();
                String type = typeField.getText();
                String serviceDemande = serviceDemandeField.getText();

                // Validate the date using a regex
                boolean isValidDate = Pattern.matches("(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/\\d{4}", date);


                // Display a message dialog indicating whether the form was submitted or not
                if (isValidDate) {
                    JOptionPane.showMessageDialog(null, "Form submitted:\nNumero: " + numero + "\nDate: " + date + "\nType: " + type + "\nService demande: " + serviceDemande, "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid date format. Please enter the date in the format dd/mm/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Initialize the JPanel and add the components
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding        
        panel.add(numeroLabel);
        panel.add(numeroField);
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(typeLabel);
        panel.add(typeField);
        panel.add(serviceDemandeLabel);
        panel.add(serviceDemandeField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(submitButton);

        // Add the panel to the JFrame
        add(panel);

        // Display the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        ReservationFrame form = new ReservationFrame();
    }
}
