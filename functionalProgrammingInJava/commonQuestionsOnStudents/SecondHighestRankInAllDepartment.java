package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecondHighestRankInAllDepartment {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();
        Student student = list.stream()
                                .sorted(Comparator.comparingInt(Student::getRank).reversed())
                                .skip(1)
                                .findFirst()
                                .get();
        System.out.println("Second Highest Rank in All the departments:");
        System.out.println(student);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Second Highest rank in each departments");

        Map<String, Student> collect2 = list.stream()
                                    .collect(
                                        Collectors.groupingBy(
                                            Student::getDepartmantName,
                                            Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                tempList -> tempList.stream().sorted(Comparator.comparingInt(Student::getRank).reversed()).skip(1).findFirst().orElse(null)
                                            )
                                        )
                                    );
        System.out.println(collect2);
    }
}
