package ro.sci.tema07_java_oop_homework.util;

public class CheckPhoneNumber {
    public static boolean
    onlyDigits(String str) {
        // Traverse the string from
        // start to end
        for (int i = 0; i < str.length(); i++) {

            // Check if character is
            // digit from 0-9
            // then return true
            // else false
            if (str.charAt(i) >= '0'
                    && str.charAt(i) <= '9') {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
