package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class HighestRankInEachDepartment {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();
        Map<String, Student> collect = list.stream()
                                        .collect(
                                            Collectors.groupingBy(
                                                Student::getDepartmantName,
                                                Collectors.collectingAndThen(
                                                    Collectors.maxBy(Comparator.comparingInt(Student::getRank)),
                                                    Optional::get
                                                )
                                            )
                                        );
        System.out.println("Highest Rank of Students in each Departments: ");
        System.out.println(collect);

        Map<String, Student> collect2 = list.stream()
                                            .collect(Collectors.groupingBy(Student::getDepartmantName))
                                            .entrySet()
                                            .stream()
                                            .collect(Collectors.toMap(
                                                Map.Entry::getKey,
                                                entry -> entry.getValue().stream().max(Comparator.comparingInt(Student::getRank)).get()//or instead max we can use sorted and findFirst
                                            ));
        System.out.println(collect2);
        System.out.println("-------------------------------------------------------------------------");
        // Map<String, Integer> collect4 = list.stream()
        //                                 .collect(
        //                                     Collectors.groupingBy(
        //                                         Student::getDepartmantName,
        //                                         Collectors.mapping(null, null)
        //                                     )
        //                                 );
        // System.out.println(collect4);
        Map<String, Integer> collect3 = list.stream()
                                            .collect(Collectors.groupingBy(Student::getDepartmantName))
                                            .entrySet()
                                            .stream()
                                            .collect(
                                                Collectors.toMap(
                                                    Map.Entry::getKey, 
                                                    entry->entry.getValue().stream().mapToInt(Student::getRank).max().getAsInt()
                                                )
                                            );
        System.out.println(collect3);
                
    }
}
