import java.util.Scanner;

public class FindSmallestAndLargest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        System.out.print("Enter the third number: ");
        int num3 = scanner.nextInt();

        // Find smallest and largest numbers
        int[] result = findSmallestAndLargest(num1, num2, num3);

        // Display the results
        System.out.println("Smallest number: " + result[0]);
        System.out.println("Largest number: " + result[1]);

        scanner.close();
    }

    /**
     * Finds the smallest and largest of three numbers.
     *
     * @param number1 the first number
     * @param number2 the second number
     * @param number3 the third number
     * @return an array containing the smallest and largest numbers (index 0 for smallest, 1 for largest)
     */
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int[] result = new int[2]; // Array to store smallest and largest

        // Find the smallest number
        result[0] = Math.min(Math.min(number1, number2), number3);

        // Find the largest number
        result[1] = Math.max(Math.max(number1, number2), number3);

        return result;
    }
}