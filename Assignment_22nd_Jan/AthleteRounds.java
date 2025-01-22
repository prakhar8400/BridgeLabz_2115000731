package Assignment_21st_January;

import java.util.Scanner;

public class AthleteRounds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side1 of the triangular park (in meters): ");
        double side1 = input.nextDouble();
        System.out.print("Enter side2 of the triangular park (in meters): ");
        double side2 = input.nextDouble();
        System.out.print("Enter side3 of the triangular park (in meters): ");
        double side3 = input.nextDouble();

        double perimeter = side1 + side2 + side3;
        double rounds = 5000 / perimeter; // 5 km = 5000 meters
        System.out.println(
                "The total number of rounds the athlete will run is " + Math.ceil(rounds) + " to complete 5 km.");
        input.close();
    }
}
