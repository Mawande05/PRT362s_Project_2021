package za.ac.cput.PRT362s_Project_2021;

public class Employee {
    private  String emp_Id;
    private String firstname;
    private String surname;
    private String dateOfBirth;
    private String phoneNumber;
    private String address;
    private String email;


    public Employee(String emp_Id, String firstname, String surname, String dateOfBirth, String phoneNumber, String address, String email) {
        this.emp_Id = emp_Id;
        this.firstname = firstname;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }
}
