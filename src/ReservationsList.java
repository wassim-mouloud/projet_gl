import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationsList extends JFrame {
    private JPanel[] panels;
    private JPanel mainPanel;

    public ReservationsList() {
        super("Reservation Frame");

        // Set up the array of panels
        panels = new JPanel[30];

        for (int i = 0; i < 30; i++) {
            // Create a new panel with a border layout
            JPanel panel = new JPanel(new BorderLayout(10, 10));
        
            // Create a label with the reservation name
            JLabel nameLabel = new JLabel("Reservation #" + (i+1));
        
            // Create a button to view the reservation details
            JButton detailButton = new JButton("Details");
            detailButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Code to display the clients list
                    ReservationDetail reservationDetailFrame= new ReservationDetail("hamza","boukader","1234","22/12/2023","consultation", "pediatre");
                    reservationDetailFrame.setVisible(true);
                }
            });
        
            // Add a delete button
            JButton deleteButton = new JButton("Supprimer");
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Remove the reservation panel from the mainPanel
                    mainPanel.remove(panel);
                    // Repaint the mainPanel
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            });
        
            // Add the label, detail button, and delete button to the panel
            panel.add(nameLabel, BorderLayout.WEST);
            panel.add(detailButton, BorderLayout.CENTER);
            panel.add(deleteButton, BorderLayout.EAST);
        
            // Add some padding to the panel
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
            // Add the panel to the array
            panels[i] = panel;
        }
        
        // Create a new panel to hold the reservation panels
        mainPanel = new JPanel(new GridLayout(0, 1, 10, 10));

        // Add each reservation panel to the main panel
        for (JPanel panel : panels) {
            mainPanel.add(panel);
        }

        // Create a scroll pane for the main panel
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);

        // Add the scroll pane to the frame
        add(scrollPane);

        // Set the frame properties
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ReservationsList();
    }
}
