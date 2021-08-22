package za.ac.cput.PRT362s_Project_2021;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {
    private JPanel panelSouth;
    private JPanel panelCenter;
    private JPanel  panelNorth;

    private JLabel lblHeader;
    private JLabel lblEmployeeID;
    private JTextField txtEmployeeID;
    private JLabel lblFirstName;
    private  JTextField txtFirstName;
    private JLabel lblLastName;
    private JTextField txtLastName;
    private  JLabel lblPhoneNumber;
    private JTextField txtPhoneNumber;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblAddress;
    private JTextField txtAddress;
    private JButton btnUpdate,btnCancel;
    private Font font1,font2;

    public UpdateEmployee(){
        super("Employee Management System");

        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth = new JPanel();

        lblHeader = new JLabel("Update employee" );

        lblEmployeeID = new JLabel("Employee ID: ",SwingConstants.RIGHT);
        txtEmployeeID = new JTextField();

        lblFirstName = new JLabel("First Name: ",SwingConstants.RIGHT);
        txtFirstName = new JTextField();

        lblLastName = new JLabel("Last Name: ",SwingConstants.RIGHT);
        txtLastName = new JTextField();

        lblPhoneNumber = new JLabel("Phone Number: ",SwingConstants.RIGHT);
        txtPhoneNumber = new JTextField();

        lblEmail = new JLabel("Email: ",SwingConstants.RIGHT);
        txtEmail = new JTextField();

        lblAddress = new JLabel("Address: ",SwingConstants.RIGHT);
        txtAddress = new JTextField();

        btnUpdate = new JButton("Update");
        btnCancel = new JButton("Cancel");

        font1 = new Font("Ariel",Font.PLAIN,20);
        font2 = new Font("Ariel",Font.PLAIN,15);
    }

    public void setGUI(){
        panelCenter.setLayout(new GridLayout(4,2));
        panelSouth.setLayout(new GridLayout(1,2));

        lblHeader.setFont(font1);
        panelNorth.add(lblHeader);


        lblEmployeeID.setFont(font2);
        txtEmployeeID.setFont(font2);
        panelCenter.add(lblEmployeeID);
        panelCenter.add(txtEmployeeID);

        lblPhoneNumber.setFont(font2);
        txtPhoneNumber.setFont(font2);
        panelCenter.add(lblPhoneNumber);
        panelCenter.add(txtPhoneNumber);

        lblEmail.setFont(font2);
        txtEmail.setFont(font2);
        panelCenter.add(lblEmail);
        panelCenter.add(txtEmail);

        lblAddress.setFont(font2);
        txtAddress.setFont(font2);
        panelCenter.add(lblAddress);
        panelCenter.add(txtAddress);

        btnUpdate.setFont(font2);
        panelSouth.add(btnUpdate);
        btnCancel.setFont(font2);
        panelSouth.add(btnCancel);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth,BorderLayout.SOUTH);

        btnUpdate.addActionListener(this);
        btnCancel.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("Update")){

            String emp_id = txtEmployeeID.getText();
                String firstName = txtFirstName.getText();
                String lastName = txtLastName.getText();
                String phoneNumber = txtPhoneNumber.getText();
                String email = txtEmail.getText();
                String address = txtAddress.getText();
            String url = "jdbc:mysql://localhost:3306/employeedb";
            String user = "root";
            String password = "root";
                Connection connection = null;
                Statement statement = null;
                int emp_Id;
            try {
                connection = DriverManager.getConnection(url,user,password);
                String  query = "UPDATE employee SET phone = ?, email = ?, address = ? WHERE emp_id = "+emp_id;
                PreparedStatement psr = connection.prepareStatement(query);


                psr.setString(1, txtPhoneNumber.getText());
                psr.setString(2, txtEmail.getText());
                psr.setString(3, txtAddress.getText());
                psr.executeUpdate();
                JOptionPane.showMessageDialog(null,"Employee details Is Successfully Updated");
                txtEmployeeID.setText("");
                txtPhoneNumber.setText("");
                txtEmail.setText("");
                txtAddress.setText("");
                txtEmployeeID.requestFocus();

            }
            catch(SQLException sqlException) {
                JOptionPane.showMessageDialog(null, "Error: " + sqlException);
            }
















        }else{
            if (e.getActionCommand().equals("Cancel")){
                System.exit(0);
            }
        }
    }
    public static void main(String[] args) {

        new UpdateEmployee().setGUI();
    }
}
