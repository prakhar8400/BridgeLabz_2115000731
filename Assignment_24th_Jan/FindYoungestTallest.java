import java.util.Scanner;

public class FindYoungestTallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declare arrays to store ages and heights
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Get input for ages and heights
        for (int i = 0; i < 3; i++) {
            String name = "";
            switch (i) {
                case 0:
                    name = "Amar";
                    break;
                case 1:
                    name = "Akbar";
                    break;
                case 2:
                    name = "Anthony";
                    break;
            }
            System.out.print("Enter " + name + "'s age: ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter " + name + "'s height (in cm): ");
            heights[i] = scanner.nextDouble();
        }

        // Find the youngest friend
        int youngestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }

        // Find the tallest friend
        int tallestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Determine the names of the youngest and tallest friends
        String[] friends = {"Amar", "Akbar", "Anthony"};
        String youngestFriend = friends[youngestIndex];
        String tallestFriend = friends[tallestIndex];

        // Display results
        System.out.println("The youngest friend is: " + youngestFriend);
        System.out.println("The tallest friend is: " + tallestFriend);

        scanner.close();
    }
}
