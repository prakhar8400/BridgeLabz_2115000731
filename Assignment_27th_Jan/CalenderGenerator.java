import java.util.Scanner;

public class CalendarGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Invalid month. Please enter a month between 1 and 12.");
        } else {
            displayCalendar(month, year);
        }

        scanner.close();
    }

    /**
     * Displays the calendar for the given month and year.
     *
     * @param month the month (1-12)
     * @param year the year
     */
    public static void displayCalendar(int month, int year) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year)) {
            daysInMonth[1] = 29; // February has 29 days in leap years
        }

        String monthName = months[month - 1];
        int days = daysInMonth[month - 1];

        System.out.println("\n" + monthName + " " + year);
        System.out.println("-----------------------------");
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Calculate the first day of the month
        int firstDay = findFirstDayOfWeek(dayOfWeek(year, month, 1));

        // Print leading spaces before the first day of the month
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        // Print the days of the month
        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);
            if ((day + firstDay) % 7 == 0) {
                System.out.println(); // Move to the next line after Saturday
            }
        }
    }

    /**
     * Checks if a given year is a leap year.
     *
     * @param year the year to check
     * @return true if the year is a leap year, false otherwise
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Calculates the day of the week for the given date using Zeller's congruence.
     *
     * @param year the year
     * @param month the month (1-12)
     * @param day the day of the month
     * @return the day of the week (0 for Sunday, 1 for Monday, ..., 6 for Saturday)
     */
    public static int dayOfWeek(int year, int month, int day) {
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (day + x + 31 * m0 / 12) % 7;
        return d0;
    }
}