import java.util.Random;

public class StudentScores {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[][] studentScores = generateStudentScores(numStudents);
        int[][] studentResults = calculateResults(studentScores);

        displayScoreCard(studentResults);

        scanner.close();
    }

    /**
     * Generates random scores for Physics, Chemistry, and Math for the given number of students.
     *
     * @param numStudents the number of students
     * @return a 2D array where each row represents a student's scores in Physics, Chemistry, and Math
     */
    public static int[][] generateStudentScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][3]; // 3 subjects: Physics, Chemistry, Math
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = rand.nextInt(101); // Physics
            scores[i][1] = rand.nextInt(101); // Chemistry
            scores[i][2] = rand.nextInt(101); // Math
        }
        return scores;
    }

    /**
     * Calculates total, average, and percentage for each student.
     *
     * @param studentScores a 2D array containing student scores in Physics, Chemistry, and Math
     * @return a 2D array where each row represents a student's total, average, and percentage
     */
    public static int[][] calculateResults(int[][] studentScores) {
        int numStudents = studentScores.length;
        int[][] results = new int[numStudents][3]; // 3 columns: Total, Average, Percentage
        for (int i = 0; i < numStudents; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += studentScores[i][j];
            }
            results[i][0] = total;
            results[i][1] = Math.round(total / 3.0f); 
            results[i][2] = Math.round((total / 300.0f) * 100); 
        }
        return results;
    }

    /**
     * Displays the scorecard of all students in a tabular format.
     *
     * @param studentResults a 2D array containing student results (total, average, percentage)
     */
    public static void displayScoreCard(int[][] studentResults) {
        System.out.println("Student\tTotal\tAverage\tPercentage");
        for (int i = 0; i < studentResults.length; i++) {
            System.out.printf("%d\t\t%d\t\t%d\t\t%d%%\n", 
                    i + 1, studentResults[i][0], studentResults[i][1], studentResults[i][2]);
        }
    }
}

