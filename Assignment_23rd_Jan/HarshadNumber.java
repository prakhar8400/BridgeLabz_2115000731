import java.util.Scanner;

public class HarshadNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int originalNumber = number;
        int sumOfDigits = 0;

        while (originalNumber > 0) {
            int digit = originalNumber % 10;
            sumOfDigits += digit;
            originalNumber /= 10;
        }

        if (number % sumOfDigits == 0) {
            System.out.println(number + " is a Harshad Number.");
        } else {
            System.out.println(number + " is not a Harshad Number.");
        }

        scanner.close();
    }
}
