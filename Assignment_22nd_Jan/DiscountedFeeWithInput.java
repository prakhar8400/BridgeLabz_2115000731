package Assignment_21st_January;

import java.util.Scanner;

public class DiscountedFeeWithInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student Fee: ");
        double fee = input.nextDouble();
        System.out.print("Enter Discount Percent: ");
        double discountPercent = input.nextDouble();
        double discountAmount = (fee * discountPercent) / 100;
        double discountedFee = fee - discountAmount;
        System.out.println(
                "The discount amount is INR " + discountAmount + " and final discounted fee is INR " + discountedFee);
        input.close();
    }
}