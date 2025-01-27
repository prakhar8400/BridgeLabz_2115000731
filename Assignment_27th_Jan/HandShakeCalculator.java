import java.util.Scanner;
    public class HandshakeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of students from the user
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // Validate the input
        if (numStudents < 0) {
            System.out.println("Invalid input. Number of students cannot be negative.");
        } else {
            // Calculate the maximum number of handshakes
            int maxHandshakes = calculateHandshakes(numStudents);

            // Display the result
            System.out.println("Maximum number of handshakes: " + maxHandshakes);
        }

        scanner.close();
    }

    /**
     * Calculates the maximum number of handshakes possible among a given number of people.
     *
     * @param n the number of people
     * @return the maximum number of handshakes
     */
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
}