package ro.sci.tema06_calculate_price_method;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String priceInput;
        String tvaInput;

        int tva = 0;
        double price = 0;

        boolean var1 = false;
        boolean var2 = false;

        System.out.print("Enter product price: ");
        while (!var1) {
            try {
                priceInput = scanner.nextLine();
                price = Double.parseDouble(priceInput);
                if (price < 0.001) {
                    System.out.print("The price should be greater than 0!\nPlease try again: ");
                } else {
                    var1 = true;
                }
            } catch (NumberFormatException e) {
                System.out.print("Error - You should enter a number!\nPlease try again: ");
            }
        }

        System.out.print("Enter tva: ");
        while (!var2) {
            try {
                tvaInput = scanner.nextLine();
                tva = Integer.parseInt(tvaInput);
                if (tva < 1 || tva > 100) {
                    System.out.print("TVA should be between 1 and 100!\nPlease try again: ");
                } else {
                    var2 = true;
                }
            } catch (NumberFormatException e) {
                System.out.print("Error - You should enter a number!\nPlease try again: ");
            }
        }

        double finalPrice = calculatePrice(tva, price);
        System.out.println("The final price is: " + finalPrice);

    }

    private static double calculatePrice(int tva, double price) {
        return price + ((double) tva / 100) * price;
    }


}
