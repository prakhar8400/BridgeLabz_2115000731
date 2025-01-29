import java.util.Scanner;

public class GCDLCMCalculator {

    public static void main(String args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd); // Pass the calculated GCD to the LCM function

        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);

        scanner.close();
    }

    /**
     * Calculates the Greatest Common Divisor (GCD) of two integers using the Euclidean algorithm.
     * The Euclidean algorithm is an efficient method for finding the GCD.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The GCD of a and b.
     */
    public static int calculateGCD(int a, int b) {
        // Make sure a and b are non-negative.  Handle negative inputs if needed.
        a = Math.abs(a);
        b = Math.abs(b);

        // Base case: if b is 0, then GCD(a, 0) = a
        if (b == 0) {
            return a;
        }

        // Recursive step: GCD(a, b) = GCD(b, a % b)
        return calculateGCD(b, a % b);

        //Iterative approach (can be slightly more efficient):
        /*
        while (b!= 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
        */
    }

    /**
     * Calculates the Least Common Multiple (LCM) of two integers using the formula:
     * LCM(a, b) = (a * b) / GCD(a, b)
     *
     * @param a   The first integer.
     * @param b   The second integer.
     * @param gcd The GCD of a and b (pre-calculated for efficiency).
     * @return The LCM of a and b.
     */
    public static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}

