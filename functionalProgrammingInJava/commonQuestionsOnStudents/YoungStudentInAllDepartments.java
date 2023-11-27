package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.Comparator;
import java.util.List;

public class YoungStudentInAllDepartments {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();
        Student student = list.stream().min(Comparator.comparingInt(Student::getAge)).get();
        System.out.println("Minimum age of student: " + student.getAge());
        int min = list.stream().mapToInt(Student::getAge).min().getAsInt();
        System.out.println("Minium age of student: " + min);
    }
}
