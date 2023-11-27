package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.List;
import java.util.OptionalInt;

public class MaxAgeOfStudents {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();
        // OptionalInt max = list.stream().map(Student::getAge).mapToInt(Integer::intValue).max();
        OptionalInt max = list.stream().mapToInt(Student::getAge).max();
        System.out.println("Max age of students " + max.getAsInt());
    }
}
