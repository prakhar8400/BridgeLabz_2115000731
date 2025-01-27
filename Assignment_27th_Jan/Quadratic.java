import java.util.Scanner;

public class Quadratic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for coefficients
        System.out.print("Enter the coefficient of x^2 (a): ");
        double a = scanner.nextDouble();
        System.out.print("Enter the coefficient of x (b): ");
        double b = scanner.nextDouble();
        System.out.print("Enter the constant term (c): ");
        double c = scanner.nextDouble();

        // Find the roots
        double[] roots = findRoots(a, b, c);

        // Display the roots
        if (roots.length == 0) {
            System.out.println("No real roots exist.");
        } else if (roots.length == 1) {
            System.out.println("One real root: " + roots[0]);
        } else {
            System.out.println("Two real roots: " + roots[0] + " and " + roots[1]);
        }

        scanner.close();
    }

    /**
     * Finds the roots of a quadratic equation (ax^2 + bx + c = 0).
     *
     * @param a the coefficient of x^2
     * @param b the coefficient of x
     * @param c the constant term
     * @return an array containing the roots of the equation. 
     *         If there are no real roots, an empty array is returned.
     *         If there is only one real root, an array with a single element is returned.
     */
    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;

        if (delta > 0) {
            // Two distinct real roots
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } else if (delta == 0) {
            // One real root
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            // No real roots
            return new double[0]; 
        }
    }
}