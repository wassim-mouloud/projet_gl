import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class addStatistiques extends JFrame {
public addStatistiques() {
    setTitle("Ajouter des données");
    setSize(550, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

    JLabel visitsLabel = new JLabel("Nombre de visites par médecin ou infirmier");
    JTextField visitsField = new JTextField();
    panel.add(visitsLabel);
    panel.add(visitsField);

    JLabel cancellationLabel = new JLabel("Taux de réservations annulées");
    JTextField cancellationField = new JTextField();
    panel.add(cancellationLabel);
    panel.add(cancellationField);

    JLabel patientVisitsLabel = new JLabel("Nombre de visites par patient");
    JTextField patientVisitsField = new JTextField();
    panel.add(patientVisitsLabel);
    panel.add(patientVisitsField);

    JLabel callsLabel = new JLabel("Nombre d'appels par jour");
    JTextField callsField = new JTextField();
    panel.add(callsLabel);
    panel.add(callsField);

    // Add the save button
    JButton saveButton = new JButton("Sauvegarder");
    panel.add(saveButton);
    saveButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the values from the input fields
            String visits = visitsField.getText();
            String cancellation = cancellationField.getText();
            String patientVisits = patientVisitsField.getText();
            String calls = callsField.getText();

            // Verify that the input fields are not empty
            if (visits.isEmpty() || cancellation.isEmpty() || patientVisits.isEmpty() || calls.isEmpty()) {
                JOptionPane.showMessageDialog(addStatistiques.this, "Tous les champs sont obligatoires.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verify that the input values are valid
            try {
                int visitsValue = Integer.parseInt(visits);
                double cancellationValue = Double.parseDouble(cancellation);
                int patientVisitsValue = Integer.parseInt(patientVisits);
                int callsValue = Integer.parseInt(calls);

                if (visitsValue < 0 || patientVisitsValue < 0 || callsValue < 0 || cancellationValue < 0 || cancellationValue > 100) {
                    JOptionPane.showMessageDialog(addStatistiques.this, "Les valeurs saisies ne sont pas valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(addStatistiques.this, "Les valeurs saisies ne sont pas valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Save the data and show a success message
            JOptionPane.showMessageDialog(addStatistiques.this, "Données sauvegardées avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
        }
    });

    add(panel);
    setVisible(true);
}

public static void main(String[] args) {
    addStatistiques addStatistiques = new addStatistiques();
}
}