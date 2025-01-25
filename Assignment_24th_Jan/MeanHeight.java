import java.util.Scanner;

public class MeanHeight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array to store heights of 11 players
        double[] heights = new double[11];

        // Get input for heights of players
        System.out.println("Enter heights of 11 players in centimeters:");
        for (int i = 0; i < 11; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
        }

        // Calculate the sum of heights
        double sumHeights = 0;
        for (double height : heights) {
            sumHeights += height;
        }

        // Calculate the mean height
        double meanHeight = sumHeights / 11;

        // Print the mean height
        System.out.println("Mean height of the football team: " + meanHeight + " cm");

        scanner.close();
    }
}
