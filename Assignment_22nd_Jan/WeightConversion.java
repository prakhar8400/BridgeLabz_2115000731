package Assignment_21st_January;

import java.util.Scanner;

public class WeightConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter weight in pounds: ");
        double weightPounds = input.nextDouble();
        double weightKilograms = weightPounds / 2.2;
        System.out.println(
                "The weight of the person in pounds is " + weightPounds + " and in kilograms is " + weightKilograms);
        input.close();
    }
}
