package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStudentsByDepartmentsNames {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();
        System.out.println(list);
        Map<String, List<Student>> ans = list.stream().collect(Collectors.groupingBy(employee -> employee.getDepartmantName()));
        System.out.println("Students grouped by Department ");
        System.out.println("--------------------------------------------------------");
        System.out.println(ans);
        System.out.println("========================================================");
        ans.forEach((key, value) -> {
            System.out.println("KEY: "+key+", VALUE: "+value);
        });
    }
}
