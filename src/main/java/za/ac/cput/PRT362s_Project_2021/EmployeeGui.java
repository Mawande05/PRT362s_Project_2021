package za.ac.cput.PRT362s_Project_2021;
import za.ac.cput.PRT362s_Project_2021.Employee.Employee;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class EmployeeInformation {
    JFrame mainframe;
    JPanel panel1,panel2,panel3;
    JTabbedPane tp;
    JLabel lblLogo,lblId, lblName, lblAddress, lblSalary,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
    JButton btnSave,btnReset,btnEdit1,btnEdit2,btnDelete ;

    EmployeeInformation() {
        mainframe = new JFrame("Employee Application");
        panel1 = new JPanel(new GridLayout(5, 2));
        panel2 = new JPanel(new GridLayout(5, 2));
        panel3 = new JPanel(new GridLayout(2, 2));
        tp = new JTabbedPane();
        lblId = new JLabel("Employee ID:");
        lblName = new JLabel("Employee Name:");
        lblAddress = new JLabel("Employee Address:");
        lblSalary = new JLabel("Salary:");
        lbl5 = new JLabel("Enter Employee ID to delete record:");

        lbl7 = new JLabel("Employee ID:");
        lbl8 = new JLabel("Employee Name:");
        lbl9 = new JLabel("Employee Address:");
        lbl10 = new JLabel("Salary:");
        tf1 = new JTextField(12);
        tf2 = new JTextField(12);
        tf3 = new JTextField(12);
        tf4 = new JTextField(12);
        tf5 = new JTextField(12);
        tf6 = new JTextField(12);
        tf7 = new JTextField(12);
        tf8 = new JTextField(12);
        tf9 = new JTextField(12);
        tf10 = new JTextField(12);
        btnSave = new JButton(" Add ");
        btnReset = new JButton(" Reset");
        btnEdit1 = new JButton(" Edit ");
        btnEdit2 = new JButton(" Save");
        btnDelete = new JButton("Delete");

        panel1.setBackground(new Color(88, 220, 204));

        panel1.add(lblId);
        panel1.add(tf1);
        panel1.add(lblName);
        panel1.add(tf2);
        panel1.add(lblAddress);
        panel1.add(tf3);
        panel1.add(lblSalary);
        panel1.add(tf4);
        panel1.add(btnSave);
        panel1.add(btnReset);

        panel2.add(lbl7);
        panel2.add(tf7);
        panel2.add(lbl8);
        panel2.add(tf8);
        panel2.add(lbl9);
        panel2.add(tf9);
        panel2.add(lbl10);
        panel2.add(tf10);
        panel2.add(btnEdit1);
        panel2.add(btnEdit2);

        panel3.add(lbl5);
        panel3.add(tf5);
        panel3.add(btnDelete);
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
            }
        });
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String value1 = tf1.getText();
                String value2 = tf2.getText();
                String value3 = tf3.getText();
                String value4 = tf4.getText();
                Connection con = null;
                String url = "jdbc:mysql://localhost:3306/";
                String db = "test";
                String driver = "com.mysql.jdbc.Driver";
                String username = "root";
                String password = " ";
                System.out.println(value1 + value2 + value3 + value4);
                try {
                    Class.forName(driver);
                    con = DriverManager.getConnection(url + db, username, password);
                    PreparedStatement st = con.prepareStatement("insert into employee(emp_id,emp_name,emp_address,salary) values(?,?,?,?)");
                    st.setString(1, value1);
                    st.setString(2, value2);
                    st.setString(3, value3);
                    st.setString(4, value4);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(panel1, "Data is successfully inserted into database.");
                    con.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(panel1, "Error in submitting data!");
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String value1 = tf5.getText();
                Connection con = null;
                String url = "jdbc:mysql://localhost:3306/";
                String db = "test";
                String driver = "com.mysql.jdbc.Driver";
                String username = "root";
                String password = " ";
                try {
                    Class.forName(driver);
                    con = DriverManager.getConnection(url + db, username, password);
                    PreparedStatement st = con.prepareStatement("DELETE FROM employee WHERE emp_id = ?");
                    st.setString(1, value1);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(panel3, "Record is deleted successfully.");
                    con.close();
                } catch (Exception exp3) {
                    JOptionPane.showMessageDialog(panel3, "Error in deleting record.");
                }
            }
        });

    }
    void dis()
    {
        mainframe.getContentPane().add(tp);
        tp.addTab("Add Record",panel1);
        tp.addTab("Edit Record",panel2);
        tp.addTab("Delete Record",panel3);

        mainframe.setSize(450,280);
        mainframe.setVisible(true);
        mainframe.setResizable(true);
    }
    public static void main(String z[]){
        EmployeeInformation pro=new EmployeeInformation();
        pro.dis();
    }
}

