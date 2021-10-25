package ro.sci.tema09_student_repository.util;

import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static void dateFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String date = "16/08/2016";
    }

}
