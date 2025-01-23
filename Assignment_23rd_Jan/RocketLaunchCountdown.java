
import java.util.Scanner;

public class RocketLaunchCountdown {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the starting countdown value
        System.out.print("Enter the starting countdown value: ");
        int counter = scanner.nextInt();

        // Countdown loop
        while (counter > 0) {
            System.out.println(counter);
            counter--; 
        }

        System.out.println("Blast Off!");

        scanner.close();
    }
}


