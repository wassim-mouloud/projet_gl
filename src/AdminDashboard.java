import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends JFrame {

    private JButton employeesButton, reservationsButton, clientsButton, statsButton, feedbackButton, consultationsButton;

    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize the buttons
        employeesButton = new JButton("Employees List");
        employeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to display the employees list
                EmployeeList employeesFrame= new EmployeeList();
                employeesFrame.setVisible(true);
            }
        });

        reservationsButton = new JButton("Reservations List");
        reservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to display the reservations list
                ReservationsList reservationsFrame=new ReservationsList();
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

        statsButton= new JButton("Statistiques");
        statsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to display the clients list
                StatistiquesList statsFrame= new StatistiquesList();
                statsFrame.setVisible(true);
            }
        });

        feedbackButton= new JButton("Feedback");
        feedbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to display the clients list
                FeedbackList statsFrame= new FeedbackList();
                statsFrame.setVisible(true);
            }
        });

        consultationsButton= new JButton("Consultations");
        consultationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to display the clients list
                consultationList statsFrame= new consultationList();
                statsFrame.setVisible(true);
            }
        });

        // Initialize the JPanel and add the components
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Add padding
        panel.add(employeesButton);
        panel.add(reservationsButton);
        panel.add(clientsButton);
        panel.add(statsButton);
        panel.add(feedbackButton);
        panel.add(consultationsButton);
        // Add the panel to the JFrame
        add(panel);

        // Display the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        AdminDashboard dashboard = new AdminDashboard();
    }
}
