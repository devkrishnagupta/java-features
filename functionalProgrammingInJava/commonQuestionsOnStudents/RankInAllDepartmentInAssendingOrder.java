package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankInAllDepartmentInAssendingOrder {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();
        Map<String, List<Student>> collect = list.stream()
                                            .collect(Collectors.groupingBy(Student::getDepartmantName))
                                            .entrySet()
                                            .stream()
                                            .collect(
                                                Collectors.toMap(
                                                    Map.Entry::getKey,
                                                    entry -> entry.getValue().stream().sorted(Comparator.comparingInt(Student::getRank)).collect(Collectors.toList())
                                                )
                                            );
        System.out.println("Rank of students in all departments in increasing order: ");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(collect);
        Map<String, List<Student>> collect2 = list.stream()
                                                    .collect(
                                                        Collectors.groupingBy(
                                                            Student::getDepartmantName, 
                                                            Collectors.collectingAndThen(
                                                                Collectors.toList(),
                                                                tempList -> tempList.stream().sorted(Comparator.comparingInt(Student::getRank)).collect(Collectors.toList())
                                                            )
                                                        )
                                                    );
        System.out.println(collect2);               
    }
}
