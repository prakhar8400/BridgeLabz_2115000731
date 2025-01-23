
import java.util.Scanner;

public class LeapYearUsingLogical {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        if ((year >= 1582) && 
            ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
            System.out.println("Leap Year.");
        } else {
            System.out.println("Not a Leap Year.");
        }

        scanner.close();
    }
}

