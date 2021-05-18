package za.ac.cput.PRT362s_Project_2021;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginRegistrationForm extends JFrame{

    private JPanel mainPanel;
    private JButton cancelButton;
    private JButton exitButton;
    private JButton submitButton;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldUsername;
    private JPasswordField passwordFieldPassword;
    private JPasswordField passwordFieldConfirmPassword;
    private JLabel labelRegistrationForm;
    private JLabel labelFirstName;
    private JLabel labelLastName;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JLabel labelConfirmPassword;
    private JPanel headerPanel;
    private JPanel fieldPanel;
    private JPanel buttonPanel;

    public LoginRegistrationForm() {

        super("Restaurant Management System");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textFieldFirstName.setText("");
                textFieldLastName.setText("");
                textFieldUsername.setText("");
                passwordFieldPassword.setText("");
                passwordFieldConfirmPassword.setText("");

            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Login login = new Login();
                login.show();
                dispose();

            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Dashboard dashboard = new Dashboard();
                dashboard.show();
                dispose();

            }
        });
    }
}
