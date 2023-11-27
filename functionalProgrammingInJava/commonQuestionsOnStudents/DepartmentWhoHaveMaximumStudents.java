package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class DepartmentWhoHaveMaximumStudents {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();

        String departmentName = list.stream()
                                    .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
                                    .entrySet()
                                    .stream()
                                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                                    .map(Map.Entry::getKey)
                                    .findFirst()
                                    .get();
        System.out.println("Department with maximum students: " + departmentName);

        String departmentName2 = list.stream()
                                    .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
                                    .entrySet()
                                    .stream()
                                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                                    .map(Map.Entry::getKey)
                                    .findFirst()
                                    .get();
        System.out.println("Department with maximum students: " + departmentName2);

        Entry<String, Long> entry = list.stream()
                                    .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
                                    .entrySet()
                                    .stream()
                                    .max(Map.Entry.comparingByValue())
                                    .get();

        System.out.println("Department with maximum students: " + entry.getKey());
                                    
                                    
                                    
    }
}
