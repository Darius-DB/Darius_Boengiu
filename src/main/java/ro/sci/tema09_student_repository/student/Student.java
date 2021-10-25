package ro.sci.tema09_student_repository.student;

import ro.sci.tema09_student_repository.util.CnpGenerator;

import java.time.LocalDate;

public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String cnp;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.cnp = CnpGenerator.cnpGenerator(gender, dateOfBirth);
    }

    public String getCnp() {
        return cnp;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }



    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (!firstName.equals(student.firstName)) return false;
        if (!getLastName().equals(student.getLastName())) return false;
        if (!getDateOfBirth().equals(student.getDateOfBirth())) return false;
        if (!gender.equals(student.gender)) return false;
        return getCnp().equals(student.getCnp());
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getDateOfBirth().hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + getCnp().hashCode();
        return result;
    }
}
