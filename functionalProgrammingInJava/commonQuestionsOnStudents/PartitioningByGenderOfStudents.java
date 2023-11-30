package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningByGenderOfStudents {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();
        Map<Boolean, List<Student>> collect = list.stream()
                                                    .collect(Collectors.partitioningBy((Student emp) -> emp.getGender().equals("Male")));
        System.out.println("Partitioning by gender: "+collect);
    }
}