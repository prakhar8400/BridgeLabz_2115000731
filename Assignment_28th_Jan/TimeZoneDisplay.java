import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeZoneDisplay {

    public static void main(String[] args) {
        // Get the current time in the system's default time zone
        ZonedDateTime currentTime = ZonedDateTime.now();

        // Define the desired time zones
        ZoneId gmtZone = ZoneId.of("GMT");
        ZoneId istZone = ZoneId.of("Asia/Kolkata"); // IST is usually Asia/Kolkata
        ZoneId pstZone = ZoneId.of("America/Los_Angeles"); // PST is usually America/Los_Angeles

        // Convert the current time to the specified time zones
        ZonedDateTime gmtTime = currentTime.withZoneSameInstant(gmtZone);
        ZonedDateTime istTime = currentTime.withZoneSameInstant(istZone);
        ZonedDateTime pstTime = currentTime.withZoneSameInstant(pstZone);

        // Format the time for display (optional, but recommended)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"); // Customize format as needed

        String formattedGmtTime = gmtTime.format(formatter);
        String formattedIstTime = istTime.format(formatter);
        String formattedPstTime = pstTime.format(formatter);


        // Display the time in each time zone
        System.out.println("Current Time in GMT: " + formattedGmtTime);
        System.out.println("Current Time in IST: " + formattedIstTime);
        System.out.println("Current Time in PST: " + formattedPstTime);

        //More concise way to display:
        /*
        displayTime(currentTime, gmtZone, "GMT");
        displayTime(currentTime, istZone, "IST");
        displayTime(currentTime, pstZone, "PST");

        */

    }

    //Helper function to display the time.
    public static void displayTime(ZonedDateTime currentTime, ZoneId zone, String zoneName){
        ZonedDateTime time = currentTime.withZoneSameInstant(zone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        String formattedTime = time.format(formatter);
        System.out.println("Current Time in " + zoneName + ": " + formattedTime);
    }
}