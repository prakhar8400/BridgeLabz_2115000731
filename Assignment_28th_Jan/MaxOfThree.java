import java.util.Scanner;

public class MaxOfThree {

    public static void main(String[] args) {
        // Get input from the user
        int num1 = getInput("Enter the first number: ");
        int num2 = getInput("Enter the second number: ");
        int num3 = getInput("Enter the third number: ");

        // Calculate the maximum
        int max = findMax(num1, num2, num3);

        // Display the result
        System.out.println("The maximum of " + num1 + ", " + num2 + ", and " + num3 + " is: " + max);
    }

    /**
     * Gets an integer input from the user with a given prompt.
     * This function handles potential non-integer input by using a loop and scanner.hasNextInt().
     * @param prompt The message to display to the user.
     * @return The integer input from the user.
     */
    public static int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }

    /**
     * Finds the maximum of three integers.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @param c The third integer.
     * @return The largest of the three integers.
     */
    public static int findMax(int a, int b, int c) {
        // Efficient way using Math.max() (cleaner)
        return Math.max(Math.max(a, b), c);

        // Alternative way using if-else (more explicit)
        /*
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
        */
    }
}