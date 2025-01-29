import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateComparison {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDate date1 = getDateInput(scanner, "first");
        LocalDate date2 = getDateInput(scanner, "second");

        if (date1 != null && date2 != null) { // Proceed only if both date inputs are valid
            compareDates(date1, date2);
        }

        scanner.close();
    }

    /**
     * Gets a valid date input from the user.
     * Handles invalid date formats and prompts again until a valid date is entered.
     *
     * @param scanner The Scanner object for reading input.
     * @param order   "first" or "second" to indicate which date is being input.
     * @return The LocalDate object representing the input date, or null if input is invalid after multiple tries.
     */
    public static LocalDate getDateInput(Scanner scanner, String order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Define the expected date format
        int attempts = 3; // Allow a few attempts for correct input

        while (attempts > 0) {
            System.out.print("Enter the " + order + " date in yyyy-MM-dd format (e.g., 2023-10-26): ");
            String dateString = scanner.nextLine();

            try {
                return LocalDate.parse(dateString, formatter); // Parse the date string into LocalDate
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                attempts--;
                if (attempts == 0) {
                    System.out.println("Too many invalid attempts. Exiting.");
                    return null; // Return null to indicate failure
                }
            }
        }
        return null; // Should not happen if attempts is handled correctly
    }

    /**
     * Compares two LocalDate objects and prints the result.
     *
     * @param date1 The first LocalDate.
     * @param date2 The second LocalDate.
     */
    public static void compareDates(LocalDate date1, LocalDate date2) {
        if (date1.isBefore(date2)) {
            System.out.println(date1 + " is before " + date2);
        } else if (date1.isAfter(date2)) {
            System.out.println(date1 + " is after " + date2);
        } else {
            System.out.println(date1 + " is the same as " + date2);
        }
    }
}