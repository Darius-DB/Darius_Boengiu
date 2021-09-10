package ro.sci.tema02_nr_prim;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String numberInput;     //variable used for storing user input
        int number = 1;         //variable used for storing user input after parsing
        String result = null;   //variable used for storing the message that is going to be displayed to the user
        boolean var = false;

        System.out.println("Prime numbers are positive, " +
                "non-zero numbers that have exactly two factors -- no more, no less.");
        System.out.print("Enter a number to see if it's prime: ");

        //Validating user input
        while (!var) {
            try {
                numberInput = scanner.nextLine();
                number = Integer.parseInt(numberInput);
                var = true;
            } catch (NumberFormatException e) {
                System.out.print("Error - you should enter a number!\nPlease try again: " );
            }
        }

        if (number < 0) {
            result = "Only positive numbers could be prime by definition!";
        } else if (number == 0) {
            result = "0 is NOT prime by definition!";
        } else if (number == 1) {
            result = "1 is NOT prime by definition!";
        } else if (number == 2) {
            result = "2 is a prime number.";
        } else {
            for (int i = 2; i < number; i++ ) {
                if (number % i == 0) {
                    result = number + " is NOT a prime number.\nIt is divisible by: " + i + ".";
                    break;
                } else {
                    result = number + " is a prime number.";
                }
            }
        }

        System.out.println(result);

    }
}
