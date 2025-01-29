import java.util.Scanner;

public class FactorialRecursive {

    public static void main(String args) {
        int number = getInput(); // Get input from the user
        long factorial = calculateFactorial(number); // Calculate factorial

        displayResult(number, factorial); // Display the result
    }

    /**
     * Gets a non-negative integer input from the user.
     * Handles invalid input (non-integer or negative numbers) gracefully.
     *
     * @return The non-negative integer input from the user.
     */
    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        int number;

        while (true) {
            System.out.print("Enter a non-negative integer: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number >= 0) {
                    break; // Valid input, exit the loop
                } else {
                    System.out.println("Please enter a non-negative integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Consume the invalid input
            }
        }
        return number;
    }

    /**
     * Calculates the factorial of a non-negative integer using recursion.
     *
     * @param n The non-negative integer.
     * @return The factorial of n.
     */
    public static long calculateFactorial(int n) {
        // Base case: factorial of 0 is 1
        if (n == 0) {
            return 1;
        } else {
            // Recursive step: n! = n * (n-1)!
            return n * calculateFactorial(n - 1);
        }
    }

    /**
     * Displays the result to the user.
     *
     * @param number    The original number.
     * @param factorial The calculated factorial.
     */
    public static void displayResult(int number, long factorial) {
        System.out.println("The factorial of " + number + " is: " + factorial);
    }
}