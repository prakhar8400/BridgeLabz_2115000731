
import java.util.Scanner;

public class SumOfNumbersWithBreak {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        double number;

        // Get user input until 0 or a negative number is entered
        while (true) { 
            System.out.print("Enter a number (enter 0 or a negative number to stop): ");
            number = scanner.nextDouble();

            if (number <= 0) {
                break; // Exit the loop if 0 or a negative number is entered
            }

            total += number;
        }

        // Display the total
        System.out.println("The sum of the entered numbers is: " + total);

        scanner.close();
    }
}

