package ro.sci.tema09_student_repository.util;

import ro.sci.tema09_student_repository.student.Student;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getLastName().compareToIgnoreCase(o2.getLastName());
    }
}
