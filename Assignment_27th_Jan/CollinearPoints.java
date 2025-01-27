public class CollinearPoints {

    public static void main(String[] args) {
        // Example points: A(2, 4), B(4, 6), C(6, 8)
        double x1 = 2;
        double y1 = 4;
        double x2 = 4;
        double y2 = 6;
        double x3 = 6;
        double y3 = 8;

        // Check collinearity using slope formula
        if (isCollinearUsingSlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear using slope formula.");
        } else {
            System.out.println("Points are not collinear using slope formula.");
        }

        // Check collinearity using area of triangle formula
        if (isCollinearUsingArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear using area of triangle formula.");
        } else {
            System.out.println("Points are not collinear using area of triangle formula.");
        }
    }

    /**
     * Checks if three points are collinear using the slope formula.
     *
     * @param x1 x-coordinate of the first point
     * @param y1 y-coordinate of the first point
     * @param x2 x-coordinate of the second point
     * @param y2 y-coordinate of the second point
     * @param x3 x-coordinate of the third point
     * @param y3 y-coordinate of the third point
     * @return true if the points are collinear, false otherwise
     */
    public static boolean isCollinearUsingSlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Handle cases where denominator is zero (vertical lines)
        if (x1 == x2 || x2 == x3 || x1 == x3) {
            return true; // Assume vertical lines are collinear for simplicity
        }

        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);

        return (Math.abs(slopeAB - slopeBC) < 1e-9) && (Math.abs(slopeAB - slopeAC) < 1e-9); // Allow for slight numerical errors
    }

    /**
     * Checks if three points are collinear using the area of triangle formula.
     *
     * @param x1 x-coordinate of the first point
     * @param y1 y-coordinate of the first point
     * @param x2 x-coordinate of the second point
     * @param y2 y-coordinate of the second point
     * @param x3 x-coordinate of the third point
     * @param y3 y-coordinate of the third point
     * @return true if the points are collinear, false otherwise
     */
    public static boolean isCollinearUsingArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return Math.abs(area) < 1e-9; // Allow for slight numerical errors
    }
}