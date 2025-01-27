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

    /**
     * Checks if a number is an Armstrong number.
     *
     * @param number the number to check
     * @return true if the number is an Armstrong number, false otherwise
     */
    public static boolean isArmstrongNumber(int number) {
        int[] digits = extractDigits(number);
        int digitCount = digits.length;
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, digitCount);
        }
        return sum == number;
    }

    /**
     * Finds the largest and second largest elements in the given array.
     *
     * @param arr the array of integers
     * @return an array containing the largest and second largest elements
     */
    public static int[] findLargestTwo(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return new int[]{largest, secondLargest};
    }

    /**
     * Finds the smallest and second smallest elements in the given array.
     *
     * @param arr the array of integers
     * @return an array containing the smallest and second smallest elements
     */
    public static int[] findSmallestTwo(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }
        }

        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        int number = 153; // Example number

        System.out.println("Number of digits: " + countDigits(number));

        int[] digits = extractDigits(number);
        System.out.println("Digits of the number: " + Arrays.toString(digits));

        if (isDuckNumber(number)) {
            System.out.println(number + " is a Duck Number.");
        } else {
            System.out.println(number + " is not a Duck Number.");
        }

        if (isArmstrongNumber(number)) {
            System.out.println(number + " is an Armstrong Number.");
        } else {
            System.out.println(number + " is not an Armstrong Number.");
        }

        int[] largestTwo = findLargestTwo(digits);
        System.out.println("Largest two digits: " + largestTwo[0] + ", " + largestTwo[1]);

        int[] smallestTwo = findSmallestTwo(digits);
        System.out.println("Smallest two digits: " + smallestTwo[0] + ", " + smallestTwo[1]);
    }
}