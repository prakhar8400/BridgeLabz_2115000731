import java.util.Scanner;

public class LineEquation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for coordinates of two points
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();

        // Calculate Euclidean distance
        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.println("Euclidean distance between the points: " + distance);

        // Calculate equation of the line
        double[] lineEquation = findLineEquation(x1, y1, x2, y2);
        System.out.println("Equation of the line: y = " + lineEquation[0] + "x + " + lineEquation[1]);

        scanner.close();
    }

    /**
     * Calculates the Euclidean distance between two points.
     *
     * @param x1 x-coordinate of the first point
     * @param y1 y-coordinate of the first point
     * @param x2 x-coordinate of the second point
     * @param y2 y-coordinate of the second point
     * @return the Euclidean distance between the two points
     */
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    /**
     * Finds the equation of the line passing through two points.
     *
     * @param x1 x-coordinate of the first point
     * @param y1 y-coordinate of the first point
     * @param x2 x-coordinate of the second point
     * @param y2 y-coordinate of the second point
     * @return an array containing the slope (index 0) and y-intercept (index 1) of the line
     */
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        // Handle the case where x1 == x2 (vertical line)
        if (x1 == x2) {
            throw new IllegalArgumentException("Line is vertical, slope is undefined.");
        }

        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - slope * x1;

        return new double[]{slope, yIntercept};
    }
}