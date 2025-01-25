import java.util.Scanner;

public class EmployeeBonus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays to store employee data
        double[] salaries = new double[10];
        int[] yearsOfService = new int[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];

        // Variables to store total values
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        // Get input from the user
        for (int i = 0; i < 10; i++) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Enter salary for employee " + (i + 1) + ": ");
                    salaries[i] = scanner.nextDouble();

                    System.out.print("Enter years of service for employee " + (i + 1) + ": ");
                    yearsOfService[i] = scanner.nextInt();

                    if (salaries[i] <= 0 || yearsOfService[i] < 0) {
                        System.out.println("Invalid input. Salary and years of service must be positive.");
                    } else {
                        validInput = true;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter valid numbers.");
                    scanner.nextLine(); // Consume the invalid input
                }
            }
        }

        // Calculate bonuses and update salaries
        for (int i = 0; i < 10; i++) {
            double bonus;
            if (yearsOfService[i] > 5) {
                bonus = salaries[i] * 0.05; // 5% bonus
            } else {
                bonus = salaries[i] * 0.02; // 2% bonus
            }

            bonuses[i] = bonus;
            newSalaries[i] = salaries[i] + bonus;

            totalBonus += bonus;
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        // Display results
        System.out.println("\nTotal Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);

        scanner.close();
    }
}
