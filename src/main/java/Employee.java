public class Employee {
    private String id;
    private String name;
    private String department;
    private double monthlySalary;

    public Employee(String id, String name, String department, double monthlySalary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.monthlySalary = monthlySalary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", monthlySalary=" + monthlySalary +
                '}';
    }
}
