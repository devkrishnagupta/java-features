package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.List;
// import java.util.stream.Collectors;

public class StudentsWhoseAgeIsLessThan25 {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();
        List<Student> ans = list.stream().filter(student -> student.getAge() < 25).toList();
        // List<Student> ans = list.stream().filter(student -> student.getAge() < 25).collect(Collectors.toList());
        System.out.println(ans);
    }
}
