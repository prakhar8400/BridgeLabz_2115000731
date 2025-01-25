import java.util.Scanner;

public class FindFactorsWithArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Initial capacity for factors array
        int maxFactors = 10;
        int[] factors = new int[maxFactors];
        int index = 0;

        // Find factors and store in array
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                if (index >= maxFactors) {
                    // Increase array size if needed
                    maxFactors *= 2; // Double the size
                    int[] temp = new int[maxFactors];
                    System.arraycopy(factors, 0, temp, 0, index);
                    factors = temp;
                }
                factors[index++] = i;
            }
        }

        // Display factors
        System.out.print("Factors of " + number + ": ");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
