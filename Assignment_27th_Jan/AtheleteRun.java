import java.util.Scanner;

public class AthleteRun {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for sides of the triangle
        System.out.print("Enter the length of the first side of the park: ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter the length of the second side of the park: ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter the length of the third side of the park: ");
        double side3 = scanner.nextDouble();

        // Calculate perimeter of the park
        double perimeter = calculatePerimeter(side1, side2, side3);

        // Calculate the total distance to run (in meters)
        double totalDistance = 5 * 1000; // 5 km in meters

        // Calculate the number of rounds
        double rounds = totalDistance / perimeter;

        // Print the result
        System.out.println("The athlete needs to complete approximately " + Math.ceil(rounds) + " rounds.");

        scanner.close();
    }

    /**
     * Calculates the perimeter of a triangle.
     *
     * @param side1 length of the first side
     * @param side2 length of the second side
     * @param side3 length of the third side
     * @return the perimeter of the triangle
     */
    public static double calculatePerimeter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }
}