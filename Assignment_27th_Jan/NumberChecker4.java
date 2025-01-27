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
     * Reverses the order of elements in the given array.
     *
     * @param arr the array to reverse
     */
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Checks if two integer arrays are equal.
     *
     * @param arr1 the first array
     * @param arr2 the second array
     * @return true if the arrays are equal, false otherwise
     */
    public static boolean arraysAreEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if a number is a palindrome.
     *
     * @param number the number to check
     * @return true if the number is a palindrome, false otherwise
     */
    public static boolean isPalindrome(int number) {
        int[] originalDigits = extractDigits(number);
        int[] reversedDigits = Arrays.copyOf(originalDigits, originalDigits.length);
        reverseArray(reversedDigits);
        return arraysAreEqual(originalDigits, reversedDigits);
    }

    /**
     * Checks if a number is a duck number.
     *
     * @param number the number to check
     * @return true if the number is a duck number, false otherwise
     */
    public static boolean isDuckNumber(int number) {
        int[] digits = extractDigits(number);
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 121; // Example number

        System.out.println("Is Palindrome: " + isPalindrome(number));
        System.out.println("Is Duck Number: " + isDuckNumber(number));
    }
}