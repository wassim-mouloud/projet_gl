import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class addEmployee extends JFrame {

    public addEmployee() {
        setTitle("Ajouter un employé");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        JLabel codeLabel = new JLabel("Code");
        JTextField codeField = new JTextField();
        panel.add(codeLabel);
        panel.add(codeField);

        JLabel nomLabel = new JLabel("Nom");
        JTextField nomField = new JTextField();
        panel.add(nomLabel);
        panel.add(nomField);

        JLabel prenomLabel = new JLabel("Prénom");
        JTextField prenomField = new JTextField();
        panel.add(prenomLabel);
        panel.add(prenomField);

        JLabel secteurLabel = new JLabel("Secteur");
        JTextField secteurField = new JTextField();
        panel.add(secteurLabel);
        panel.add(secteurField);

        JLabel ancienneteLabel = new JLabel("Ancienneté");
        JTextField ancienneteField = new JTextField();
        panel.add(ancienneteLabel);
        panel.add(ancienneteField);

        // Add the save button
        JButton saveButton = new JButton("Sauvegarder");
        panel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the values from the input fields
                String code = codeField.getText();
                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String secteur = secteurField.getText();
                String anciennete = ancienneteField.getText();

                // Validate the inputs
                if (code.isEmpty() || nom.isEmpty() || prenom.isEmpty() || secteur.isEmpty() || anciennete.isEmpty()) {
                    JOptionPane.showMessageDialog(addEmployee.this, "Tous les champs sont requis.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else if (!Pattern.matches("\\d+", code)) {
                    JOptionPane.showMessageDialog(addEmployee.this, "Le code doit être un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else if (!Pattern.matches("[A-Za-z]+", nom) || !Pattern.matches("[A-Za-z]+", prenom)) {
                    JOptionPane.showMessageDialog(addEmployee.this, "Le nom et le prénom doivent contenir uniquement des lettres.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else if (!Pattern.matches("\\d+", anciennete)) {
                    JOptionPane.showMessageDialog(addEmployee.this, "L'ancienneté doit être un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Save the data and show a success message
                    JOptionPane.showMessageDialog(addEmployee.this, "Employé sauvegardé avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        addEmployee addEmployee = new addEmployee();
    }
}
