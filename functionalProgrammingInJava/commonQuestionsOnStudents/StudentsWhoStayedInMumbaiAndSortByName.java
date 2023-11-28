package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsWhoStayedInMumbaiAndSortByName {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();

        List<Student> collect = list.stream()
                                .filter(student -> student.getCity().equals("Mumbai"))
                                .sorted(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName).reversed())//decreasing order
                                .sorted((e1, e2) -> e1.getFirstName().compareTo(e2.getFirstName()))//increasing order
                                .collect(Collectors.toList());
        System.out.println("Students who lives in Mumbai and sorted by their name in reversed order:-");
        System.out.println(collect);
    }
}
