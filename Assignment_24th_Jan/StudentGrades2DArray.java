import java.util.Scanner;

public class StudentGrades2DArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[][] marks = new int[numStudents][3]; // 0: Physics, 1: Chemistry, 2: Maths
        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];

        // Get input for marks
        for (int i = 0; i < numStudents; i++) {
            boolean validInput = false;
            do {
                System.out.println("Enter marks for student " + (i + 1) + ":");
                System.out.print("Physics: ");
                marks[i][0] = scanner.nextInt();
                System.out.print("Chemistry: ");
                marks[i][1] = scanner.nextInt();
                System.out.print("Maths: ");
                marks[i][2] = scanner.nextInt();

                if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                    System.out.println("Invalid input. Marks cannot be negative.");
                } else {
                    validInput = true;
                }
            } while (!validInput);

            // Calculate percentage
            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 300.0 * 100;

            // Determine grade
            if (percentages[i] >= 80) {
                grades[i] = "A";
            } else if (percentages[i] >= 70) {
                grades[i] = "B";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
            } else if (percentages[i] >= 50) {
                grades[i] = "D";
            } else if (percentages[i] >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }

        // Display results
        System.out.println("\nStudent\tPhysics\tChemistry\tMaths\tPercentage\tGrade\t\tRemarks");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%.2f%%\t\t%s\t\t%s\n", i + 1, marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i], getRemarks(grades[i]));
        }

        scanner.close();
    }

    // Helper method to get remarks based on the grade
    public static String getRemarks(String grade) {
        switch (grade) {
            case "A":
                return "(Level 4, above agency-normalized standards)";
            case "B":
                return "(Level 3, at agency-normalized standards)";
            case "C":
                return "(Level 2, below, but approaching agency-normalized standards)";
            case "D":
                return "(Level 1, well below agency-normalized standards)";
            case "E":
                return "(Level 1-, too below agency-normalized standards)";
            case "R":
                return "(Remedial standards)";
            default:
                return "";
        }
    }
}
