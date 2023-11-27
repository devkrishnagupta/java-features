package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class YoungStudentInDepartmentWise {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();
        Map<String, Student> youngestStudentsInEachDept = list.stream()
                                    .collect(Collectors.groupingBy(
                                                Student::getDepartmantName,
                                                Collectors.collectingAndThen(
                                                            Collectors.minBy(Comparator.comparingInt(Student::getAge)),
                                                            Optional::get
                                                )
                                    )
                            );

        System.out.println("Youngest students in each depatrtments");
        // System.out.println(youngestStudentsInEachDept);
        System.out.println("------------------------------------------------------");
        youngestStudentsInEachDept.forEach((key, value)->{
            System.out.println("Department: " + key + " Age: "+value.getAge());
        });
        System.out.println("------------------------------------------------------");
        Map<String, Student> youngestStudentsInEachDept2 = list.stream()
                                    .collect(Collectors.groupingBy(Student::getDepartmantName)) //Here return type is Map<String, List<Student>>
                                    .entrySet()
                                    .stream()
                                    .collect(
                                        Collectors.toMap(
                                            Map.Entry::getKey, 
                                            entry -> entry.getValue().stream().sorted(Comparator.comparing(Student::getAge)).findFirst().get()
                                        )
                                    );
        // System.out.println(youngestStudentsInEachDept2);
        youngestStudentsInEachDept2.forEach((key, value)->{
            System.out.println("Department: " + key + " Age: "+value.getAge());
        });
    }
}
