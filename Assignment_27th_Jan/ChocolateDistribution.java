import java.util.Scanner;

public class ChocolateDistribution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();
        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();

        // Validate input
        if (numberOfChildren <= 0) {
            System.out.println("Error: Number of children must be greater than zero.");
        } else {
            // Calculate chocolates per child and remaining chocolates
            int[] result = calculateDistribution(numberOfChocolates, numberOfChildren);

            // Display the result
            System.out.println("Each child gets " + result[0] + " chocolates.");
            System.out.println("Remaining chocolates: " + result[1]);
        }

        scanner.close();
    }

    /**
     * Calculates the number of chocolates each child gets and the remaining chocolates.
     *
     * @param numberOfChocolates the total number of chocolates
     * @param numberOfChildren the number of children
     * @return an array where index 0 holds chocolates per child and index 1 holds remaining chocolates
     */
    public static int[] calculateDistribution(int numberOfChocolates, int numberOfChildren) {
        int[] result = new int[2];
        result[0] = numberOfChocolates / numberOfChildren; // Chocolates per child
        result[1] = numberOfChocolates % numberOfChildren; // Remaining chocolates
        return result;
    }
}