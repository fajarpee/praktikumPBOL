import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tugas3 extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    // Login components
    private JTextField loginEmailField;
    private JPasswordField loginPasswordField;
    private JButton loginButton;
    private JButton goToRegisterButton;

    // Register components
    private JTextField registerNameField;
    private JTextField registerEmailField;
    private JPasswordField registerPasswordField;
    private JButton registerButton;
    private JButton goToLoginButton;

    public Tugas3() {
        setTitle("Login and Sign Up");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel loginPanel = createLoginPanel();
        JPanel registerPanel = createRegisterPanel();

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(registerPanel, "Register");

        add(mainPanel);
        cardLayout.show(mainPanel, "Login");

        setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(245, 245, 245));  // Light gray background for consistency
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel loginLabel = new JLabel("LOGIN", SwingConstants.CENTER);
        loginLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        loginLabel.setForeground(new Color(102, 51, 153));  // Consistent color for title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(loginLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(new JLabel("Email:"), gbc);

        loginEmailField = new JTextField(20);
        gbc.gridx = 1;
        loginPanel.add(loginEmailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(new JLabel("Password:"), gbc);

        loginPasswordField = new JPasswordField(20);
        gbc.gridx = 1;
        loginPanel.add(loginPasswordField, gbc);

        loginButton = new JButton("Login");
        styleButton(loginButton);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        loginPanel.add(loginButton, gbc);

        JLabel promptLabel = new JLabel("I don't have an account");
        gbc.gridx = 0; 
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        loginPanel.add(promptLabel, gbc);

        goToRegisterButton = new JButton("Sign Up");
        styleLinkButton(goToRegisterButton);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        loginPanel.add(goToRegisterButton, gbc);

        goToRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Register");
            }
        });

        return loginPanel;
    }

    private JPanel createRegisterPanel() {
        JPanel registerPanel = new JPanel(new GridBagLayout());
        registerPanel.setBackground(new Color(245, 245, 245));  // Same background color as login panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel registerLabel = new JLabel("SIGN UP", SwingConstants.CENTER);
        registerLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        registerLabel.setForeground(new Color(102, 51, 153));  // Consistent color for title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        registerPanel.add(registerLabel, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        registerPanel.add(new JLabel("Full Name:"), gbc);

        registerNameField = new JTextField(20);
        gbc.gridx = 1;
        registerPanel.add(registerNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        registerPanel.add(new JLabel("Email:"), gbc);

        registerEmailField = new JTextField(20);
        gbc.gridx = 1;
        registerPanel.add(registerEmailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        registerPanel.add(new JLabel("Password:"), gbc);

        registerPasswordField = new JPasswordField(20);
        gbc.gridx = 1;
        registerPanel.add(registerPasswordField, gbc);

        registerButton = new JButton("Sign Up");
        styleButton(registerButton);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        registerPanel.add(registerButton, gbc);

        JLabel loginPromptLabel = new JLabel("I have an account");
        gbc.gridx = 0;  
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        registerPanel.add(loginPromptLabel, gbc);

        goToLoginButton = new JButton("Login");
        styleLinkButton(goToLoginButton);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        registerPanel.add(goToLoginButton, gbc);

        goToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Login");
            }
        });

        return registerPanel;
    }

    // Method to style the primary buttons (Login, Sign Up)
    private void styleButton(JButton button) {
        button.setBackground(new Color(102, 51, 153));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
    }

    // Method to style the link buttons (switch between Login and Sign Up)
    private void styleLinkButton(JButton button) {
        button.setBorder(null);
        button.setForeground(new Color(0, 102, 204));
        button.setContentAreaFilled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tugas3();
            }
        });
    }
}
