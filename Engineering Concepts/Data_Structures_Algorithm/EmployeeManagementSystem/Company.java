package EmployeeManagementSystem;

public class Company {
    Employee[] addEmployee(Employee[] employee,String name,int id,String position,double salary){
        Employee n=new Employee(id, name, position, salary);
        int flag=0;
        for(int i=0;i<employee.length;i++){
            if(employee[i]==null){
                employee[i]=n;
                flag=1;
                break;
            }
        }
        if(flag==1)System.out.println("Employee Added Successfully");
        else System.out.println("Not Enough Space In Company");
        return employee;
    }

    Employee searchEmployee(Employee[] employee,int id,String name,String position){
        Employee emp=null;
        for(Employee a:employee){
            if(a.getEmployeeId()==id||a.getPosition().equalsIgnoreCase(position)||a.getName().equalsIgnoreCase(name)){
                emp=a;
                break;
            }
        }
        if(emp==null)System.out.println("Employee Not Found");
        else System.out.println("Empployee found");
        return emp;
    }

    void traverseEmployee(Employee[] employee){
        for (Employee e : employee) {
            if(e!=null)
            System.out.println("\nName:"+e.getName()+"\nId:"+e.getEmployeeId()+"\nPosition:"+e.getPosition()+"\nSalary"+e.getSalary());
        }
    }

    Employee[] deleteEmployee(Employee[] employee,int id,String name,String position){
        Employee emp=searchEmployee(employee, id, name, position);
        for(int i=0;i<employee.length;i++){
            if(emp==employee[i]){
                employee[i]=null;
                System.out.println("Employee Successfully Deleted!");
                break;
            }
        }
        return employee;
    }
}
