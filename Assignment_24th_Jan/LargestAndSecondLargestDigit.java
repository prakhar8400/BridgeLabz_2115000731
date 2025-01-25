import java.util.Scanner;

public class LargestAndSecondLargestDigit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Estimate maximum number of digits (can be improved)
        int maxDigits = 10; 
        int[] digits = new int[maxDigits]; 
        int index = 0;

        // Extract digits and store in array
        while (number != 0) {
            digits[index] = number % 10; 
            number /= 10;
            index++;

            if (index == maxDigits) {
                break; // If array is full, stop extracting digits
            }
        }

        // Find largest and second largest digits
        int largest = digits[0];
        int secondLargest = 0;

        for (int i = 1; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // Display results
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);

        scanner.close();
    }
}
