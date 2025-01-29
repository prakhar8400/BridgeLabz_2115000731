import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateArithmetic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDate inputDate = getDateInput(scanner); // Get a valid date input from user

        if (inputDate != null) { // Proceed only if date input is valid
            LocalDate modifiedDate = performDateArithmetic(inputDate);
            displayResult(inputDate, modifiedDate);
        }

        scanner.close();
    }

    /**
     * Gets a valid date input from the user.
     * Handles invalid date formats and prompts again until a valid date is entered.
     *
     * @param scanner The Scanner object for reading input.
     * @return The LocalDate object representing the input date, or null if input is invalid after multiple tries.
     */
    public static LocalDate getDateInput(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Define the expected date format
        int attempts = 3; // Allow a few attempts for correct input

        while (attempts > 0) {
            System.out.print("Enter date in yyyy-MM-dd format (e.g., 2023-10-26): ");
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
     * Performs date arithmetic: adds 7 days, 1 month, 2 years, then subtracts 3 weeks.
     *
     * @param date The initial LocalDate.
     * @return The modified LocalDate after performing the arithmetic.
     */
    public static LocalDate performDateArithmetic(LocalDate date) {
        return date.plusDays(7)
                .plusMonths(1)
                .plusYears(2)
                .minusWeeks(3);
    }

    /**
     * Displays the original and modified dates to the user.
     *
     * @param originalDate The original LocalDate.
     * @param modifiedDate The modified LocalDate.
     */
    public static void displayResult(LocalDate originalDate, LocalDate modifiedDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Original Date: " + originalDate.format(formatter));
        System.out.println("Modified Date: " + modifiedDate.format(formatter));
    }
}