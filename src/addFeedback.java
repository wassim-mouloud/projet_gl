import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class addFeedback extends JFrame {
    public addFeedback() {
    setTitle("Ajouter un feedback");
    setSize(400, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

    JLabel noteServiceLabel = new JLabel("Note attribuée à la qualité de service");
    JTextField noteServiceField = new JTextField();
    panel.add(noteServiceLabel);
    panel.add(noteServiceField);

    JLabel notePonctualiteLabel = new JLabel("Note attribuée à la ponctualité des visites");
    JTextField notePonctualiteField = new JTextField();
    panel.add(notePonctualiteLabel);
    panel.add(notePonctualiteField);

    JLabel idConsultationLabel = new JLabel("Identifiant de la consultation évaluée");
    JTextField idConsultationField = new JTextField();
    panel.add(idConsultationLabel);
    panel.add(idConsultationField);

    JLabel idPatientLabel = new JLabel("Identifiant du patient qui a donné le feedback");
    JTextField idPatientField = new JTextField();
    panel.add(idPatientLabel);
    panel.add(idPatientField);

    // Add the save button
    JButton saveButton = new JButton("Sauvegarder");
    panel.add(saveButton);
    saveButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the values from the input fields
            String noteService = noteServiceField.getText();
            String notePonctualite = notePonctualiteField.getText();
            String idConsultation = idConsultationField.getText();
            String idPatient = idPatientField.getText();

            // Validate the inputs
            if (noteService.isEmpty() || notePonctualite.isEmpty() || idConsultation.isEmpty() || idPatient.isEmpty()) {
                JOptionPane.showMessageDialog(addFeedback.this, "Tous les champs sont requis.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else if (!Pattern.matches("\\d+", noteService) || !Pattern.matches("\\d+", notePonctualite) || !Pattern.matches("\\d+", idConsultation) || !Pattern.matches("\\d+", idPatient)) {
                JOptionPane.showMessageDialog(addFeedback.this, "Les champs doivent être des nombres.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                // Save the data and show a success message
                JOptionPane.showMessageDialog(addFeedback.this, "Feedback sauvegardé avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    });

    add(panel);
    setVisible(true);
}

    public static void main(String[] args) {
        addFeedback addFeedback = new addFeedback();
    }

}
