package za.ac.cput.PRT362s_Project_2021;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private JTextField textFieldUsername;
    private JPasswordField passwordFieldPassword;
    private JButton loginButton;
    private JButton cancelButton;
    private JButton exitButton;
    private JButton registerButton;
    private JPanel headerPanel;
    private JPanel fieldPanel;
    private JPanel buttonPanel;
    private JLabel labelWelcome;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JLabel labelExistingMember;
    private JLabel labelNewMember;
    private JPanel logoPanel;
    private JPanel mainPanel;

    public Login() {

        super("Login");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dashboard dashboard = new Dashboard();
                dashboard.show();
                dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldUsername.setText("");
                passwordFieldPassword.setText("");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginRegForm loginRegForm = new LoginRegForm();
                loginRegForm.show();
                dispose();
            }
        });
    }
}
