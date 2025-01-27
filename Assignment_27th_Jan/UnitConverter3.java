public class UnitConvertor {

    // Conversion constants
    private static final double YARDS_TO_FEET = 3.0;
    private static final double FEET_TO_YARDS = 1.0 / YARDS_TO_FEET; // 1/3
    private static final double METERS_TO_INCHES = 39.3701;
    private static final double INCHES_TO_METERS = 1.0 / METERS_TO_INCHES;
    private static final double INCHES_TO_CM = 2.54;

    /**
     * Converts yards to feet.
     *
     * @param yards the distance in yards
     * @return the distance in feet
     */
    public static double convertYardsToFeet(double yards) {
        return yards * YARDS_TO_FEET;
    }

    /**
     * Converts feet to yards.
     *
     * @param feet the distance in feet
     * @return the distance in yards
     */
    public static double convertFeetToYards(double feet) {
        return feet * FEET_TO_YARDS;
    }

    /**
     * Converts meters to inches.
     *
     * @param meters the distance in meters
     * @return the distance in inches
     */
    public static double convertMetersToInches(double meters) {
        return meters * METERS_TO_INCHES;
    }

    /**
     * Converts inches to meters.
     *
     * @param inches the distance in inches
     * @return the distance in meters
     */
    public static double convertInchesToMeters(double inches) {
        return inches * INCHES_TO_METERS;
    }

    /**
     * Converts inches to centimeters.
     *
     * @param inches the distance in inches
     * @return the distance in centimeters
     */
    public static double convertInchesToCentimeters(double inches) {
        return inches * INCHES_TO_CM;
    }
}