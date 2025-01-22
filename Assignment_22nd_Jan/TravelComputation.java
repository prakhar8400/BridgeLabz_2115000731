package Assignment_21st_January;

import java.util.Scanner;

public class TravelComputation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the starting city: ");
        String fromCity = scanner.nextLine();
        System.out.print("Enter the via city: ");
        String viaCity = scanner.nextLine();
        System.out.print("Enter the destination city: ");
        String toCity = scanner.nextLine();
        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " in miles: ");
        double distanceFromToVia = scanner.nextDouble();
        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " in miles: ");
        double distanceViaToFinalCity = scanner.nextDouble();
        System.out.print("Enter the time taken from " + fromCity + " to " + viaCity + " in minutes: ");
        int timeFromToVia = scanner.nextInt();
        System.out.print("Enter the time taken from " + viaCity + " to " + toCity + " in minutes: ");
        int timeViaToFinalCity = scanner.nextInt();
        double totalDistance = distanceFromToVia + distanceViaToFinalCity;
        int totalTime = timeFromToVia + timeViaToFinalCity;
        System.out.println("\nThe Total Distance travelled by " + name + " from " +
                fromCity + " to " + toCity + " via " + viaCity +
                " is " + totalDistance + " miles and " +
                "the Total Time taken is " + totalTime + " minutes");
        scanner.close();
    }
}
