import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedbackList extends JFrame {

    public FeedbackList() {
        setTitle("Liste des Feedbacks");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a scroll pane for the feedback panels
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);


        // Create a panel for the feedback panels
        JPanel feedbackPanel = new JPanel();
        feedbackPanel.setLayout(new BoxLayout(feedbackPanel, BoxLayout.Y_AXIS));

        // Add 30 feedback panels to the panel
        for (int i = 1; i <= 30; i++) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

            // Add a label with the feedback ID
            JLabel feedbackIdLabel = new JLabel("Feedback " + i);
            panel.add(feedbackIdLabel);

            // Add a detail button
            JButton detailButton = new JButton("Détails");
            panel.add(detailButton);
            detailButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Code to display the feedback details
                    FeedbackInfo feedbackInfoFrame= new FeedbackInfo("1001", 4, 3, "12345", "98765");
                    feedbackInfoFrame.setVisible(true);
                }
            });
            // Add a delete button
            JButton deleteButton = new JButton("Supprimer");
            panel.add(deleteButton);
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Remove the client panel from the clientPanel panel
                    feedbackPanel.remove(panel);
                    // Repaint the clientPanel panel
                    feedbackPanel.revalidate();
                    feedbackPanel.repaint();
                }
            });

            // Add the panel to the feedback panel
            feedbackPanel.add(panel);
        }

        // Add the feedback panel to the scroll pane
        scrollPane.setViewportView(feedbackPanel);

        // Add the scroll pane to the frame
        add(scrollPane);

        // Display the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        FeedbackList feedbackList = new FeedbackList();
    }
}

class FeedbackInfo extends JFrame {

    public FeedbackInfo(String feedbackId, int qualityRating, int punctualityRating, String consultationId, String patientId) {
        setTitle("Détails du Feedback");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a panel for the feedback info
        JPanel feedbackPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        feedbackPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        // Add a label with the feedback ID
        JLabel feedbackIdLabel = new JLabel("Identifiant du Feedback: ");
        JLabel feedbackIdField = new JLabel(feedbackId);
        feedbackPanel.add(feedbackIdLabel);
        feedbackPanel.add(feedbackIdField);

        // Add a label with the quality rating
        JLabel qualityRatingLabel = new JLabel("Note de qualité de service: ");
        JLabel qualityRatingField = new JLabel(Integer.toString(qualityRating));
        feedbackPanel.add(qualityRatingLabel);
        feedbackPanel.add(qualityRatingField);

        // Add a label with the punctuality rating
        JLabel punctualityRatingLabel = new JLabel("Note de ponctualité des visites: ");
        JLabel punctualityRatingField = new JLabel(Integer.toString(punctualityRating));
        feedbackPanel.add(punctualityRatingLabel);
        feedbackPanel.add(punctualityRatingField);

        // Add a label with the consultation ID
        JLabel consultationIdLabel = new JLabel("Identifiant de la consultation évaluée: ");
        JLabel consultationIdField = new JLabel(consultationId);
        feedbackPanel.add(consultationIdLabel);
        feedbackPanel.add(consultationIdField);

        // Add a label with the patient ID
        JLabel patientIdLabel = new JLabel("Identifiant du patient qui a donné le feedback: ");
        JLabel patientIdField = new JLabel(patientId);
        feedbackPanel.add(patientIdLabel);
        feedbackPanel.add(patientIdField);

        // Add the feedback panel to the frame
        add(feedbackPanel);

        // Display the JFrame
        setVisible(true);
    }
}