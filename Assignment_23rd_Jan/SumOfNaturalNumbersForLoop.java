import java.util.Scanner;

public class SumOfNaturalNumbersForLoop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the number of natural numbers
        System.out.print("Enter the number of natural numbers (n): ");
        int n = scanner.nextInt();

        // Check if the number is a natural number
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            scanner.close();
            return; 
        }

        // Calculate sum using for loop
        int sumForLoop = 0;
        for (int i = 1; i <= n; i++) {
            sumForLoop += i; 
        }

        // Calculate sum using formula
        int sumFormula = (n * (n + 1)) / 2;

        // Compare results
        if (sumForLoop == sumFormula) {
            System.out.println("Both methods produce the same result.");
            System.out.println("Sum of " + n + " natural numbers: " + sumForLoop);
        } else {
            System.out.println("Error: Results from both methods do not match.");
        }

        scanner.close();
    }
}
