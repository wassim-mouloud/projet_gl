import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class addClient extends JFrame {

    public addClient() {
        setTitle("Ajouter un client");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        JLabel nssLabel = new JLabel("NSS");
        JTextField nssField = new JTextField();
        panel.add(nssLabel);
        panel.add(nssField);

        JLabel nomLabel = new JLabel("Nom");
        JTextField nomField = new JTextField();
        panel.add(nomLabel);
        panel.add(nomField);

        JLabel prenomLabel = new JLabel("Prénom");
        JTextField prenomField = new JTextField();
        panel.add(prenomLabel);
        panel.add(prenomField);

        JLabel dateNaissanceLabel = new JLabel("Date de naissance");
        JTextField dateNaissanceField = new JTextField();
        panel.add(dateNaissanceLabel);
        panel.add(dateNaissanceField);

        JLabel adresseLabel = new JLabel("Adresse");
        JTextField adresseField = new JTextField();
        panel.add(adresseLabel);
        panel.add(adresseField);

        JLabel telephoneLabel = new JLabel("Numéro de téléphone");
        JTextField telephoneField = new JTextField();
        panel.add(telephoneLabel);
        panel.add(telephoneField);

        JLabel emailLabel = new JLabel("Adresse email");
        JTextField emailField = new JTextField();
        panel.add(emailLabel);
        panel.add(emailField);

        
       

        // Add the save button
        JButton saveButton = new JButton("Sauvegarder");
        panel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the values from the input fields
                String nss = nssField.getText();
                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String dateNaissance = dateNaissanceField.getText();
                String adresse = adresseField.getText();
                String telephone = telephoneField.getText();
                String email = emailField.getText();
                 // Verify that the NSS field is not empty and has 13 digits
        if (nssField.getText().isEmpty() || !nssField.getText().matches("\\d{13}")) {
            JOptionPane.showMessageDialog(addClient.this, "Le NSS doit avoir 13 chiffres.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Verify that the name field is not empty and contains only letters
        if (nomField.getText().isEmpty() || !nomField.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(addClient.this, "Le nom ne doit contenir que des lettres.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Verify that the first name field is not empty and contains only letters
        if (prenomField.getText().isEmpty() || !prenomField.getText().matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(addClient.this, "Le prénom ne doit contenir que des lettres.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Verify that the address field is not empty
        if (adresseField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(addClient.this, "L'adresse ne peut pas être vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Verify that the phone number field is not empty and contains only digits
        if (telephoneField.getText().isEmpty() || !telephoneField.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(addClient.this, "Le numéro de téléphone ne doit contenir que des chiffres.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Verify that the email field is not empty and is a valid email address
        if (emailField.getText().isEmpty() || !emailField.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            JOptionPane.showMessageDialog(addClient.this, "L'adresse email n'est pas valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Verify that the date of birth field is not empty and is a valid date in the format "dd/mm/yyyy"
        if (dateNaissanceField.getText().isEmpty() || !dateNaissanceField.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(addClient.this, "La date de naissance doit être au format \"jj/mm/aaaa\".", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

      



                // Save the data and show a success message
                JOptionPane.showMessageDialog(addClient.this, "Client sauvegardé avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        addClient addClient = new addClient();
    }
}
