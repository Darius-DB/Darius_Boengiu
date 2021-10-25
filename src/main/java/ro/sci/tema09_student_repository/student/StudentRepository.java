package ro.sci.tema09_student_repository.student;

import ro.sci.tema09_student_repository.exceptions.MissingNameException;
import ro.sci.tema09_student_repository.exceptions.StudentNotFoundException;
import ro.sci.tema09_student_repository.util.AgeCalculator;
import ro.sci.tema09_student_repository.util.AgeComparator;
import ro.sci.tema09_student_repository.util.LastNameComparator;

import java.time.LocalDate;
import java.util.*;

public class StudentRepository {

    private static List<Student> studentList = new ArrayList<>();
    private static List<Student> studentsByAge = new ArrayList<>();

    public static Student addStudent(String firstName, String lastName, String gender, LocalDate dateOfBirth) throws MissingNameException {

        if (firstName.trim().isEmpty() || lastName.trim().isEmpty()) {
            throw new MissingNameException("Last name or first name field may be empty");
        } else if (!(gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f"))) {
            throw new IllegalArgumentException("Gender should be 'M or 'F");
        } else if (dateOfBirth.isBefore(LocalDate.of(1900, 1, 1)) ||
                dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth should be between 1900 and current year");
        }

        Student newStudent = new Student(firstName, lastName, dateOfBirth, gender);
        studentList.add(newStudent);
        return newStudent;
    }

    public static void deleteStudentByCnp(String cnp) throws StudentNotFoundException {
        Student studentToDelete = null;

        for (Student student : studentList) {
            if (student.getCnp().equals(cnp)) {
                studentToDelete = student;
                studentList.remove(studentToDelete);
                break;
            }
//            } else {
//                throw new StudentNotFoundException("The student does not exist");
//            }
        }
        if (studentToDelete == null) {
            throw new StudentNotFoundException("The student does not exist");
        }
    }


    public static void retrieveAllStudentsByAge(Integer age) throws StudentNotFoundException {
        boolean foundAge = false;
        if (age < 0 || !(age instanceof Number)) {
            throw new IllegalArgumentException("There seems to be a problem with the age");
        }

        for (Student student : studentList) {
            if (age == AgeCalculator.calculateAge(student.getDateOfBirth(), LocalDate.now())) {
                studentsByAge.add(student);
                foundAge = true;
            }
        }

        if (foundAge == false) {
            throw new StudentNotFoundException("There are no " + age + " years old students");
        }

        System.out.println(studentsByAge);
    }

    public static void sortStudentsByLastName() throws MissingNameException {
        List<Student> studentListCopy = new ArrayList<>(studentList);
        studentListCopy.sort(new LastNameComparator());
        System.out.println(studentListCopy);
    }

    public static void printStudents() {
        System.out.println(studentList);
    }

    public static List<Student> getStudentList() {
        return Collections.unmodifiableList(studentList);
    }

    public static List<Student> getStudentsByAge() {
        return Collections.unmodifiableList(studentsByAge);
    }

}
