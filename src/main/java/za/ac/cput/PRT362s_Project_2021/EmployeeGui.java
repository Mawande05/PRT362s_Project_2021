package za.ac.cput.PRT362s_Project_2021;
import za.ac.cput.PRT362s_Project_2021.Employee.Employee;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;

public class EmployeeGui implements ActionListener {
    private Frame mainframe;
    private JPanel panelNorth, panelWest, panelEast, panelSouth;
    private JLabel lblLogo;
    private JLabel lblHeading;
    private JLabel lblId, lblName, lblDepartment, lblSalary;
    private JTextField txtId, txtName, txtDepartment, txtSalary;
    private JButton btnAdd, btnDelete, btnUpdate;
    private Font ft1, ft2;

    public EmployeeGui() {
        mainframe = new Frame("Employee Application");
        panelNorth = new JPanel();
        panelWest = new JPanel();
        panelEast = new JPanel();
        panelSouth = new JPanel();

        lblHeading = new JLabel("Add Employee Details");

        lblId = new JLabel("ID: ");
        lblName = new JLabel("Name: ");
        lblDepartment = new JLabel("Department: ");
        lblSalary = new JLabel("Salary: ");
        txtId = new JTextField();
        txtName = new JTextField();
        txtDepartment = new JTextField();
        txtSalary = new JTextField();
        btnAdd = new JButton("Add");
        btnDelete = new JButton("Delete");
        btnUpdate = new JButton("Update");

        ft1 = new Font("Arial", Font.BOLD, 32);
        ft2 = new Font("Arial", Font.PLAIN, 22);

    }

    public void setGUI() {
        panelNorth.setLayout(new FlowLayout());
        panelEast.setPreferredSize(new Dimension(700, 130));
        panelWest.setLayout(new GridLayout(4, 1));
        panelEast.setLayout(new GridLayout(4, 1));
        panelSouth.setLayout(new GridLayout(1, 3));


        panelNorth.add(lblHeading);
        lblHeading.setFont(ft1);
        lblHeading.setForeground(Color.yellow);
        panelNorth.setBackground(Color.LIGHT_GRAY);

        lblId.setFont(ft2);
        lblName.setFont(ft2);
        lblDepartment.setFont(ft2);
        lblSalary.setFont(ft2);
        txtId.setFont(ft2);
        txtName.setFont(ft2);
        txtDepartment.setFont(ft2);
        txtSalary.setFont(ft2);
        btnAdd.setFont(ft2);
        btnDelete.setFont(ft2);
        btnUpdate.setFont(ft2);

        panelWest.add(lblId);
        panelWest.add(lblName);
        panelWest.add(lblDepartment);
        panelWest.add(lblSalary);
        panelEast.add(txtId);
        panelEast.add(txtName);
        panelEast.add(txtDepartment);
        panelEast.add(txtSalary);
        panelSouth.add(btnAdd);
        panelSouth.add(btnDelete);
        panelSouth.add(btnUpdate);

        mainframe.add(panelNorth, BorderLayout.NORTH);
        mainframe.add(panelWest, BorderLayout.WEST);
        mainframe.add(panelEast, BorderLayout.EAST);
        mainframe.add(panelSouth, BorderLayout.SOUTH);
        mainframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        btnAdd.addActionListener(this);
        btnDelete.addActionListener(this);
        btnUpdate.addActionListener(this);
        mainframe.pack();
        mainframe.setVisible(true);
        txtId.requestFocus();
    }
    public void clear() {
        txtId.setText(" ");
        txtName.setText(" ");
        txtDepartment.setText(" ");
        txtSalary.setText(" ");
        txtId.requestFocus();
    }



    public boolean isValid() {
        boolean valid = true;

        if (txtSalary.getText().equals("")) {
            txtSalary.setText("Invalid Salary");
            txtSalary.requestFocus(true);
            valid = false;
        }

        if (txtName.getText().equals("")) {
            txtName.setText("Invalid Name");
            txtName.requestFocus(true);
            valid = false;
        }

        if (txtDepartment.getText().equals("")) {
            txtDepartment.setText("Invalid Department");
            txtDepartment.requestFocus(true);
            valid = false;
        }

        if (txtId.getText().equals("")) {
            txtId.setText("Invalid Id");
            txtId.requestFocus(true);
            valid = false;
        }

        return valid;
    }

    public void actionPerformed(ActionEvent e) {
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String value1 = txtId.getText();
                String value2 = txtName.getText();
                String value3 = txtDepartment.getText();
                String value4 = txtSalary.getText();
                Connection con = null;
                String url = "jdbc:mysql://localhost:3306/";
                String db = "test";
                String driver = "com.mysql.jdbc.Driver";
                String user = "root";
                String pass = "root";
                System.out.println(value1 + value2 + value3 + value4);
                try {
                    Class.forName(driver);
                    con = DriverManager.getConnection(url + db, user, pass);
                    PreparedStatement st = con.prepareStatement("insert into employee(emp_id,emp_name,emp_department,salary) values(?,?,?,?)");
                    st.setString(1, value1);
                    st.setString(2, value2);
                    st.setString(3, value3);
                    st.setString(4, value4);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(mainframe, "Data is successfully inserted into database.");
                    con.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(mainframe, "Error in submitting data!");
                }
            }
        });

    }
    public static void main(String[] args) {
        new EmployeeGui().setGUI();
    }

}




