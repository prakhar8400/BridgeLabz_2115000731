import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        int guess;
        int attempts = 0;

        System.out.println("Think of a number between 1 and 100. I will try to guess it.");

        do {
            guess = generateGuess(attempts); // Generate the computer's guess
            attempts++;

            System.out.println("My guess is: " + guess);

            int feedback = getFeedback(scanner); // Get feedback from the user

            if (feedback == 0) { // Correct guess
                System.out.println("I guessed it in " + attempts + " attempts!");
            } else if (feedback == 1) { // Guess is too high
                System.out.println("Too high!");
            } else if (feedback == -1) { // Guess is too low
                System.out.println("Too low!");
            }

        } while (guess != secretNumber); // Continue until the guess is correct

        scanner.close();
    }

    /**
     * Generates the computer's guess.  For this simple version, it's just a random guess.
     * More advanced versions could use a binary search or other strategies.
     *
     * @param attempts The number of attempts made so far (not used in this simple version)
     * @return The computer's guess
     */
    public static int generateGuess(int attempts) {
        Random random = new Random();
        return random.nextInt(100) + 1; // Generates a number between 1 and 100
    }

    /**
     * Gets feedback from the user about the computer's guess.
     *
     * @param scanner The Scanner object to read user input
     * @return 0 if the guess is correct, 1 if too high, -1 if too low
     */
    public static int getFeedback(Scanner scanner) {
        System.out.print("Enter feedback (0 for correct, 1 for too high, -1 for too low): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();

    }
}