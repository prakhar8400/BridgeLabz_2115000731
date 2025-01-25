import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();

        // Arrays to store data
        double[] weights = new double[numPersons];
        double[] heights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] statuses = new String[numPersons];

        // Get input for weight and height
        for (int i = 0; i < numPersons; i++) {
            boolean validInput = false;
            do {
                System.out.print("Enter weight for person " + (i + 1) + " in kilograms: ");
                weights[i] = scanner.nextDouble();

                System.out.print("Enter height for person " + (i + 1) + " in centimeters: ");
                heights[i] = scanner.nextDouble();

                if (weights[i] <= 0 || heights[i] <= 0) {
                    System.out.println("Invalid input. Weight and height must be positive.");
                } else {
                    validInput = true;
                }
            } while (!validInput);

            // Calculate BMI
            bmis[i] = weights[i] / Math.pow((heights[i] / 100), 2);

            // Determine weight status
            if (bmis[i] <= 18.4) {
                statuses[i] = "Underweight";
            } else if (bmis[i] >= 18.5 && bmis[i] <= 24.9) {
                statuses[i] = "Normal";
            } else if (bmis[i] >= 25.0 && bmis[i] <= 39.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\nPerson\tHeight (cm)\tWeight (kg)\tBMI\t\tStatus");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\t\t%s\n", i + 1, heights[i], weights[i], bmis[i], statuses[i]);
        }

        scanner.close();
    }
}
