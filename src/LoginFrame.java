import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class LoginFrame extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton;

    public LoginFrame() {
        super("Login");

        // Set up the text fields for email and password input
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);

        // Set up the button to perform the login action
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                // Perform regular expression check on the email
                if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email)) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid email address");
                    return;
                }
                // Perform login action using email and password
                // For this example, we will just display a message indicating that the login was successful
                JOptionPane.showMessageDialog(LoginFrame.this, "Login successful!");

                // Open the EmployeeFrame
                AdminDashboard adminDashboardFrame = new AdminDashboard();
                adminDashboardFrame.setVisible(true);
                dispose(); // Close the LoginFrame
            }
        });

        // Set up the button to open the SignupFrame
        signupButton = new JButton("Sign Up");
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LoginFrame.this, "SignUp successful!");

            }
        });

        // Add the components to the frame
        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Add padding
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signupButton);
        add(panel);

        // Set the frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
