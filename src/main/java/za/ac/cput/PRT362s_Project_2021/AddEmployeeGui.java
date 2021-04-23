package za.ac.cput.PRT362s_Project_2021;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployeeGui extends JFrame implements ActionListener {
    private JPanel panelNorth;
    private JPanel panelCenter,panelEast;
    private JPanel panelSouth;

    private JLabel lblHeader;
    private JLabel lblFirstname;
    private JTextField txtFirstname;

    private JLabel lblSurname;
    private JTextField txtSurname;
    private JLabel lblEmpId;
    private JTextField txtEmpId;

    private JLabel lblDateOfBirth;
    private JTextField txtDateOfBirth;
    private JLabel lblPhoneNumber;
    private JTextField txtPhoneNumber;

    private JLabel lblAddress;
    private JTextField txtAddress;
    private JLabel lblEmail;
    private JTextField txtEmail;

    private JButton btnSubmit;
    private JButton btnCancel;

    private Font font1,font2;

    public AddEmployeeGui(){
        super("Employee system ");

        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelEast = new JPanel();
        panelSouth = new JPanel();

        lblHeader = new JLabel("Add new employee");
        lblEmpId = new JLabel("Employee ID: ");
        txtEmpId = new JTextField();

        lblFirstname = new JLabel("First Name: ");
        txtFirstname = new JTextField();
        lblSurname = new JLabel("Surname: ");
        txtSurname = new JTextField();

        lblDateOfBirth = new JLabel("Date Of Birth: ");
        txtDateOfBirth = new JTextField();
        lblPhoneNumber = new JLabel("Phone Number: ");
        txtPhoneNumber = new JTextField();

        lblEmail = new JLabel("Email: ");
        txtEmail = new JTextField();
        lblAddress = new JLabel("Address: ");
        txtAddress = new JTextField();

        btnSubmit = new JButton("Submit");
        btnCancel = new JButton("Cancel");

        font1 = new Font("Ariel",Font.PLAIN,20);
        font2 = new Font("Ariel",Font.PLAIN,15);

    }
    public void setGui(){
        panelNorth.setLayout(new FlowLayout());
        panelCenter.setLayout(new GridLayout(4,2));
        panelEast.setLayout(new GridLayout(4,2));
        panelSouth.setLayout(new GridLayout(1,2));

        lblHeader.setFont(font1);
        panelNorth.add(lblHeader);

        lblEmpId.setFont(font2);
        txtEmpId.setFont(font2);
        panelCenter.add(lblEmpId);
        panelCenter.add(txtEmpId);

        lblFirstname.setFont(font2);
        txtFirstname.setFont(font2);
        panelCenter.add(lblFirstname);
        panelCenter.add(txtFirstname);

        lblSurname.setFont(font2);
        txtSurname.setFont(font2);
        panelEast.add(lblSurname);
        panelEast.add(txtSurname);

        lblDateOfBirth.setFont(font2);
        txtDateOfBirth.setFont(font2);
         panelEast.add(lblDateOfBirth);
         panelEast.add(txtDateOfBirth);

        lblPhoneNumber.setFont(font2);
        txtPhoneNumber.setFont(font2);
        panelCenter.add(lblPhoneNumber);
        panelCenter.add(txtPhoneNumber);

        lblEmail.setFont(font2);
        txtEmail.setFont(font2);
         panelEast.add(lblEmail);
         panelEast.add(txtEmail);

        lblAddress.setFont(font2);
        txtAddress.setFont(font2);
        panelCenter.add(lblAddress);
        panelCenter.add(txtAddress);

        btnSubmit.setFont(font2);
        panelSouth.add(btnSubmit);
        btnCancel.setFont(font2);
        panelSouth.add(btnCancel);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelEast,BorderLayout.EAST);
        this.add(panelSouth, BorderLayout.SOUTH);

        btnSubmit.addActionListener(this);
        btnCancel.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent event){
        if (event.getActionCommand().equals("Submit")){


        }else{
            if (event.getActionCommand().equals("Cancel")){
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new AddEmployeeGui().setGui();
    }

}
