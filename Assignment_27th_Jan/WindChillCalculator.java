import java.util.Scanner;

public class WindChillCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the air temperature (in degrees Celsius): ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the wind speed (in km/h): ");
        double windSpeed = scanner.nextDouble();

        // Validate input (wind speed must be greater than or equal to 2 km/h)
        if (windSpeed < 2) {
            System.out.println("Wind speed must be greater than or equal to 2 km/h.");
        } else {
            // Calculate wind chill
            double windChill = calculateWindChill(temperature, windSpeed);

            // Display the result
            System.out.println("Wind chill temperature: " + windChill + " °C");
        }

        scanner.close();
    }

    /**
     * Calculates the wind chill temperature.
     *
     * @param temperature the air temperature in degrees Celsius
     * @param windSpeed the wind speed in km/h
     * @return the wind chill temperature in degrees Celsius
     */
    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }
}