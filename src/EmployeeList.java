import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeList extends JFrame {

    public EmployeeList() {
        setTitle("Employes list");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a scroll pane for the employee panels
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);

        // Create a panel for the employee panels
        JPanel employeePanel = new JPanel();
        employeePanel.setLayout(new BoxLayout(employeePanel, BoxLayout.Y_AXIS));

        // Add 30 employee panels to the panel
        for (int i = 1; i <= 30; i++) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

            // Add a label with the employee name
            JLabel nameLabel = new JLabel("EmployÃ© " + i);
            panel.add(nameLabel);

            // Add an edit button
            JButton detailButton = new JButton("Detail");
            panel.add(detailButton);
            detailButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Code to display the employee details
                    EmployeeInfo employeeInfoFrame= new EmployeeInfo("3132123","hamza", "bouakder", "genycologie", 2022);
                    employeeInfoFrame.setVisible(true);
                }
            });

            // Add a delete button
            JButton deleteButton = new JButton("Supprimer");
            panel.add(deleteButton);
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Remove the employee panel from the employeePanel panel
                    employeePanel.remove(panel);
                    // Repaint the employeePanel panel
                    employeePanel.revalidate();
                    employeePanel.repaint();
                }
            });

            // Add the panel to the employee panel
            employeePanel.add(panel);
        }

        // Add the employee panel to the scroll pane
        scrollPane.setViewportView(employeePanel);

        // Add the scroll pane to the frame
        add(scrollPane);

        // Display the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        EmployeeList employeeList = new EmployeeList();
    }
}
