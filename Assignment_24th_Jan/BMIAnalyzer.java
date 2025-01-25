import java.util.Scanner;

public class BMIAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();

        // Create arrays to store data
        double[][] personData = new double[numPersons][3]; // 0: weight, 1: height, 2: BMI
        String[] weightStatus = new String[numPersons];

        // Get input for weight and height
        for (int i = 0; i < numPersons; i++) {
            boolean validInput = false;
            do {
                System.out.print("Enter weight for person " + (i + 1) + " in kilograms: ");
                personData[i][0] = scanner.nextDouble();

                System.out.print("Enter height for person " + (i + 1) + " in centimeters: ");
                personData[i][1] = scanner.nextDouble();

                if (personData[i][0] <= 0 || personData[i][1] <= 0) {
                    System.out.println("Invalid input. Weight and height must be positive.");
                } else {
                    validInput = true;
                }
            } while (!validInput);

            // Calculate BMI
            personData[i][2] = personData[i][0] / Math.pow((personData[i][1] / 100), 2); 

            // Determine weight status
            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] >= 18.5 && personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] >= 25.0 && personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\nPerson\tHeight (cm)\tWeight (kg)\tBMI\t\tStatus");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\t\t%s\n", i + 1, personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }

        scanner.close();
    }
}
