import java.util.Arrays;

public class NumberChecker {

    /**
     * Finds the count of digits in the given number.
     *
     * @param number the number to find the digit count of
     * @return the number of digits in the number
     */
    public static int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    /**
     * Stores the digits of the given number in an array.
     *
     * @param number the number to extract digits from
     * @return an array containing the digits of the number
     */
    public static int[] extractDigits(int number) {
        int digitCount = countDigits(number);
        int[] digits = new int[digitCount];
        for (int i = digitCount - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    /**
     * Finds the sum of the digits of a number.
     *
     * @param number the number to find the sum of digits for
     * @return the sum of digits
     */
    public static int sumOfDigits(int number) {
        int[] digits = extractDigits(number);
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    /**
     * Finds the sum of the squares of the digits of a number.
     *
     * @param number the number to find the sum of squares of digits for
     * @return the sum of squares of digits
     */
    public static int sumOfSquaresOfDigits(int number) {
        int[] digits = extractDigits(number);
        int sumOfSquares = 0;
        for (int digit : digits) {
            sumOfSquares += Math.pow(digit, 2);
        }
        return sumOfSquares;
    }

    /**
     * Checks if a number is a Harshad number.
     *
     * @param number the number to check
     * @return true if the number is a Harshad number, false otherwise
     */
    public static boolean isHarshadNumber(int number) {
        return number % sumOfDigits(number) == 0;
    }

    /**
     * Finds the frequency of each digit in the number.
     *
     * @param number the number to analyze
     * @return a 2D array where the first column is the digit and the second column is its frequency
     */
    public static int[][] findDigitFrequencies(int number) {
        int[] digits = extractDigits(number);
        int[][] frequencies = new int[10][2]; // 10 possible digits (0-9)

        for (int i = 0; i < digits.length; i++) {
            frequencies[digits[i]][0] = digits[i]; // Set digit in the first column
            frequencies[digits[i]][1]++;         // Increment frequency count
        }

        return frequencies;
    }

    public static void main(String[] args) {
        int number = 153; // Example number

        System.out.println("Number of digits: " + countDigits(number));

        int[] digits = extractDigits(number);
        System.out.println("Digits of the number: " + Arrays.toString(digits));

        System.out.println("Sum of digits: " + sumOfDigits(number));
        System.out.println("Sum of squares of digits: " + sumOfSquaresOfDigits(number));

        if (isHarshadNumber(number)) {
            System.out.println(number + " is a Harshad number.");
        } else {
            System.out.println(number + " is not a Harshad number.");
        }

        int[][] digitFrequencies = findDigitFrequencies(number);
        System.out.println("Digit Frequencies:");
        for (int[] freq : digitFrequencies) {
            if (freq[1] > 0) { // Print only digits that appear in the number
                System.out.println("Digit " + freq[0] + ": " + freq[1] + " times");
            }
        }
    }
}