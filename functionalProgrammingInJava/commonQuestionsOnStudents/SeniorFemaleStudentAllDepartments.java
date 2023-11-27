package functionalProgrammingInJava.commonQuestionsOnStudents;

import java.util.Comparator;
import java.util.List;

public class SeniorFemaleStudentAllDepartments {
    public static void main(String[] args) {
        List<Student> list = Student.getAllStudentList();
        Student seniorFemale = list.stream()
                                .filter(student->student.getGender().equals("Female"))
                                .max(Comparator.comparingInt(Student::getAge))
                                .get();
        System.out.println("Senior Female student is: "+seniorFemale);

        System.out.println("-------------------------------------------------------");

        int seniorFemaleStudentAge = list.stream()
                                .filter(student -> student.getGender().equals("Female"))
                                .mapToInt(Student::getAge)
                                .max()
                                .getAsInt();

        System.out.println("Senior Feamle student age is: "+seniorFemaleStudentAge);
    }
}
