public class NumberChecker {

    /**
     * Checks if a number is prime.
     *
     * @param number the number to check
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a number is a neon number.
     *
     * @param number the number to check
     * @return true if the number is a neon number, false otherwise
     */
    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int sumOfDigits = 0;
        while (square > 0) {
            sumOfDigits += square % 10;
            square /= 10;
        }
        return sumOfDigits == number;
    }

    /**
     * Checks if a number is a spy number.
     *
     * @param number the number to check
     * @return true if the number is a spy number, false otherwise
     */
    public static boolean isSpyNumber(int number) {
        int sumOfDigits = 0;
        int productOfDigits = 1;
        int temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sumOfDigits += digit;
            productOfDigits *= digit;
            temp /= 10;
        }
        return sumOfDigits == productOfDigits;
    }

    /**
     * Checks if a number is an automorphic number.
     *
     * @param number the number to check
     * @return true if the number is an automorphic number, false otherwise
     */
    public static boolean isAutomorphicNumber(int number) {
        int square = number * number;
        int lastDigits = square % (int) Math.pow(10, String.valueOf(number).length());
        return lastDigits == number;
    }

    /**
     * Checks if a number is a buzz number.
     *
     * @param number the number to check
     * @return true if the number is a buzz number, false otherwise
     */
    public static boolean isBuzzNumber(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static void main(String[] args) {
        int number = 25; // Example number

        System.out.println("Is Prime: " + isPrime(number));
        System.out.println("Is Neon: " + isNeonNumber(number));
        System.out.println("Is Spy: " + isSpyNumber(number));
        System.out.println("Is Automorphic: " + isAutomorphicNumber(number));
        System.out.println("Is Buzz: " + isBuzzNumber(number));
    }
}