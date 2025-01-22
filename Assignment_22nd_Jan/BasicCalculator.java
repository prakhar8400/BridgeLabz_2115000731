package Assignment_21st_January;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double number1 = input.nextDouble();
        System.out.print("Enter second number: ");
        double number2 = input.nextDouble();
        System.out.println("Addition: " + (number1 + number2) +
                "\nSubtraction: " + (number1 - number2) +
                "\nMultiplication: " + (number1 * number2) +
                "\nDivision: " + (number1 / number2));
        input.close();
    }
}