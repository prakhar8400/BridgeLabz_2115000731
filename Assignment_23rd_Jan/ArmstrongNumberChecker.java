import java.util.Scanner;

public class ArmstrongNumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int originalNumber = number; // Store the original number
        int sum = 0;

        while (originalNumber != 0) { 
            // Extract the last digit
            int lastDigit = originalNumber % 10; 

            // Calculate the cube of the last digit
            sum += Math.pow(lastDigit, 3); 

            // Remove the last digit from the original number
            originalNumber /= 10; 
        }

        // Check if the number is an Armstrong number
        if (number == sum) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }

        scanner.close();
    }
}
