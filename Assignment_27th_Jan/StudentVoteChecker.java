import java.util.Scanner;

public class StudentVoteChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] studentAges = new int[10]; // Array to store ages of 10 students

        // Get ages of 10 students
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            studentAges[i] = scanner.nextInt();
        }

        // Check voting eligibility for each student
        for (int i = 0; i < 10; i++) {
            if (canStudentVote(studentAges[i])) {
                System.out.println("The student with the age " + studentAges[i] + " can vote.");
            } else {
                System.out.println("The student with the age " + studentAges[i] + " cannot vote.");
            }
        }

        scanner.close();
    }

    /**
     * Checks if a student is eligible to vote based on their age.
     *
     * @param age the age of the student
     * @return true if the student is eligible to vote (age >= 18), false otherwise
     */
    public static boolean canStudentVote(int age) {
        // Validate age (age cannot be negative)
        if (age < 0) {
            return false; // Invalid age
        }

        // Check if the student is of voting age
        return age >= 18; 
    }
}