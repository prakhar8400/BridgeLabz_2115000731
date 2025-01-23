import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        // Method 1: Multiple if-else statements
        if (year < 1582) {
            System.out.println("Year must be greater than or equal to 1582 (Gregorian Calendar).");
        } else if (year % 4 != 0) {
            System.out.println("Not a Leap Year.");
        } else if (year % 100 != 0) {
            System.out.println("Leap Year.");
        } else if (year % 400 == 0) {
            System.out.println("Leap Year.");
        } else {
            System.out.println("Not a Leap Year.");
        }

        // Method 2: Single if statement with logical operators
        if ((year >= 1582) && 
            ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
            System.out.println("Leap Year.");
        } else {
            System.out.println("Not a Leap Year.");
        }

        scanner.close();
    }
}
