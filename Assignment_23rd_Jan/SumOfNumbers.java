import java.util.Scanner;

public class SumOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        double number;

        // Get user input until 0 is entered
        do {
            System.out.print("Enter a number (enter 0 to stop): ");
            number = scanner.nextDouble();
            total += number; 
        } while (number != 0);

        // Display the total
        System.out.println("The sum of the entered numbers is: " + total);

        scanner.close();
    }
}
