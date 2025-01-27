import java.util.Scanner;

public class FactorAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Find factors of the number
        int[] factors = findFactors(number);

        // Display factors
        System.out.print("Factors of " + number + ": ");
        for (int i = 0; i < factors.length; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();

        // Calculate and display sum of factors
        int sumOfFactors = calculateSumOfFactors(factors);
        System.out.println("Sum of factors: " + sumOfFactors);

        // Calculate and display sum of squares of factors
        int sumOfSquares = calculateSumOfSquaresOfFactors(factors);
        System.out.println("Sum of squares of factors: " + sumOfSquares);

        // Calculate and display product of factors
        int productOfFactors = calculateProductOfFactors(factors);
        System.out.println("Product of factors: " + productOfFactors);

        scanner.close();
    }

    /**
     * Finds the factors of a given number and stores them in an array.
     *
     * @param number the number to find factors of
     * @return an array containing the factors of the number
     */
    public static int[] findFactors(int number) {
        int count = 0; // Count the number of factors
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count]; // Create array to store factors
        int index = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    /**
     * Calculates the sum of all factors in the given array.
     *
     * @param factors the array containing the factors
     * @return the sum of all factors
     */
    public static int calculateSumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    /**
     * Calculates the sum of squares of all factors in the given array.
     *
     * @param factors the array containing the factors
     * @return the sum of squares of all factors
     */
    public static int calculateSumOfSquaresOfFactors(int[] factors) {
        int sumOfSquares = 0;
        for (int factor : factors) {
            sumOfSquares += Math.pow(factor, 2);
        }
        return sumOfSquares;
    }

    /**
     * Calculates the product of all factors in the given array.
     *
     * @param factors the array containing the factors
     * @return the product of all factors
     */
    public static int calculateProductOfFactors(int[] factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }
}