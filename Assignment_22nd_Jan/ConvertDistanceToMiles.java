package Assignment_21st_January;

import java.util.Scanner;

public class ConvertDistanceToMiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        double kilometers = input.nextDouble();
        double miles = kilometers / 1.6;
        System.out.println("The total miles is " + miles + " mile for the given " + kilometers + " km");
        input.close();
    }
}