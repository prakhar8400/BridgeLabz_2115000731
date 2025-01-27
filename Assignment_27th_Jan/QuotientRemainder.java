import java.util.Scanner;

public class QuotientRemainder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the dividend: ");
        int dividend = scanner.nextInt();
        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        // Validate divisor (should not be zero)
        if (divisor == 0) {
            System.out.println("Error: Division by zero is not allowed.");
        } else {
            // Calculate quotient and remainder
            int[] result = findRemainderAndQuotient(dividend, divisor);

            // Display the result
            System.out.println("Quotient: " + result[0]);
            System.out.println("Remainder: " + result[1]);
        }

        scanner.close();
    }

    /**
     * Calculates the quotient and remainder of two integers.
     *
     * @param dividend the number to be divided
     * @param divisor the number to divide by
     * @return an array containing the quotient at index 0 and remainder at index 1
     */
    public static int[] findRemainderAndQuotient(int dividend, int divisor) {
        int[] result = new int[2];
        result[0] = dividend / divisor; // Calculate quotient
        result[1] = dividend % divisor; // Calculate remainder
        return result;
    }
}