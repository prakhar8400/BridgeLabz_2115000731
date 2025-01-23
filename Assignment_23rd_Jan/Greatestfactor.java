import java.util.Scanner;

public class GreatestFactor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Initialize greatestFactor
        int greatestFactor = 1;

        // Find the greatest factor
        for (int i = number - 1; i > 1; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break; // Exit the loop once a factor is found
            }
        }

        // Display the result
        System.out.println("The greatest factor of " + number + " is " + greatestFactor);

        scanner.close();
    }
}
