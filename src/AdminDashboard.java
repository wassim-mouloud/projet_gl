import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends JFrame {

    private JButton addButton, employeesButton, reservationsButton, clientsButton, statsButton, feedbackButton, consultationsButton;
    private JPopupMenu addPopupMenu;

    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize the buttons
        addButton = new JButton("Ajouter");
        addPopupMenu = new JPopupMenu();
        JMenuItem clientMenuItem = new JMenuItem("Client");
        clientMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClient newClient= new addClient();
                newClient.setVisible(true);
            }
        });
        addPopupMenu.add(clientMenuItem);
        JMenuItem employeeMenuItem = new JMenuItem("Employee");
        employeeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee newEmployee= new addEmployee();
                newEmployee.setVisible(true);
            }
        });
        addPopupMenu.add(employeeMenuItem);
        JMenuItem reservationMenuItem = new JMenuItem("Reservation");
        reservationMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addReservation newreservation= new addReservation();
                newreservation.setVisible(true);
            }
        });
        addPopupMenu.add(reservationMenuItem);
        JMenuItem statisticsMenuItem = new JMenuItem("Statistics");
        statisticsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStatistiques newstatistics= new addStatistiques();
                newstatistics.setVisible(true);
            }
        });
        addPopupMenu.add(statisticsMenuItem);
        JMenuItem feedbackMenuItem = new JMenuItem("Feedback");
        feedbackMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFeedback newfeedback= new addFeedback();
                newfeedback.setVisible(true);
            }
        });
        addPopupMenu.add(feedbackMenuItem);
        JMenuItem consultationMenuItem = new JMenuItem("Consultation");
        consultationMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addConsultation newconsultation= new addConsultation();
                newconsultation.setVisible(true);
            }
        });
        addPopupMenu.add(consultationMenuItem);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPopupMenu.show(addButton, 0, addButton.getHeight());
            }
        });

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

        statsButton= new JButton("Statistics");
        statsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to display the statistics list
                StatistiquesList statsFrame= new StatistiquesList();
                statsFrame.setVisible(true);
            }
        });

        feedbackButton= new JButton("Feedback");
        feedbackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to display the feedback list
                FeedbackList feedbackFrame= new FeedbackList();
                feedbackFrame.setVisible(true);
            }
        });

        consultationsButton= new JButton("Consultations");
        consultationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to display the consultations list
                consultationList consultationFrame= new consultationList();
                consultationFrame.setVisible(true);
            }
        });

        // Initialize the JPanel and add the components
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Add padding
        panel.add(addButton);
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