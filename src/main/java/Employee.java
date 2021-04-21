/*
* Asive Madladla 217068332
* Employee Class
 */
public class Employee {
    private String id, name, department;
    private double monthlySalary;

    private Employee (Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.department = builder.department;
        this.monthlySalary = builder.monthlySalary;

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

    public static class Builder {
        private String id, name, department;
        private double monthlySalary;

        public Builder id(String id) {

            this.id = id;
            return this;

        }

        public Builder name(String name) {

            this.name = name;
            return this;
        }

        public Builder department(String department) {

            this.department = department;
            return this;
        }

        public Builder monthlySalary(double monthlySalary) {

            this.monthlySalary = monthlySalary;
            return this;
        }
        public Employee build(){
            return new Employee(this);

        }
    }
}

