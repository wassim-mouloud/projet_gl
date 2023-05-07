import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeInfo extends JFrame {
    private JLabel codeLabel, nomLabel, prenomLabel, secteurLabel, ancienneteLabel;
    private JButton editButton;

    public EmployeeInfo(String code, String nom, String prenom, String secteur, int anciennete) {
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

        // Create the Edit button
        editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a JOptionPane that asks the user which field they would like to edit
                String[] fields = {"Nom", "Prénom", "Secteur", "Ancienneté"};
                String selectedField = (String) JOptionPane.showInputDialog(null, "Select a field to edit:", "Edit", JOptionPane.PLAIN_MESSAGE, null, fields, fields[0]);

                // Display another JOptionPane that prompts the user to enter the new value for the selected field
                String newValue = JOptionPane.showInputDialog(null, "Enter the new value for " + selectedField + ":", "Edit", JOptionPane.PLAIN_MESSAGE);

                // Update the appropriate JLabel field with the new value entered by the user
                switch (selectedField) {
                    case "Nom":
                        nomLabel.setText("Nom: " + newValue);
                        break;
                    case "Prénom":
                        prenomLabel.setText("Prénom: " + newValue);
                        break;
                    case "Secteur":
                        secteurLabel.setText("Secteur: " + newValue);
                        break;
                    case "Ancienneté":
                        ancienneteLabel.setText("Ancienneté: " + newValue + " years");
                        break;
                    default:
                        break;
                }
            }
        });
        panel.add(editButton);

        // Set the frame properties
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
