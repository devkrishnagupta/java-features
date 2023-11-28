package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.List;

public class TotalCountOrNumberOfStudents {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();
        
        long count = list.stream().count();

        System.out.println("Total number/count of students: ");
        System.out.println(count);
    }
}
