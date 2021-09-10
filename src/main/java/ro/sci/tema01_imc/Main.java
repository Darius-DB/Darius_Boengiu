package ro.sci.tema01_imc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Declaring variables for storing user input
        String massInput;
        String heightInput;

        //Initializing variables that will store user input after parsing
        double mass = 1;
        double height = 1;

        double result; //variable for storing BMI value

        boolean var1 = false;
        boolean var2 = false;

        System.out.print("Height (cm): ");
        //Checking if user input is of valid format
        while (!var1) {
            try {
                heightInput = scanner.nextLine();
                height = Double.parseDouble(heightInput);

                if (height > 0 ) {
                    var1 = true;
                } else {
                    System.out.print("Height can't be less than 1cm\nPlease enter a valid height: ");
                }

            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid height: ");
            }

        }

        System.out.print("Mass (kg): ");
        //Checking if user input is of valid format
        while (!var2) {
            try {
                massInput = scanner.nextLine();
                mass = Double.parseDouble(massInput);

                if (mass > 0 ) {
                    var2 = true;
                } else {
                    System.out.print("Mass can't be less than 1Kg\nPlease enter a valid mass: ");
                }

            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid mass: ");
            }

        }

        double heightInMetres = height / 100;
        result = mass / (heightInMetres * heightInMetres);

        String resultFormatted = String.format("%.2f",result);

        if (result >= 18.5 && result <= 24.9) {
            System.out.println("IMC = " + resultFormatted + " (Greutate normala - Fara risc de boala)");
        } else if (result >= 25 && result <= 29.9) {
            System.out.println("IMC = " + resultFormatted + " (Supraponderal)");
        } else if (result >= 30 && result <= 34.9) {
            System.out.println("IMC = " + resultFormatted + " (Obezitate Grad 1)");
        } else if (result >= 35 && result <= 39.9) {
            System.out.println("IMC = " + resultFormatted + " (Obezitate Grad 2)");
        } else if (result >=40) {
            System.out.println("IMC = " + resultFormatted + " (Obezitate Morbida)");
        } else {
            System.out.println("IMC = " + resultFormatted + " (Subponderal)");
        }


    }
}
