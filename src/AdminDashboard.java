import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends JFrame {

    private JButton employeesButton, reservationsButton, clientsButton;

    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the buttons
        employeesButton = new JButton("Employees List");
        employeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to display the employees list
                JOptionPane.showMessageDialog(null, "Employees List");
            }
        });

        reservationsButton = new JButton("Reservations List");
        reservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to display the reservations list
                JOptionPane.showMessageDialog(null, "Reservations List");
            }
        });

        clientsButton = new JButton("Clients List");
        clientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to display the clients list
                ClientList clientsFrame= new ClientList();
                clientsFrame.setVisible(true);
            }
        });

        // Initialize the JPanel and add the components
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Add padding
        panel.add(employeesButton);
        panel.add(reservationsButton);
        panel.add(clientsButton);

        // Add the panel to the JFrame
        add(panel);

        // Display the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        AdminDashboard dashboard = new AdminDashboard();
    }
}
