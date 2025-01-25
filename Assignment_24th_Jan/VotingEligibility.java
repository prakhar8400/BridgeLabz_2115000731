import java.util.Scanner;

public class VotingEligibility {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] studentAges = new int[10];

        // Get ages of 10 students
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            studentAges[i] = scanner.nextInt();
        }

        // Check voting eligibility for each student
        for (int i = 0; i < 10; i++) {
            if (studentAges[i] < 0) {
                System.out.println("Invalid age for student " + (i + 1));
            } else if (studentAges[i] >= 18) {
                System.out.println("The student with the age " + studentAges[i] + " can vote.");
            } else {
                System.out.println("The student with the age " + studentAges[i] + " cannot vote.");
            }
        }

        scanner.close();
    }
}
