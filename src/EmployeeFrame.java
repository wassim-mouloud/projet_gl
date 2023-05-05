import javax.swing.*;
import java.awt.*;

public class EmployeeFrame extends JFrame {
    private JLabel codeLabel, nomLabel, prenomLabel, secteurLabel, ancienneteLabel;

    public EmployeeFrame(String code, String nom, String prenom, String secteur, int anciennete) {
        super("Employee Information");

        // Create labels for each data field
        codeLabel = new JLabel("Code: " + code);
        nomLabel = new JLabel("Nom: " + nom);
        prenomLabel = new JLabel("Prénom: " + prenom);
        secteurLabel = new JLabel("Secteur: " + secteur);
        ancienneteLabel = new JLabel("Ancienneté: " + anciennete + " years");

        // Add the labels to the frame
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        panel.add(codeLabel);
        panel.add(nomLabel);
        panel.add(prenomLabel);
        panel.add(secteurLabel);
        panel.add(ancienneteLabel);
        add(panel);

        // Set the frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
}
