package EmployeeManagementSystem;

public class Employee {
    final private int employeeId;
    final private String name,position;
    private double salary;

    Employee(int employeeId,String name,String position,double salary){
        this.employeeId=employeeId;
        this.name=name;
        this.position=position;
        this.salary=salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }
}

