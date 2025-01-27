import java.util.Scanner;

public class LeapYearChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        // Check if the year is valid for Gregorian calendar
        if (year < 1582) {
            System.out.println("Invalid year. Leap year rules apply from 1582 onwards.");
        } else {
            // Check if it's a leap year
            if (isLeapYear(year)) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is not a leap year.");
            }
        }

        scanner.close();
    }

    /**
     * Checks if a given year is a leap year.
     *
     * @param year the year to check
     * @return true if the year is a leap year, false otherwise
     */
    public static boolean isLeapYear(int year) {
        // Leap year conditions:
        // 1. Divisible by 4
        // 2. Not divisible by 100
        // 3. Or divisible by 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}