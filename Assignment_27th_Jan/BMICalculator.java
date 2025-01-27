import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a 2D array to store weight, height, and BMI
        double[][] personData = new double[10][3]; 

        // Get input for weight and height of each person
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for person " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            personData[i][0] = scanner.nextDouble();
            System.out.print("Height (cm): ");
            personData[i][1] = scanner.nextDouble();

            // Calculate and store BMI
            personData[i][2] = calculateBMI(personData[i][0], personData[i][1]);
        }

        // Determine BMI status for each person
        String[] bmiStatus = determineBMIStatus(personData);

        // Display the results
        System.out.println("Person\tWeight (kg)\tHeight (cm)\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\t\t%s\n", 
                    i + 1, personData[i][0], personData[i][1], personData[i][2], bmiStatus[i]);
        }

        scanner.close();
    }

    /**
     * Calculates the BMI (Body Mass Index) of a person.
     *
     * @param weight the weight of the person in kilograms
     * @param height the height of the person in centimeters
     * @return the calculated BMI
     */
    public static double calculateBMI(double weight, double height) {
        // Convert height from centimeters to meters
        double heightInMeters = height / 100; 
        return weight / (heightInMeters * heightInMeters);
    }

    /**
     * Determines the BMI status based on the BMI value.
     *
     * @param personData a 2D array containing weight, height, and BMI for each person
     * @return an array of strings containing the BMI status for each person
     */
    public static String[] determineBMIStatus(double[][] personData) {
        String[] status = new String[10];
        for (int i = 0; i < 10; i++) {
            double bmi = personData[i][2];
            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                status[i] = "Normal";
            } else if (bmi >= 25 && bmi < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }
}