package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AvergaeRankInAllDepartments {
    public static void main(String[] args) {

        List<Student> list = Student.getAllStudentList();

        Map<String, Double> collect = list.stream()
                                            .collect(Collectors.groupingBy(
                                                Student::getDepartmantName,
                                                Collectors.averagingInt(Student::getRank)
                                            ));

        Map<String, Double> collect2 = list.stream()
                                            .collect(Collectors.groupingBy(Student::getDepartmantName))
                                            .entrySet()
                                            .stream()
                                            .collect(
                                                Collectors.toMap(
                                                    Map.Entry::getKey, 
                                                    entry->entry.getValue().stream().mapToInt(Student::getRank).average().getAsDouble()
                                                )
                                            );
        System.out.println(collect2);
        System.out.println("Average Rank in All Departments: ");
        System.out.println(collect);
        // collect.forEach((key, value) -> {
        //     System.out.println("Departmennt name: "+key+" Average Rank: "+value);
        // });
        
    }
}
