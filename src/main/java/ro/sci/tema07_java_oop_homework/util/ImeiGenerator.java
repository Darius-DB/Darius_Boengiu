package ro.sci.tema07_java_oop_homework.util;

import org.apache.commons.math3.random.RandomDataGenerator;

public class ImeiGenerator {

    public static long imeiGenerator() {
        long leftLimit = 10_000_000_000L;
        long rightLimit = 99_999_999_999L;
        return new RandomDataGenerator().nextLong(leftLimit, rightLimit);
    }
}
