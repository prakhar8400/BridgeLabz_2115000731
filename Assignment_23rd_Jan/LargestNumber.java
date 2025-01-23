import java.util.Scanner;

public class LargestNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the three numbers
        System.out.print("Enter the first number: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = scanner.nextInt();

        System.out.print("Enter the third number: ");
        int number3 = scanner.nextInt();

        // Check if each number is the largest
        boolean isNumber1Largest = (number1 >= number2) && (number1 >= number3);
        boolean isNumber2Largest = (number2 >= number1) && (number2 >= number3);
        boolean isNumber3Largest = (number3 >= number1) && (number3 >= number2);

        // Display the results
        System.out.println("Is the first number the largest? " + isNumber1Largest);
        System.out.println("Is the second number the largest? " + isNumber2Largest);
        System.out.println("Is the third number the largest? " + isNumber3Largest);

        scanner.close();
    }
}
