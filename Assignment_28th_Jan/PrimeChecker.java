import java.util.Scanner;

public class PrimeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        scanner.close();
    }

    /**
     * Checks if a given number is prime.
     * A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
     *
     * @param num The number to check for primality.
     * @return true if the number is prime, false otherwise.
     */
    public static boolean isPrime(int num) {
        // Handle edge cases: numbers less than or equal to 1 are not prime
        if (num <= 1) {
            return false;
        }

        // Optimization: Check divisibility only up to the square root of the number
        // If a number has a divisor greater than its square root, it must also have a divisor smaller than its square root.
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // Found a divisor, so the number is not prime
            }
        }

        return true; // No divisors found, so the number is prime
    }
}