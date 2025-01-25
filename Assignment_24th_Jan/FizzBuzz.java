
import java.util.Scanner;

public class FizzBuzz {
    public static void main(String args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            String results = new String[n];

            for (int i = 0; i < n; i++) {
                if ((i + 1) % 3 == 0 && (i + 1) % 5 == 0) {
                    results[i] = "FizzBuzz";
                } else if ((i + 1) % 3 == 0) {
                    results[i] = "Fizz";
                } else if ((i + 1) % 5 == 0) {
                    results[i] = "Buzz";
                } else {
                    results[i] = String.valueOf(i + 1); // Convert integer to string
                }
            }

            // Print the results
            for (int i = 0; i < n; i++) {
                System.out.println("Position " + (i + 1) + " = " + results[i]);
            }
        }

        scanner.close();
    }
}

