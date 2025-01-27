import java.util.Scanner;

public class SumOfNaturalNumbersRecursive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        // Validate input
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            // Calculate sum using recursion
            int recursiveSum = calculateSumRecursive(n);

            // Calculate sum using formula
            int formulaSum = calculateSumFormula(n);

            // Compare results
            if (recursiveSum == formulaSum) {
                System.out.println("Both calculations match.");
                System.out.println("Sum of first " + n + " natural numbers: " + recursiveSum);
            } else {
                System.out.println("Results do not match.");
            }
        }

        scanner.close();
    }

    /**
     * Calculates the sum of the first n natural numbers using recursion.
     *
     * @param n the number of natural numbers to sum
     * @return the sum of the first n natural numbers
     */
    public static int calculateSumRecursive(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + calculateSumRecursive(n - 1);
        }
    }

    /**
     * Calculates the sum of the first n natural numbers using the formula: n*(n+1)/2
     *
     * @param n the number of natural numbers to sum
     * @return the sum of the first n natural numbers
     */
    public static int calculateSumFormula(int n) {
        return (n * (n + 1)) / 2;
    }
}