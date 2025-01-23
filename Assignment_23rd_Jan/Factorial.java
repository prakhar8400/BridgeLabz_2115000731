import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the number
        System.out.print("Enter a non-negative integer: ");
        int number = scanner.nextInt();

        // Check if the number is non-negative
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            scanner.close();
            return;
        }

        // Calculate factorial
        int factorial = 1;
        int i = 1;
        while (i <= number) {
            factorial *= i; // factorial = factorial * i;
            i++;
        }

        // Print the factorial
        System.out.println("The factorial of " + number + " is " + factorial);

        scanner.close();
    }
}
