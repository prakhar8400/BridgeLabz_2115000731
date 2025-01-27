import java.util.Random;

public class ZaraBonus {

    public static void main(String[] args) {
        int[][] employeeData = new int[10][3]; // 3 columns: Old Salary, Years of Service, Bonus
        
        // Generate random salaries and years of service for 10 employees
        generateEmployeeData(employeeData);

        // Calculate new salary and bonus
        calculateBonusAndNewSalary(employeeData);

        // Display results
        displayEmployeeData(employeeData);

        // Calculate and display total salaries and bonus
        displayTotalSalariesAndBonus(employeeData);
    }

    /**
     * Generates random salaries (5 digits) and years of service (1 to 10) for employees.
     *
     * @param employeeData the 2D array to store employee data
     */
    public static void generateEmployeeData(int[][] employeeData) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            employeeData[i][0] = rand.nextInt(90000) + 10000; // Generate salary between 10000 and 99999
            employeeData[i][1] = rand.nextInt(10) + 1; // Generate years of service between 1 and 10
        }
    }

    /**
     * Calculates the bonus and new salary for each employee based on years of service.
     *
     * @param employeeData the 2D array containing employee data
     */
    public static void calculateBonusAndNewSalary(int[][] employeeData) {
        for (int i = 0; i < 10; i++) {
            int yearsOfService = employeeData[i][1];
            int oldSalary = employeeData[i][0];
            int bonus;
            if (yearsOfService > 5) {
                bonus = (int) (oldSalary * 0.05); 
            } else {
                bonus = (int) (oldSalary * 0.02); 
            }
            employeeData[i][2] = bonus; 
            employeeData[i][0] += bonus; // Update old salary with bonus
        }
    }

    /**
     * Displays employee data in a tabular format and calculates total salaries and bonus.
     *
     * @param employeeData the 2D array containing employee data
     */
    public static void displayEmployeeData(int[][] employeeData) {
        int totalOldSalary = 0;
        int totalNewSalary = 0;
        int totalBonus = 0;

        System.out.println("Employee\tOld Salary\tYears of Service\tBonus\tNew Salary");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t\t%d\t\t\t%d\t\t\t%d\t\t%d\n", 
                    i + 1, employeeData[i][0] - employeeData[i][2], employeeData[i][1], employeeData[i][2], employeeData[i][0]);
            totalOldSalary += employeeData[i][0] - employeeData[i][2];
            totalNewSalary += employeeData[i][0];
            totalBonus += employeeData[i][2];
        }

        System.out.println("\nTotal Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        System.out.println("Total Bonus Amount: " + totalBonus);
    }
}

