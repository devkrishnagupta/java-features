package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import immutableCustomClass.Employee;

public class FindAllDepartmentNames {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();
        System.out.println("Department names: ");
        List<String> names = list.stream()
                        .map(Student::getDepartmantName)
                        .collect(Collectors.toList());
        System.out.println(names);
        System.out.println("-----------------------------------------------------");
        List<String> namesWithoutDuplicates = list.stream()
                        .map(Student::getDepartmantName)
                        .distinct()
                        .sorted()//as it list of string not object
                        .collect(Collectors.toList());
        System.out.println(namesWithoutDuplicates);
        System.out.println("-----------------------------------------------------");
        List<String> namesWithoutDuplicatesInRev = list.stream()
                        .map(Student::getDepartmantName)
                        .distinct()
                        .sorted(Collections.reverseOrder())//as it list of string not object
                        .collect(Collectors.toList());
        System.out.println(namesWithoutDuplicatesInRev);
    }
}
