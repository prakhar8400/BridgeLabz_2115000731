import java.util.Scanner;

public class NumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Determine the number's sign using the checkNumber method
        int result = checkNumber(number);

        // Display the result based on the return value
        switch (result) {
            case -1:
                System.out.println("The number is negative.");
                break;
            case 0:
                System.out.println("The number is zero.");
                break;
            case 1:
                System.out.println("The number is positive.");
                break;
            default:
                System.out.println("Invalid input.");
        }

        scanner.close();
    }

    /**
     * Checks the sign of an integer.
     *
     * @param num the integer to check
     * @return -1 if the number is negative, 1 if positive, and 0 if zero
     */
    public static int checkNumber(int num) {
        if (num < 0) {
            return -1; // Negative
        } else if (num > 0) {
            return 1; // Positive
        } else {
            return 0; // Zero
        }
    }
}