import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class addConsultation extends JFrame {

    public addConsultation() {
        setTitle("Ajouter une consultation");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        JLabel idLabel = new JLabel("Identifiant");
        JTextField idField = new JTextField();
        panel.add(idLabel);
        panel.add(idField);

        JLabel dateLabel = new JLabel("Date");
        JTextField dateField = new JTextField();
        panel.add(dateLabel);
        panel.add(dateField);

        JLabel resultatLabel = new JLabel("Résultat");
        JTextField resultatField = new JTextField();
        panel.add(resultatLabel);
        panel.add(resultatField);

        JLabel employeLabel = new JLabel("ID employé");
        JTextField employeField = new JTextField();
        panel.add(employeLabel);
        panel.add(employeField);

        JLabel patientLabel = new JLabel("ID patient");
        JTextField patientField = new JTextField();
        panel.add(patientLabel);
        panel.add(patientField);

        // Add the save button
        JButton saveButton = new JButton("Sauvegarder");
        panel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the values from the input fields
                String id = idField.getText();
                String date = dateField.getText();
                String resultat = resultatField.getText();
                String employe = employeField.getText();
                String patient = patientField.getText();

                // Validate the inputs
                if (id.isEmpty() || date.isEmpty() || resultat.isEmpty() || employe.isEmpty() || patient.isEmpty()) {
                    JOptionPane.showMessageDialog(addConsultation.this, "Tous les champs sont requis.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else if (!Pattern.matches("\\d+", id)) {
                    JOptionPane.showMessageDialog(addConsultation.this, "L'identifiant doit être un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else if (!Pattern.matches("\\d+", employe)) {
                    JOptionPane.showMessageDialog(addConsultation.this, "L'ID employé doit être un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else if (!Pattern.matches("\\d+", patient)) {
                    JOptionPane.showMessageDialog(addConsultation.this, "L'ID patient doit être un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Save the data and show a success message
                    JOptionPane.showMessageDialog(addConsultation.this, "Consultation sauvegardée avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        addConsultation addConsultation = new addConsultation();
    }
}