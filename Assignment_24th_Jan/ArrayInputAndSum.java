import java.util.Scanner;

public class ArrayInputAndSum {

    public static void main(String args) {
        Scanner scanner = new Scanner(System.in);

        double numbers = new double[10]; // Array to store numbers
        double total = 0.0; // Variable to store the sum
        int index = 0; // Index to keep track of array position

        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double num = scanner.nextDouble();

            if (num <= 0) {
                break; // Exit the loop if 0 or negative number is entered
            }

            if (index >= 10) {
                System.out.println("Array is full.");
                break; // Exit the loop if array is full
            }

            numbers[index] = num;
            total += num;
            index++;
        }

        // Display the entered numbers
        System.out.print("Entered numbers: ");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // Display the sum of numbers
        System.out.println("Sum of numbers: " + total);

        scanner.close();
    }
}
