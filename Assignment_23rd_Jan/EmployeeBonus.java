 import java.util.Scanner;

public class EmployeeBonus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for salary and years of service
        System.out.print("Enter the employee's salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Enter the employee's years of service: ");
        int yearsOfService = scanner.nextInt();

        // Calculate bonus
        double bonus = 0.0;
        if (yearsOfService > 5) {
            bonus = salary * 0.05; // 5% bonus
        }

        // Display the bonus amount
        System.out.println("Bonus for the employee: " + bonus);

        scanner.close();
    }
}
