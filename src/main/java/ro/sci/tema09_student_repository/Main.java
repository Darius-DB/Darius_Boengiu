package ro.sci.tema09_student_repository;


import ro.sci.tema09_student_repository.exceptions.MissingNameException;
import ro.sci.tema09_student_repository.exceptions.StudentNotFoundException;
import ro.sci.tema09_student_repository.student.StudentRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) throws IOException {

        //Setting up logger file
        Logger logger  = Logger.getLogger(Main.class.getName());
        FileHandler fh;
        try {
            // This block configure the logger with handler and formatter
            fh = new FileHandler("C:/Users/ALEX/Desktop/Darius_Boengiu/exceptions.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }

        //Adding students to repository
        try {
            StudentRepository.addStudent("John", "Smith", "M", LocalDate.of(1996, 10, 11));
            logger.log(Level.INFO, "Student added successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), new Exception());
        }

        //Adding students to repository
        try {
            StudentRepository.addStudent("John", "Foe", "M", LocalDate.of(1996, 2, 27));
            logger.log(Level.INFO, "Student added successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), new Exception());
        }

        //Adding students to repository
        try {
            StudentRepository.addStudent("Sam", "Doe", "M", LocalDate.of(1996, 5, 18));
            logger.log(Level.INFO, "Student added successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), new Exception());
        }

        //Adding students to repository
        try {
            StudentRepository.addStudent("John", "Doe", "h", LocalDate.of(1997, 2, 27));
            logger.log(Level.INFO, "Student added successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), new Exception());
        }

        //Adding students to repository
        try {
            StudentRepository.addStudent("     ", "Doe", "M", LocalDate.of(1997, 2, 27));
            logger.log(Level.INFO, "Student added successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), new Exception());
        }

        //Adding students to repository
        try {
            StudentRepository.addStudent("John", "    ", "M", LocalDate.of(1997, 2, 27));
            logger.log(Level.INFO, "Student added successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), new Exception());
        }

        //Adding students to repository
        try {
            StudentRepository.addStudent("John", "Doe", "M", LocalDate.of(1897, 2, 27));
            logger.log(Level.INFO, "Student added successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), new Exception());
        }

        //Deleting students by ID(CNP)
        try {
            StudentRepository.deleteStudentByCnp("1961011");
            logger.log(Level.INFO, "Student deleted successfully");
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), new StudentNotFoundException(e.getMessage()));
        }

        //Deleting students by ID(CNP)
        try {
            StudentRepository.deleteStudentByCnp("1950909");
            logger.log(Level.INFO, "Student deleted successfully");
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), new StudentNotFoundException(e.getMessage()));
        }

        //Deleting students by ID(CNP)
        try {
            StudentRepository.deleteStudentByCnp("1950909");
            logger.log(Level.INFO, "Student deleted successfully");
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), new StudentNotFoundException(e.getMessage()));
        }

        //Retrieving students by age
        try {
            StudentRepository.retrieveAllStudentsByAge(25);
            logger.log(Level.INFO, "Student retrieved successfully");
        } catch (IllegalArgumentException | StudentNotFoundException e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), new Exception());
        }

        //Retrieving students by age
        try {
            StudentRepository.retrieveAllStudentsByAge(32);
            logger.log(Level.INFO, "Student retrieved successfully");
        } catch (IllegalArgumentException | StudentNotFoundException e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), new Exception());
        }

        //Retrieving students by age
        try {
            StudentRepository.retrieveAllStudentsByAge(-1);
            logger.log(Level.INFO, "Student retrieved successfully");
        } catch (IllegalArgumentException | StudentNotFoundException e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), new Exception());
        }

        //Sorting students by last name
        try {
            StudentRepository.sortStudentsByLastName();
            logger.log(Level.INFO, "Students sorted successfully");
        } catch (MissingNameException e) {
            System.out.println(e.getMessage());
            logger.log(Level.SEVERE, e.getMessage(), new NullPointerException());
        }

//        StudentRepository.printStudents();


    }
}
