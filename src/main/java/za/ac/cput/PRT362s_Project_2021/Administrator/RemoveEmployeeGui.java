package za.ac.cput.PRT362s_Project_2021.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RemoveEmployeeGui extends JFrame implements ActionListener {
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
    private JLabel lblDateOfBirth;
    private JTextField txtDateOfBirth;
    private JLabel lblAddress;
    private JTextField txtAddress;
    private JButton btnDelete,btnSearch,btnCancel;
    private Font font1,font2;

    public RemoveEmployeeGui(){
        super("Employee Management System");

        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth = new JPanel();

        lblHeader = new JLabel("Delete employee");

        lblEmployeeID = new JLabel("Employee ID: ",SwingConstants.RIGHT);
        txtEmployeeID = new JTextField();

        lblFirstName = new JLabel("First Name: ",SwingConstants.RIGHT);
        txtFirstName = new JTextField();


        lblDateOfBirth = new JLabel("Date Of Birth: ", SwingConstants.RIGHT);
        txtDateOfBirth = new JTextField();

        lblLastName = new JLabel("Last Name: ",SwingConstants.RIGHT);
        txtLastName = new JTextField();

        lblPhoneNumber = new JLabel("Phone Number: ",SwingConstants.RIGHT);
        txtPhoneNumber = new JTextField();

        lblEmail = new JLabel("Email: ",SwingConstants.RIGHT);
        txtEmail = new JTextField();

        lblAddress = new JLabel("Address: ",SwingConstants.RIGHT);
        txtAddress = new JTextField();


        btnDelete = new JButton("Delete");
        btnCancel = new JButton("Cancel");
        btnSearch = new JButton("Search");

        font1 = new Font("Ariel",Font.PLAIN,20);
        font2 = new Font("Ariel",Font.PLAIN,15);
    }

    public void setGUI(){
        panelCenter.setLayout(new GridLayout(8,2));
        panelSouth.setLayout(new GridLayout(1,2));

        lblHeader.setFont(font1);
        panelNorth.add(lblHeader);


        lblEmployeeID.setFont(font2);
        txtEmployeeID.setFont(font2);
        panelCenter.add(lblEmployeeID);
        panelCenter.add(txtEmployeeID);

        lblFirstName.setFont(font2);
        txtFirstName.setFont(font2);
        panelCenter.add(lblFirstName);
        panelCenter.add(txtFirstName);

        lblLastName.setFont(font2);
        txtLastName.setFont(font2);
        panelCenter.add(lblLastName);
        panelCenter.add(txtLastName);

        lblDateOfBirth.setFont(font2);
        txtDateOfBirth.setFont(font2);
        panelCenter.add(lblDateOfBirth);
        panelCenter.add(txtDateOfBirth);

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

        btnSearch.setFont(font2);
        panelSouth.add(btnSearch);
        btnDelete.setFont(font2);
        panelSouth.add(btnDelete);
        btnCancel.setFont(font2);
        panelSouth.add(btnCancel);


        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth,BorderLayout.SOUTH);

        btnDelete.addActionListener(this);
        btnCancel.addActionListener(this);
        btnSearch.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("Delete")){

            String emp_Id = txtEmployeeID.getText();
            String firstname = txtFirstName.getText();
            String surname = txtLastName.getText();
            String dateOfBirth = txtDateOfBirth.getText();
            String phoneNumber = txtPhoneNumber.getText();
            String email = txtEmail.getText();
            String address = txtAddress.getText();

            String url = "jdbc:mysql://localhost:3306/employeedb";
            String user = "root";
            String password = "root";

            Connection connection = null;
            Statement statement = null;
            int empID;

            try {
                connection = DriverManager.getConnection(url,user , password);
                statement = connection.createStatement();
                empID = statement.executeUpdate(" DELETE FROM employee WHERE emp_id = '" + emp_Id + "'");
                JOptionPane.showMessageDialog(null,"Employee record deleted");
                txtEmployeeID.setText("");
                txtFirstName.setText("");
                txtLastName.setText("");
                txtDateOfBirth.setText("");
                txtPhoneNumber.setText("");
                txtEmail.setText("");
                txtAddress.setText("");
                txtEmployeeID.requestFocus();



            }
            catch(SQLException sqlException) {
                JOptionPane.showMessageDialog(null, "Error: " + sqlException);
            }
        }
        else{
            if (e.getActionCommand().equals("Cancel")){
                System.exit(0);
            }
            else if(e.getActionCommand().equals("Search")){
                String emp_Id = txtEmployeeID.getText();
                String firstname = txtFirstName.getText();
                String surname = txtLastName.getText();
                String dateOfBirth = txtDateOfBirth.getText();
                String phoneNumber = txtPhoneNumber.getText();
                String address = txtAddress.getText();
                String email = txtEmail.getText();

                String url = "jdbc:mysql://localhost:3306/employeedb";
                String user = "root";
                String password = "root";

                Connection connection = null;
                ResultSet resultSet = null;

                try {
                    connection = DriverManager.getConnection(url,user,password);
                    Statement statement = connection.createStatement();
                    resultSet = statement.executeQuery("SELECT * FROM employee WHERE emp_id = '" + emp_Id + "'");
                    if (resultSet.next()) {
                        txtFirstName.setText(resultSet.getString("firstName"));
                        txtLastName.setText(resultSet.getString("lastName"));
                        txtDateOfBirth.setText(resultSet.getString("dateOfBirth"));
                        txtPhoneNumber.setText(resultSet.getString("phone"));
                        txtEmail.setText(resultSet.getString("email"));
                        txtAddress.setText(resultSet.getString("address"));
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Employee record not found");
                }
                catch(SQLException sqlException) {
                    JOptionPane.showMessageDialog(null, "Error: " + sqlException);
                }

            }
        }
    }

    public static void main(String[] args) {

        new RemoveEmployeeGui().setGUI();
    }

}
