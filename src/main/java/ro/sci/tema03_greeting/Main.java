package ro.sci.tema03_greeting;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String nameFormatted = "";


        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("Hello, stranger.");
        } else {
            //System.out.println("Hello, " + name.trim() + "!");

            String[] nameSplit = name.split(" ");
            for (String word : nameSplit) {
                if (!word.isEmpty()) {
                    String firstLetter = word.substring(0, 1);
                    String remainingLetters = word.substring(1);
                    nameFormatted += firstLetter.toUpperCase() + remainingLetters.toLowerCase() + " ";
                }
            }
            System.out.println("Hello, " + nameFormatted.trim() + "!");
        }

        scanner.close();

    }
}
