// package functionalProgrammingInJava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmployeeOnMultipleFields {
    public static void main(String[] args) {
        List<Employee1> employees = new ArrayList<>();
        Employee1 e1 = new Employee1("Ajay",51);
        Employee1 e2 = new Employee1("Vijay",5);
        Employee1 e3 = new Employee1("Zack",30);
        Employee1 e4 = new Employee1("David",51);
        Employee1 e5 = new Employee1("Ajay",35);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        List<Employee1> ans = employees.stream().sorted(Comparator.comparing(Employee1::getFirstName).thenComparing(Employee1::getAge)).collect(Collectors.toList());
        System.out.println(ans);
    }
}

class Employee1 {
    private String firstName;
    private int age;
    public Employee1(String firstName, int age){
        this.firstName=firstName;
        this.age=age;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public int getAge(){
        return this.age;
    }
    @Override
    public String toString() {
        return "Employee1 [firstName=" + firstName + ", age=" + age + "]";
    }
}
