import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Find the number of digits
        int temp = number;
        int count = 0;
        while (temp > 0) {
            temp /= 10;
            count++;
        }

        // Create an array to store digits
        int[] digits = new int[count];

        // Extract digits and store in array
        temp = number;
        int index = 0;
        while (temp > 0) {
            digits[index] = temp % 10;
            temp /= 10;
            index++;
        }

        // Print the digits in reverse order
        System.out.print("Reversed number: ");
        for (int i = count - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }
        System.out.println();

        scanner.close();
    }
}
