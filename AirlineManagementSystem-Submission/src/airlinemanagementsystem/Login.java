package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    private final JButton submit = new JButton("Sign in");
    private final JButton reset = new JButton("Reset");
    private final JButton close = new JButton("Exit");
    private final JTextField usernameField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();

    public Login() {
        setTitle("Airline Management System | Sign in");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel title = new JLabel("AIRLINE MANAGEMENT SYSTEM");
        title.setBounds(38, 15, 330, 28);
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setForeground(new Color(18, 67, 125));
        add(title);

        addLabel("Username", 35, 70);
        usernameField.setBounds(135, 68, 210, 26);
        add(usernameField);

        addLabel("Password", 35, 112);
        passwordField.setBounds(135, 110, 210, 26);
        add(passwordField);

        configureButton(reset, 35, 165);
        configureButton(submit, 155, 165);
        configureButton(close, 275, 165);

        getRootPane().setDefaultButton(submit);
        setSize(390, 255);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 90, 24);
        label.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(label);
    }

    private void configureButton(JButton button, int x, int y) {
        button.setBounds(x, y, 100, 30);
        button.addActionListener(this);
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == reset) {
            usernameField.setText("");
            passwordField.setText("");
            usernameField.requestFocusInWindow();
            return;
        }
        if (event.getSource() == close) {
            dispose();
            return;
        }

        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());
        if (username.isBlank() || password.isBlank()) {
            showError("Enter both username and password.");
            return;
        }

        String query = "SELECT 1 FROM login WHERE username = ? AND password = ?";
        try (Conn connection = new Conn();
             PreparedStatement statement = connection.c.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet results = statement.executeQuery()) {
                if (results.next()) {
                    dispose();
                    new Home();
                } else {
                    showError("Invalid username or password.");
                    passwordField.setText("");
                }
            }
        } catch (Exception exception) {
            showError("Unable to connect to the database. Check the setup instructions.");
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Sign-in error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new Login();
    }
}
