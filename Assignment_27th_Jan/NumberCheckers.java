import java.util.Scanner;

public class NumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // Get user input for 5 numbers
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Check and print for each number
        for (int i = 0; i < 5; i++) {
            if (isPositive(numbers[i])) {
                if (isEven(numbers[i])) {
                    System.out.println(numbers[i] + " is positive and even.");
                } else {
                    System.out.println(numbers[i] + " is positive and odd.");
                }
            } else if (isPositive(numbers[i]) == 0) {
                System.out.println(numbers[i] + " is zero.");
            } else {
                System.out.println(numbers[i] + " is negative.");
            }
        }

        // Compare first and last elements
        int comparisonResult = compare(numbers[0], numbers[4]);
        if (comparisonResult == 1) {
            System.out.println("First element is greater than the last element.");
        } else if (comparisonResult == 0) {
            System.out.println("First and last elements are equal.");
        } else {
            System.out.println("First element is less than the last element.");
        }

        scanner.close();
    }

    /**
     * Checks if a number is positive.
     *
     * @param number the number to check
     * @return 1 if positive, 0 if zero, -1 if negative
     */
    public static int isPositive(int number) {
        if (number > 0) {
            return 1; // Positive
        } else if (number == 0) {
            return 0; // Zero
        } else {
            return -1; // Negative
        }
    }

    /**
     * Checks if a number is even.
     *
     * @param number the number to check
     * @return true if even, false otherwise
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Compares two numbers.
     *
     * @param number1 the first number
     * @param number2 the second number
     * @return 1 if number1 > number2, 0 if number1 == number2, -1 if number1 < number2
     */
    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }
}

