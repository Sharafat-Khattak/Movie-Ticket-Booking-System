import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public Main() {
        // Set frame properties
        setTitle("Sign Up");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Allow absolute positioning

        // Create a custom JPanel for the gradient background
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Create the gradient from black to blue
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = Color.BLACK;
                Color color2 = Color.BLUE;
                GradientPaint gradient = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight()); // Fill the entire panel with the gradient
            }
        };
        panel.setLayout(null); // Set the layout for absolute positioning
        panel.setBounds(0, 0, 650, 450);

        // Add a container JPanel for components (to be added on top of the background)
        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false); // Make the panel transparent
        contentPanel.setLayout(null); // Absolute positioning
        contentPanel.setBounds(0, 0, 650, 450);

        // Add title
        JLabel title = new JLabel("Sign Up");
        title.setFont(new Font("Serif", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setBounds(260, 20, 150, 40);
        contentPanel.add(title);

        // Add form fields
        JLabel usernameLabel = new JLabel("User Name:");
        usernameLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(150, 80, 100, 30);
        contentPanel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(260, 80, 200, 30);
        contentPanel.add(usernameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(150, 130, 100, 30);
        contentPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(260, 130, 200, 30);
        contentPanel.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(150, 180, 100, 30);
        contentPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(260, 180, 200, 30);
        contentPanel.add(passwordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        confirmPasswordLabel.setForeground(Color.WHITE);
        confirmPasswordLabel.setBounds(120, 230, 130, 30);
        contentPanel.add(confirmPasswordLabel);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(260, 230, 200, 30);
        contentPanel.add(confirmPasswordField);

        // Add buttons
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(200, 300, 100, 30);
        contentPanel.add(signUpButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(350, 300, 100, 30);
        contentPanel.add(cancelButton);

        // Add action listeners
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Sign-Up Successful!");
                    // Add logic to save user details
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the signup window
            }
        });

        // Add content panel on top of the gradient background
        panel.add(contentPanel);

        // Add the panel to the frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
