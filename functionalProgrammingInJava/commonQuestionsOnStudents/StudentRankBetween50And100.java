package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.List;
import java.util.stream.Collectors;

public class StudentRankBetween50And100 {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();
        List<Student> collect = list.stream().filter(student -> student.getRank() >= 50 && student.getRank()<=100).collect(Collectors.toList());
        System.out.println("Students whose rank is between 50 to 100");
        System.out.println(collect);
    }
}