package Assignment_21st_January;

import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base of the triangle (in cm): ");
        double base = input.nextDouble();
        System.out.print("Enter height of the triangle (in cm): ");
        double heightCm = input.nextDouble();
        double area = 0.5 * base * heightCm;
        System.out.println("The area of the triangle is " + area + " square cm");
        input.close();
    }
}