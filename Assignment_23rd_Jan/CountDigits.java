import java.util.Scanner;

public class CountDigits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        int count = 0; 

        while (number != 0) {
            number /= 10; // Remove the last digit
            count++; 
        }

        System.out.println("Number of digits: " + count);

        scanner.close();
    }
}
