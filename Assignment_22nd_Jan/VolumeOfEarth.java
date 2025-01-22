package Assignment_21st_January;

public class VolumeOfEarth {
    public static void main(String[] args) {
        double radiusEarth = 6378;
        double volumeKm = (4.0 / 3) * Math.PI * Math.pow(radiusEarth, 3);
        double volumeMiles = volumeKm / Math.pow(1.6, 3);
        System.out.println(
                "The volume of earth in cubic kilometers is " + volumeKm + " and cubic miles is " + volumeMiles);
    }
}