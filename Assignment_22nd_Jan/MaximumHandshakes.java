package Assignment_21st_January;

import java.util.Scanner;

public class MaximumHandshakes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int studentsCount = input.nextInt();
        int handshakes = (studentsCount * (studentsCount - 1)) / 2;
        System.out.println("The maximum number of handshakes among " + studentsCount + " students is " + handshakes);
        input.close();
    }
}
