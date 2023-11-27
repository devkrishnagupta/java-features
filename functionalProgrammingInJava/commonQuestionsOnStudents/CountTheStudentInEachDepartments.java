package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountTheStudentInEachDepartments {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();

        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
        System.out.println("Count of Students in each Department");
        System.out.println(collect);
    }
}
