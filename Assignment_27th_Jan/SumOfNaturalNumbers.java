import java.util.Scanner;

public class SumOfNaturalNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        // Validate input
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            // Calculate and display the sum
            int sum = calculateSumOfNaturalNumbers(n);
            System.out.println("Sum of first " + n + " natural numbers: " + sum);
        }

        scanner.close();
    }

    /**
     * Calculates the sum of the first n natural numbers using a loop.
     *
     * @param n the number of natural numbers to sum
     * @return the sum of the first n natural numbers
     */
    public static int calculateSumOfNaturalNumbers(int n) {
        int sum = 0; 
        for (int i = 1; i <= n; i++) {
            sum += i; // Add each number to the sum
        }
        return sum;
    }
}