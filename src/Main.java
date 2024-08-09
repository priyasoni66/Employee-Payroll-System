import java.util.ArrayList;
import java.util.List;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [Name = "+name+", " + "Id = " +id+", Salary = "+calculateSalary()+"]\n";
    }
}

class fullTimeEmployee extends Employee{
    private double monthlySalary;
    public fullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}
class partTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;
    public partTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}
class PayrollSystem{
   private ArrayList<Employee> employeeList;

   public PayrollSystem(){
       employeeList = new ArrayList<>();
   }
// add
    public void addEmployee(Employee employee){
       employeeList.add(employee);
    }
// remove
    public void removeEmployee(int id){
       Employee employeeToRemove = null;
       for(Employee employee : employeeList){
            if(employee.getId() == id){
                employeeToRemove = employee;
                break;
            }
       }
       if(employeeToRemove != null){
           employeeList.remove(employeeToRemove);
       }
    }
    public void displayDetails(){
       for(Employee employee : employeeList){
           System.out.print(employee);
       }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        fullTimeEmployee emp1 = new fullTimeEmployee("Aman Sharma",1,50000);
        partTimeEmployee emp2 = new partTimeEmployee("Sharad Gupta",2, 4, 800);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details : ");
        payrollSystem.displayDetails();
        System.out.println("\nRemoving Employee.... ");
        payrollSystem.removeEmployee(2);
        System.out.println("\nRemaining Employee Details : ");
        payrollSystem.displayDetails();
    }
}


