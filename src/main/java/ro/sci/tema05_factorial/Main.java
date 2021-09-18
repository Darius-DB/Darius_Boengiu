package ro.sci.tema05_factorial;


import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        NumberFormat formatter = new DecimalFormat();
        formatter = new DecimalFormat("0.#########E0");

        BigInteger valueToCompareWith = BigInteger.valueOf(Long.MAX_VALUE);

        long number = 0;
        String userInput;
        boolean var = false;

        System.out.print("Enter a number: ");
        while (!var) {
            try {
                userInput = scanner.nextLine();
                number = Long.parseLong(userInput);
                if (number < 0) {
                    System.out.print("You should enter a number greater than or equal to zero!\n" +
                            "Please try again: ");
                } else {
                    var = true;
                }
            } catch (NumberFormatException e) {
                System.out.print("Error - You should enter a number!\nPlease try again: ");
            }
        }


        BigInteger prod = BigInteger.ONE;
        for (int i = 1; i <= number; i++) {
            prod = prod.multiply(BigInteger.valueOf(i));
        }

        if (prod.compareTo(valueToCompareWith) == 1) {
            System.out.println(number + "! = " + formatter.format(prod));
        } else {
            System.out.println(number + "! = " + prod);
        }


    }

//    public static long factorial(long n) {
//        if (n <= 1) {
//            return 1;
//        }
//        return n * factorial(n-1);
//    }

}
