import java.util.Scanner;
public class HandshakeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of students from the user
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        // Validate the input
        if (numberOfStudents < 0) {
            System.out.println("Invalid input. Number of students cannot be negative.");
        } else {
            // Calculate the maximum number of handshakes
            int maxHandshakes = calculateHandshakes(numberOfStudents);

            // Display the result
            System.out.println("Maximum number of handshakes: " + maxHandshakes);
        }

        scanner.close();
    }

    /**
     * Calculates the maximum number of handshakes possible among a given number of people.
     *
     * @param numberOfStudents the number of students
     * @return the maximum number of handshakes
     */
    public static int calculateHandshakes(int numberOfStudents) {
        // Formula for calculating the number of handshakes: n * (n - 1) / 2
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }
}