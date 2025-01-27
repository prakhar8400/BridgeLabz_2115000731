import java.util.Arrays;

public class NumberChecker {

    /**
     * Finds the factors of a given number.
     *
     * @param number the number to find factors of
     * @return an array containing the factors of the number
     */
    public static int[] findFactors(int number) {
        int count = 0; 
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    /**
     * Finds the greatest common divisor (GCD) of two numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the GCD of the two numbers
     */
    public static int findGCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        return num1;
    }

    /**
     * Finds the sum of the factors of a number.
     *
     * @param number the number to find the sum of factors for
     * @return the sum of factors
     */
    public static int sumOfFactors(int number) {
        int[] factors = findFactors(number);
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    /**
     * Finds the product of the factors of a number.
     *
     * @param number the number to find the product of factors for
     * @return the product of factors
     */
    public static int productOfFactors(int number) {
        int[] factors = findFactors(number);
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    /**
     * Finds the product of the cubes of the factors of a number.
     *
     * @param number the number to find the product of cubes of factors for
     * @return the product of cubes of factors
     */
    public static int productOfCubesOfFactors(int number) {
        int[] factors = findFactors(number);
        int product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    /**
     * Checks if a number is a perfect number.
     *
     * @param number the number to check
     * @return true if the number is perfect, false otherwise
     */
    public static boolean isPerfectNumber(int number) {
        return number == sumOfFactors(number);
    }

    /**
     * Checks if a number is an abundant number.
     *
     * @param number the number to check
     * @return true if the number is abundant, false otherwise
     */
    public static boolean isAbundantNumber(int number) {
        return sumOfFactors(number) > number;
    }

    /**
     * Checks if a number is a deficient number.
     *
     * @param number the number to check
     * @return true if the number is deficient, false otherwise
     */
    public static boolean isDeficientNumber(int number) {
        return sumOfFactors(number) < number;
    }

    /**
     * Checks if a number is a strong number.
     *
     * @param number the number to check
     * @return true if the number is a strong number, false otherwise
     */
    public static boolean isStrongNumber(int number) {
        int originalNumber = number;
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            int factorial = 1;
            for (int i = 1; i <= digit; i++) {
                factorial *= i;
            }
            sum += factorial;
            number /= 10;
        }
        return sum == originalNumber;
    }

    public static void main(String[] args) {
        int number = 6; // Example number

        int[] factors = findFactors(number);
        System.out.println("Factors of " + number + ": " + Arrays.toString(factors));

        System.out.println("Sum of factors: " + sumOfFactors(number));
        System.out.println("Product of factors: " + productOfFactors(number));
        System.out.println("Product of cubes of factors: " + productOfCubesOfFactors(number));

        System.out.println("Is Perfect: " + isPerfectNumber(number));
        System.out.println("Is Abundant: " + isAbundantNumber(number));
        System.out.println("Is Deficient: " + isDeficientNumber(number));
        System.out.println("Is Strong: " + isStrongNumber(number));
    }
}