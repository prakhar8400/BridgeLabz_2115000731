import java.util.Scanner;

public class RocketLaunchCountdownForLoop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the starting countdown value
        System.out.print("Enter the starting countdown value: ");
        int startValue = scanner.nextInt();

        // Countdown loop using for loop
        for (int i = startValue; i > 0; i--) {
            System.out.println(i);
        }

        System.out.println("Blast Off!");

        scanner.close();
    }
}
