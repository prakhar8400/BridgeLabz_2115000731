package Assignment_21st_January;

import java.util.Scanner;

public class HeightConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your height in cm: ");
        double heightCm = input.nextDouble();
        double heightInches = heightCm / 2.54;
        double heightFeet = heightInches / 12;
        System.out.println("Your Height in cm is " + heightCm + " while in feet is " + (int) heightFeet +
                " and inches is " + (heightInches % 12));
        input.close();
    }
}