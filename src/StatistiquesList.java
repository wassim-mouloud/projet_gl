import javax.swing.*;
import java.awt.*;

public class StatistiquesList extends JFrame {

    public StatistiquesList() {
        setTitle("Statistiques");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a scroll pane for the client panels
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Create a panel for the client panels
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new BoxLayout(clientPanel, BoxLayout.Y_AXIS));

        // Add 4 stat panels to the panel
        String[] labels = {"Nombre de visites par médecin ou infirmier: ", "Taux de réservations annulées: ", "Nombre de visites par patient: ", "Nombre d'appels par jour: "};
        int[] values = {50, 20, 100, 200};

        for (int i = 0; i < labels.length; i++) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

            // Add a label with the statistic name
            JLabel nameLabel = new JLabel(labels[i]);
            panel.add(nameLabel);

            // Add a label with the statistic value
            JLabel valueLabel = new JLabel(Integer.toString(values[i]));
            panel.add(valueLabel);

            // Add the panel to the client panel
            clientPanel.add(panel);
        }

        // Add the client panel to the scroll pane
        scrollPane.setViewportView(clientPanel);

        // Add the scroll pane to the frame
        add(scrollPane);

        // Display the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        StatistiquesList statsList = new StatistiquesList();
    }
}