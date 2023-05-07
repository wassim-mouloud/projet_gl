import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class consultationList extends JFrame {
    public consultationList() {
    setTitle("Liste des Consultations");
    setSize(600, 800);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a scroll pane for the consultation panels
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    // Create a panel for the consultation panels
    JPanel consultationPanel = new JPanel();
    consultationPanel.setLayout(new BoxLayout(consultationPanel, BoxLayout.Y_AXIS));

    // Add 30 consultation panels to the panel
    for (int i = 1; i <= 30; i++) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        // Add a label with the consultation ID
        JLabel consultationIdLabel = new JLabel("Consultation " + i);
        panel.add(consultationIdLabel);

        // Add a detail button
        JButton detailButton = new JButton("Détails");
        panel.add(detailButton);
        detailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to display the consultation details
                ConsultationInfo consultationInfoFrame= new ConsultationInfo("1234", "2023-05-07", "Le patient est en bonne santé", "4567", "7890");
                consultationInfoFrame.setVisible(true);
            }
        });
        // Add a delete button
        JButton deleteButton = new JButton("Supprimer");
        panel.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove the client panel from the clientPanel panel
                consultationPanel.remove(panel);
                // Repaint the consultationPanel panel
                consultationPanel.revalidate();
                consultationPanel.repaint();
            }
        });

        // Add the panel to the consultation panel
        consultationPanel.add(panel);
    }

    // Add the consultation panel to the scroll pane
    scrollPane.setViewportView(consultationPanel);

    // Add the scroll pane to the frame
    add(scrollPane);

    // Display the JFrame
    setVisible(true);
}
    

    public static void main(String[] args) {
        consultationList consultationList = new consultationList();
    }

    public class ConsultationInfo extends JFrame {

        public ConsultationInfo(String consultationId, String date, String result, String employeeId, String patientId) {
            setTitle("Détails de la consultation");
            setSize(400, 300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Create a panel for the consultation info
            JPanel consultationPanel = new JPanel(new GridLayout(0, 2, 10, 10));
            consultationPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

            // Add a label with the consultation ID
            JLabel consultationIdLabel = new JLabel("Identifiant de la consultation: ");
            JLabel consultationIdField = new JLabel(consultationId);
            consultationPanel.add(consultationIdLabel);
            consultationPanel.add(consultationIdField);

            // Add a label with the date
            JLabel dateLabel = new JLabel("Date de la consultation: ");
            JLabel dateField = new JLabel(date);
            consultationPanel.add(dateLabel);
            consultationPanel.add(dateField);

            // Add a label with the result
            JLabel resultLabel = new JLabel("Résultat de la visite: ");
            JLabel resultField = new JLabel(result);
            consultationPanel.add(resultLabel);
            consultationPanel.add(resultField);

            // Add a label with the employee ID
            JLabel employeeIdLabel = new JLabel("Identifiant de l'employé qui a assuré la consultation: ");
            JLabel employeeIdField = new JLabel(employeeId);
            consultationPanel.add(employeeIdLabel);
            consultationPanel.add(employeeIdField);

            // Add a label with the patient ID
            JLabel patientIdLabel = new JLabel("Identifiant du patient qui a bénéficié de la consultation: ");
            JLabel patientIdField = new JLabel(patientId);
            consultationPanel.add(patientIdLabel);
            consultationPanel.add(patientIdField);

            // Add the consultation panel to the frame
            add(consultationPanel);

            // Display the JFrame
            setVisible(true);
        }
    }
}