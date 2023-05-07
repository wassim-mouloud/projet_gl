import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ClientList extends JFrame {

    public ClientList() {
        setTitle("Client List");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a scroll pane for the client panels
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Create a panel for the client panels
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new BoxLayout(clientPanel, BoxLayout.Y_AXIS));

        // Add 30 client panels to the panel
        // Add 30 client panels to the panel
for (int i = 1; i <= 30; i++) {
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 10));
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

    // Add a label with the client name
    JLabel nameLabel = new JLabel("Client " + i);
    panel.add(nameLabel, BorderLayout.WEST);

    // Add an edit button
    JButton detailButton = new JButton("Detail");
    panel.add(detailButton);
    detailButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Code to display the clients list
            ClientInfo clientInfoFrame= new ClientInfo("3132123","hamza", "bouakder", "21/03/2003","sidiab","472342984","hmz@gmail.com");
            clientInfoFrame.setVisible(true);
        }
    });

    // Add a delete button
    JButton deleteButton = new JButton("Supprimer");
    panel.add(deleteButton);
    deleteButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Remove the client panel from the clientPanel panel
            clientPanel.remove(panel);
            // Repaint the clientPanel panel
            clientPanel.revalidate();
            clientPanel.repaint();
        }
    });

    // Add the panel to the client panel
    clientPanel.add(panel, BorderLayout.EAST);
}

        // Add the client panel to the scroll pane
        scrollPane.setViewportView(clientPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);

        // Add the scroll pane to the frame
        add(scrollPane);

        // Display the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        ClientList clientList = new ClientList();
    }
}
