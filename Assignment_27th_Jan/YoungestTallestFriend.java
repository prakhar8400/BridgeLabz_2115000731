import java.util.Scanner;

public class YoungestTallestFriend {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get ages of the friends
        int[] ages = new int[3];
        System.out.print("Enter age of Amar: ");
        ages[0] = scanner.nextInt();
        System.out.print("Enter age of Akbar: ");
        ages[1] = scanner.nextInt();
        System.out.print("Enter age of Anthony: ");
        ages[2] = scanner.nextInt();

        // Get heights of the friends
        double[] heights = new double[3];
        System.out.print("Enter height of Amar (in cm): ");
        heights[0] = scanner.nextDouble();
        System.out.print("Enter height of Akbar (in cm): ");
        heights[1] = scanner.nextDouble();
        System.out.print("Enter height of Anthony (in cm): ");
        heights[2] = scanner.nextDouble();

        // Find the youngest friend
        int youngestIndex = findYoungest(ages);
        String youngestFriend = getFriendName(youngestIndex);
        System.out.println("Youngest friend: " + youngestFriend);

        // Find the tallest friend
        int tallestIndex = findTallest(heights);
        String tallestFriend = getFriendName(tallestIndex);
        System.out.println("Tallest friend: " + tallestFriend);

        scanner.close();
    }

    /**
     * Finds the index of the youngest friend in the given array of ages.
     *
     * @param ages an array containing the ages of the friends
     * @return the index of the youngest friend
     */
    public static int findYoungest(int[] ages) {
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }

    /**
     * Finds the index of the tallest friend in the given array of heights.
     *
     * @param heights an array containing the heights of the friends
     * @return the index of the tallest friend
     */
    public static int findTallest(double[] heights) {
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }

    /**
     * Gets the name of the friend based on the index.
     *
     * @param index the index of the friend (0 for Amar, 1 for Akbar, 2 for Anthony)
     * @return the name of the friend
     */
    public static String getFriendName(int index) {
        String[] friends = {"Amar", "Akbar", "Anthony"};
        return friends[index];
    }
}