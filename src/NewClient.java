import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.regex.Pattern;

public class NewClient extends JFrame {
    private JTextField nssField, nomField, prenomField, dobField, adresseField, telephoneField, emailField;
    private JLabel nssLabel, nomLabel, prenomLabel, dobLabel, adresseLabel, telephoneLabel, emailLabel;
    private JButton submitButton;

    public NewClient() {
        // Initialize the JFrame
        setTitle("Input Form");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize the input fields
        nssField = new JTextField(10);
        nomField = new JTextField(10);
        prenomField = new JTextField(10);
        dobField = new JTextField(10);
        adresseField = new JTextField(10);
        telephoneField = new JTextField(10);
        emailField = new JTextField(10);

        // Initialize the labels
        nssLabel = new JLabel("NSS: ");
        nomLabel = new JLabel("Nom: ");
        prenomLabel = new JLabel("Prenom: ");
        dobLabel = new JLabel("Date de naissance: ");
        adresseLabel = new JLabel("Adresse: ");
        telephoneLabel = new JLabel("Telephone: ");
        emailLabel = new JLabel("Email: ");

        // Initialize the submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input values
                String nss = nssField.getText();
                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String dob = dobField.getText();
                String adresse = adresseField.getText();
                String telephone = telephoneField.getText();
                String email = emailField.getText();

                // Perform email validation using regex
                String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
                Pattern emailPattern = Pattern.compile(emailRegex);
                boolean isEmailValid = emailPattern.matcher(email).matches();

                // Perform date validation using regex
                String dateRegex = "^\\d{2}/\\d{2}/\\d{4}$";
                Pattern datePattern = Pattern.compile(dateRegex);
                boolean isDateValid = datePattern.matcher(dob).matches();

                // Display the validation result
                if (isEmailValid && isDateValid) {
                    JOptionPane.showMessageDialog(null, "All fields are valid.");
                } else {
                    String errorMessage = "";
                    if (!isEmailValid) {
                        errorMessage += "Email is not valid.\n";
                    }
                    if (!isDateValid) {
                        errorMessage += "Date of birth is not in the correct format (dd/mm/yyyy).\n";
                    }
                    JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Initialize the JPanel and add the components
        JPanel panel = new JPanel(new GridLayout(8, 2));
        panel.add(nssLabel);
        panel.add(nssField);
        panel.add(nomLabel);
        panel.add(nomField);
        panel.add(prenomLabel);
        panel.add(prenomField);
        panel.add(dobLabel);
        panel.add(dobField);
        panel.add(adresseLabel);
        panel.add(adresseField);
        panel.add(telephoneLabel);
        panel.add(telephoneField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(new JLabel(""));
        panel.add(submitButton);
        add(panel);
        
        setVisible(true);

    }
}