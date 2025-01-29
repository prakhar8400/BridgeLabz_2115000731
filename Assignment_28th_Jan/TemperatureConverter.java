import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { // Outer loop for multiple conversions
            System.out.println("\nTemperature Converter Menu");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            if (scanner.hasNextInt()) { // Check if input is integer
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        double fahrenheit = getTemperatureInput(scanner, "Fahrenheit");
                        double celsius = fahrenheitToCelsius(fahrenheit);
                        displayConversion(fahrenheit, celsius, "Fahrenheit", "Celsius");
                        break;
                    case 2:
                        double celsiusInput = getTemperatureInput(scanner, "Celsius");
                        double fahrenheitResult = celsiusToFahrenheit(celsiusInput);
                        displayConversion(celsiusInput, fahrenheitResult, "Celsius", "Fahrenheit");
                        break;
                    case 3:
                        System.out.println("Exiting program. Goodbye!");
                        scanner.close();
                        return; // Exit the main method
                    default:
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        }
    }

    /**
     * Converts temperature from Fahrenheit to Celsius.
     *
     * @param fahrenheit The temperature in Fahrenheit.
     * @return The temperature in Celsius.
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    /**
     * Converts temperature from Celsius to Fahrenheit.
     *
     * @param celsius The temperature in Celsius.
     * @return The temperature in Fahrenheit.
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    /**
     * Gets temperature input from the user with input validation.
     *
     * @param scanner The Scanner object for reading input.
     * @param unit    The temperature unit ("Fahrenheit" or "Celsius").
     * @return The temperature value as a double.
     */
    public static double getTemperatureInput(Scanner scanner, String unit) {
        double temperature;
        while (true) {
            System.out.print("Enter temperature in " + unit + ": ");
            if (scanner.hasNextDouble()) { // Check for double input
                temperature = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        }
        return temperature;
    }

    /**
     * Displays the converted temperature to the user.
     *
     * @param temperature       The original temperature.
     * @param convertedTemperature The converted temperature.
     * @param fromUnit            The original unit.
     * @param toUnit              The converted unit.
     */
    public static void displayConversion(double temperature, double convertedTemperature, String fromUnit, String toUnit) {
        System.out.printf("%.2f %s is equal to %.2f %s\n", temperature, fromUnit, convertedTemperature, toUnit);
    }
}