package za.ac.cput.PRT362s_Project_2021;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantSystem extends JFrame implements ActionListener {
    private JPanel panel,panelNorth,panelWest,panelEast;
    private JLabel lblHeader,label1,label2,label3;
    private JButton btnAddEmp;
    private JButton btnUpdateEmp;
    private JButton btnDeleteEmp;
    private JButton btnClose;
    private Font font1,font2;

    public RestaurantSystem(){
        super("Employee Management System");
        panel = new JPanel();
        panelNorth = new JPanel();
        panelWest = new JPanel();
        panelEast = new JPanel();
        lblHeader = new JLabel("Admin section");
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();

        btnAddEmp= new JButton("Add Employee");
        btnUpdateEmp =  new JButton("Update Employee");
        btnDeleteEmp = new JButton("Delete Employee");
        btnClose = new JButton("Close");

        font1 = new Font("Ariel",Font.PLAIN,20);
        font2 = new Font("Ariel",Font.PLAIN,15);
    }
    public void setGUI(){
        panelNorth.setLayout(new FlowLayout());
        panelWest.setLayout(new FlowLayout());
        panelEast.setLayout(new FlowLayout());
        panel.setLayout(new GridLayout(4,2));
        lblHeader.setFont(font1);
        panelNorth.add(lblHeader);

        panelWest.add(label1);
        btnAddEmp.setFont(font2);
        panel.add(btnAddEmp);
        panelEast.add(label2);


        panelWest.add(label1);
        btnUpdateEmp.setFont(font2);
        panel.add(btnUpdateEmp);
        btnDeleteEmp.setFont(font2);
        panel.add(btnDeleteEmp);
        btnClose.setFont(font2);
        panel.add(btnClose);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelWest, BorderLayout.WEST);
        this.add(panelEast, BorderLayout.EAST);
        this.add(panel, BorderLayout.CENTER);

        btnAddEmp.addActionListener( this);
        btnUpdateEmp.addActionListener(this);
        btnDeleteEmp.addActionListener(this);
        btnClose.addActionListener(this);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnAddEmp){

            new AddEmployeeGui().setGui();
        }else if(e.getSource()==btnUpdateEmp){
            new UpdateEmployee().setGUI();
        }else if(e.getSource()==btnDeleteEmp){
            new RemoveEmployeeGui().setGUI();
        }else if(e.getActionCommand().equals("Close")){
            System.exit(0);

        }


    }

    public static void main(String[] args) {

        new RestaurantSystem().setGUI();
    }

}

