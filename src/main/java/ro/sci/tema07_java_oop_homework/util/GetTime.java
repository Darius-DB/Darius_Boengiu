package ro.sci.tema07_java_oop_homework.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {
    public static String getCurrentTime (){
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateObj = new Date();
        return df.format(dateObj);
    }
}
