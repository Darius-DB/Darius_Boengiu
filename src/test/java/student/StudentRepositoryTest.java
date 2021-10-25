package student;

import org.junit.Ignore;
import ro.sci.tema09_student_repository.exceptions.MissingNameException;
import ro.sci.tema09_student_repository.exceptions.StudentNotFoundException;
import ro.sci.tema09_student_repository.student.StudentRepository;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class StudentRepositoryTest {


    @org.junit.Before
    public void setUp() throws Exception {
        StudentRepository.addStudent("John", "Doe", "m", LocalDate.of(1990, 1,1));

    }

    @org.junit.After
    public void tearDown() throws StudentNotFoundException {
        StudentRepository.deleteStudentByCnp("1900101");
    }

    @org.junit.Test
    public void addStudentSuccess() {
        assertEquals("Student added successfully", 1, StudentRepository.getStudentList().size());
    }

    @org.junit.Test(expected = MissingNameException.class)
    public void failAddStudentIfEmptyName() throws MissingNameException {
        StudentRepository.addStudent("    ", "doe", "m", LocalDate.of(1990, 1,1));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void failAddStudentIfWrongGender() throws MissingNameException {
        StudentRepository.addStudent("john", "doe", "h", LocalDate.of(1990, 1,1));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void failAddStudentIfWrongBirthDate() throws MissingNameException {
        StudentRepository.addStudent("john", "doe", "m", LocalDate.of(1890, 1,1));
    }

    @Ignore
    @org.junit.Test
    public void  deleteStudentByCnpSuccess() throws StudentNotFoundException {
        StudentRepository.deleteStudentByCnp("1900101");
        assertEquals("Student deleted successfully", 0, StudentRepository.getStudentList().size());
    }

    @org.junit.Test(expected = StudentNotFoundException.class)
    public void failDeleteStudentByCnp() throws StudentNotFoundException {
        StudentRepository.deleteStudentByCnp("190110");
    }

    @org.junit.Test
    public void retrieveAllStudentsByAgeSuccess() throws StudentNotFoundException {
        StudentRepository.retrieveAllStudentsByAge(31);
        assertEquals(1, StudentRepository.getStudentsByAge().size());
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void failRetrieveAllStudentsByAge() throws StudentNotFoundException {
        StudentRepository.retrieveAllStudentsByAge(-1);
    }


}