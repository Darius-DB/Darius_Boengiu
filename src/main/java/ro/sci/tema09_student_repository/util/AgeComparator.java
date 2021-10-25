package ro.sci.tema09_student_repository.util;

import ro.sci.tema09_student_repository.student.Student;

import java.time.LocalDate;
import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int o1Age = AgeCalculator.calculateAge(o1.getDateOfBirth(), LocalDate.now());
        int o2Age = AgeCalculator.calculateAge(o2.getDateOfBirth(), LocalDate.now());
        return o1Age - o2Age;
    }
}
