package ro.sci.tema09_student_repository.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CnpGenerator {

    public static String cnpGenerator(String gender, LocalDate dateOfBirth) {
        String cnp = "";

        if (gender.equalsIgnoreCase("m")) {
            cnp += "1";
        } else if (gender.equalsIgnoreCase("f")) {
            cnp += "2";
        }

        String formattedDate = dateOfBirth.format(DateTimeFormatter.ofPattern("yyMMdd"));
        cnp += formattedDate;

        return cnp;
    }
}
