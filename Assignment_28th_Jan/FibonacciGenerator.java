import java.util.Scanner;

public class FibonacciGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms for the Fibonacci sequence: ");
        int numTerms = scanner.nextInt();

        if (numTerms <= 0) {
            System.out.println("Please enter a positive integer for the number of terms.");
        } else {
            generateFibonacci(numTerms);
        }

        scanner.close();
    }

    /**
     * Generates and prints the Fibonacci sequence up to the specified number of terms.
     * The Fibonacci sequence is a series of numbers in which each number is the sum of the two preceding ones,
     * typically starting with 0 and 1.
     *
     * @param n The number of terms to generate.
     */
    public static void generateFibonacci(int n) {
        int firstTerm = 0;
        int secondTerm = 1;

        System.out.println("Fibonacci Sequence:");

        for (int i = 1; i <= n; i++) {
            System.out.print(firstTerm + " ");

            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
        System.out.println(); // Add a newline at the end
    }
}