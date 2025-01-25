import java.util.Scanner;

public class MultiplicationTableLimited {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] multiplicationResult = new int[4]; // Array to store results from 6 to 9

        // Calculate and store multiplication results in the array
        for (int i = 0; i < 4; i++) {
            multiplicationResult[i] = number * (i + 6); // Start from 6 to 9
        }

        // Display the multiplication table
        System.out.println("Multiplication Table of " + number + " from 6 to 9:");
        for (int i = 0; i < 4; i++) {
            System.out.println(number + " x " + (i + 6) + " = " + multiplicationResult[i]);
        }

        scanner.close();
    }
}
