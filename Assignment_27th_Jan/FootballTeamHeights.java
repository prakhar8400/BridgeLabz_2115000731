import java.util.Random;

public class FootballTeamHeights {

    public static void main(String[] args) {
        // Create an array to store heights of 11 players
        int[] heights = new int[11];

        // Generate random heights for 11 players
        generateRandomHeights(heights);

        // Calculate and display results
        System.out.println("Player Heights (cm): " + java.util.Arrays.toString(heights));
        System.out.println("Shortest Height: " + findShortestHeight(heights) + " cm");
        System.out.println("Tallest Height: " + findTallestHeight(heights) + " cm");
        System.out.println("Mean Height: " + calculateMeanHeight(heights) + " cm");
    }

    /**
     * Generates random heights (between 150cm and 250cm) for all players in the array.
     *
     * @param heights the array to store the generated heights
     */
    public static void generateRandomHeights(int[] heights) {
        Random random = new Random();
        for (int i = 0; i < heights.length; i++) {
            heights[i] = random.nextInt(101) + 150; // Generate random heights between 150 and 250 cm
        }
    }

    /**
     * Calculates the sum of all elements in the given array.
     *
     * @param heights the array of heights
     * @return the sum of all heights
     */
    public static int calculateSumOfHeights(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    /**
     * Calculates the mean height of the players.
     *
     * @param heights the array of heights
     * @return the mean height
     */
    public static double calculateMeanHeight(int[] heights) {
        return (double) calculateSumOfHeights(heights) / heights.length;
    }

    /**
     * Finds the shortest height among the players.
     *
     * @param heights the array of heights
     * @return the shortest height
     */
    public static int findShortestHeight(int[] heights) {
        int shortest = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < shortest) {
                shortest = heights[i];
            }
        }
        return shortest;
    }

    /**
     * Finds the tallest height among the players.
     *
     * @param heights the array of heights
     * @return the tallest height
     */
    public static int findTallestHeight(int[] heights) {
        int tallest = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > tallest) {
                tallest = heights[i];
            }
        }
        return tallest;
    }
}