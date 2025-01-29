import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now(); // Get the current date

        // Define the desired date formats
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        // Format the date using the specified patterns
        String formattedDate1 = currentDate.format(formatter1);
        String formattedDate2 = currentDate.format(formatter2);
        String formattedDate3 = currentDate.format(formatter3);

        // Display the formatted dates
        System.out.println("Current Date (dd/MM/yyyy): " + formattedDate1);
        System.out.println("Current Date (yyyy-MM-dd): " + formattedDate2);
        System.out.println("Current Date (EEE, MMM dd, yyyy): " + formattedDate3);
    }
}
