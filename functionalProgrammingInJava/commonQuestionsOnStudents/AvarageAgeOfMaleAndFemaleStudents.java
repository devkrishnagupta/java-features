package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AvarageAgeOfMaleAndFemaleStudents {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();
        Map<String, Double> collect = list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println("Average age of Male and Female students: "+collect);
    }
}
