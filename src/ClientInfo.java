import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientInfo extends JFrame {

    private JLabel nssLabel, nomLabel, prenomLabel, dobLabel, adresseLabel, telephoneLabel, emailLabel;
    private JLabel nssField, nomField, prenomField, dobField, adresseField, telephoneField, emailField;
    private JButton editButton;

    public ClientInfo(String nss, String nom, String prenom, String dob, String adresse, String telephone, String email) {

        setTitle("Client Info");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize the labels
        nssLabel = new JLabel("NSS: ");
        nomLabel = new JLabel("Nom: ");
        prenomLabel = new JLabel("Prenom: ");
        dobLabel = new JLabel("Date de naissance: ");
        adresseLabel = new JLabel("Adresse: ");
        telephoneLabel = new JLabel("Telephone: ");
        emailLabel = new JLabel("Email: ");

        // Initialize the fields
        nssField = new JLabel(nss);
        nomField = new JLabel(nom);
        prenomField = new JLabel(prenom);
        dobField = new JLabel(dob);
        adresseField = new JLabel(adresse);
        telephoneField = new JLabel(telephone);
        emailField = new JLabel(email);

        // Initialize the edit button
        editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a JOptionPane that asks the user which field they would like to edit
                String[] fields = {"NSS", "Nom", "Prenom", "Date de naissance", "Adresse", "Telephone", "Email"};
                String selectedField = (String) JOptionPane.showInputDialog(null, "Select a field to edit:", "Edit", JOptionPane.PLAIN_MESSAGE, null, fields, fields[0]);

                // Display another JOptionPane that prompts the user to enter the new value for the selected field
                String newValue = JOptionPane.showInputDialog(null, "Enter the new value for " + selectedField + ":", "Edit", JOptionPane.PLAIN_MESSAGE);

                // Update the appropriate JLabel field with the new value entered by the user
                switch (selectedField) {
                    case "NSS":
                        nssField.setText(newValue);
                        break;
                    case "Nom":
                        nomField.setText(newValue);
                        break;
                    case "Prenom":
                        prenomField.setText(newValue);
                        break;
                    case "Date de naissance":
                        dobField.setText(newValue);
                        break;
                    case "Adresse":
                        adresseField.setText(newValue);
                        break;
                    case "Telephone":
                        telephoneField.setText(newValue);
                        break;
                    case "Email":
                        emailField.setText(newValue);
                        break;
                    default:
                        break;
                }
            }
        });

      
       

        // Initialize the JPanel and add the components
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding        
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
        panel.add(editButton);
        // Add the panel to the JFrame
        add(panel);

        // Display the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        // Example usage
        String nss = "123456789";
        String nom = "Doe";
        String prenom = "John";
        String dob = "01/01/1980";
        String adresse = "123 Main St";
        String telephone = "555-1234";
        String email = "johndoe@example.com";

        ClientInfo clientInfo = new ClientInfo(nss, nom, prenom, dob, adresse, telephone, email);
    }
}
