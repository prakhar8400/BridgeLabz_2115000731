import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { // Main loop to keep the calculator running
            System.out.println("\nBasic Calculator Menu");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            if (scanner.hasNextInt()) { // Check if input is an integer
                int choice = scanner.nextInt();

                if (choice >= 1 && choice <= 4) { // Check if choice is within valid range
                    System.out.print("Enter the first number: ");
                    double num1 = getValidDoubleInput(scanner); // Get valid double input

                    System.out.print("Enter the second number: ");
                    double num2 = getValidDoubleInput(scanner); // Get valid double input

                    double result = 0; // Initialize result

                    switch (choice) {
                        case 1:
                            result = add(num1, num2);
                            System.out.println("Result: " + result);
                            break;
                        case 2:
                            result = subtract(num1, num2);
                            System.out.println("Result: " + result);
                            break;
                        case 3:
                            result = multiply(num1, num2);
                            System.out.println("Result: " + result);
                            break;
                        case 4:
                            if (num2 == 0) {
                                System.out.println("Cannot divide by zero.");
                            } else {
                                result = divide(num1, num2);
                                System.out.println("Result: " + result);
                            }
                            break;
                    }
                } else if (choice == 5) {
                    System.out.println("Exiting calculator. Goodbye!");
                    scanner.close(); // Close the scanner resource
                    return; // Exit the program
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Consume invalid input
            }
        }
    }

    /**
     * Adds two numbers.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The sum of a and b.
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts two numbers.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The difference between a and b.
     */
    public static double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The product of a and b.
     */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides two numbers.
     *
     * @param a The first number (dividend).
     * @param b The second number (divisor).
     * @return The quotient of a and b.
     */
    public static double divide(double a, double b) {
        return a / b;
    }

