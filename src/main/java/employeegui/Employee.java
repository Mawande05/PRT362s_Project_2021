/**
 *
 * @author Asive madladla 217068332
 * employee class
 * serialization
 */
package employeegui;

import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Employee implements Serializable {

    private String id;
    private String department;
    private String name;
    private double salary;

    public Employee(String id, String department,String name, double salary) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
    public void set (String id, String department,String name, double salary){
        this.id = id;
        this.department = department;
        this.name = name;
        this.salary = salary;

    }
    public void close(Closeable c) {
        if (c == null)
         return;
        try {
            c.close();
        } catch (IOException e) {
            //log the exception
        }
    }
    public boolean saveToFile() {
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        boolean success = true;
        try {
            fileOut = new FileOutputStream("Empoyee.ser");
            out = new ObjectOutputStream(fileOut);

            out.writeObject(this);
        }
        catch  (IOException e) {
            success = false;
            e.printStackTrace();
        }
        finally {
            close(out);
            close(fileOut);
        }
        return success;
    }
}

