import java.util.Scanner;

public class TrigonometricFunctions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the angle in degrees: ");
        double angleInDegrees = scanner.nextDouble();

        // Calculate trigonometric functions
        double[] results = calculateTrigonometricFunctions(angleInDegrees);

        // Display the results
        System.out.println("Sine: " + results[0]);
        System.out.println("Cosine: " + results[1]);
        System.out.println("Tangent: " + results[2]);

        scanner.close();
    }

    /**
     * Calculates sine, cosine, and tangent of an angle in degrees.
     *
     * @param angleInDegrees the angle in degrees
     * @return an array containing sine, cosine, and tangent values (in that order)
     */
    public static double[] calculateTrigonometricFunctions(double angleInDegrees) {
        // Convert degrees to radians
        double angleInRadians = Math.toRadians(angleInDegrees);

        // Calculate sine, cosine, and tangent
        double sin = Math.sin(angleInRadians);
        double cos = Math.cos(angleInRadians);
        double tan = Math.tan(angleInRadians);

        // Store results in an array
        double[] results = {sin, cos, tan};
        return results;
    }
}