
public class UnitConvertor {

    // Conversion constants
    private static final double KM_TO_MILES = 0.621371;
    private static final double MILES_TO_KM = 1.60934;
    private static final double METERS_TO_FEET = 3.28084;
    private static final double FEET_TO_METERS = 0.3048;

    /**
     * Converts kilometers to miles.
     *
     * @param km the distance in kilometers
     * @return the distance in miles
     */
    public static double convertKmToMiles(double km) {
        return km * KM_TO_MILES;
    }

    /**
     * Converts miles to kilometers.
     *
     * @param miles the distance in miles
     * @return the distance in kilometers
     */
    public static double convertMilesToKm(double miles) {
        return miles * MILES_TO_KM;
    }

    /**
     * Converts meters to feet.
     *
     * @param meters the distance in meters
     * @return the distance in feet
     */
    public static double convertMetersToFeet(double meters) {
        return meters * METERS_TO_FEET;
    }

    /**
     * Converts feet to meters.
     *
     * @param feet the distance in feet
     * @return the distance in meters
     */
    public static double convertFeetToMeters(double feet) {
        return feet * FEET_TO_METERS;
    }
}

