package functionalProgrammingInJava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindingMaximumOnEmployeeBasedFileds{
    public static void main(String[] args) {
               System.out.println("Hello, World!");
        List<Employee> list = Arrays.asList(
            new Employee(1, "Dev", 10.0),
            new Employee(1, "Dev", 5.0),
            new Employee(2, "Sanjay", 20.0),
            new Employee(3, "Abhishek", 30.0),
            new Employee(4, "Santosh", 40.0),
            new Employee(5, "Mohit", 50.0),
            new Employee(6, "Rasik", 60.0)
        );
        System.out.println(list);
        
        System.out.println("Hello, World!");
        double ans1 = list.stream().sorted((e1, e2) -> e1.getSalary() > e2.getSalary() ? 1 : -1).map(n->n.getSalary()).findFirst().orElse(1.0);
        
        double ans2 = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).map(n->n.getSalary()).findFirst().orElse(1.0);
        
        double ans3 = list.stream().sorted(Comparator.comparingDouble(n->n.getSalary())).map(n->n.getSalary()).findFirst().orElse(-1.0);

        double ans4 = list.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).map(n->n.getSalary()).findFirst().orElse(1.0);
        
        System.out.println("1 => "+ans1);
        System.out.println("2 => "+ans2);
        System.out.println("3 => "+ans3);
        System.out.println("4 => "+ans4);

    }
}




class Employee {
    private int id;
    private String name;
    private double salary;
    Employee(int id, String name, double salary){
        this.id = id;
        this.name=name;
        this.salary=salary;
    }
    public int getId(){
        return this.id;
    }
    public double getSalary(){
        return this.salary;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public String toString(){
        return "\nEmployee(id="+this.id+", name="+this.name+", salary="+this.salary+")";
    }
}
