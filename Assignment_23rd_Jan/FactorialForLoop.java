import java.util.Scanner;

public class FactorialForLoop {

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

        // Calculate factorial using for loop
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i; // factorial = factorial * i;
        }

        // Print the factorial
        System.out.println("The factorial of " + number + " is " + factorial);

        scanner.close();
    }
}
