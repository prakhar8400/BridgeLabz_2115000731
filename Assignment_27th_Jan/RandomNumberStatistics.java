import java.util.Arrays;

public class RandomNumberStatistics {

    public static void main(String[] args) {
        // Generate an array of 5 random 4-digit numbers
        int[] randomNumbers = generate4DigitRandomArray(5);

        // Find average, min, and max values
        double[] stats = findAverageMinMax(randomNumbers);

        // Display the results
        System.out.println("Random Numbers: " + Arrays.toString(randomNumbers));
        System.out.println("Average: " + stats[0]);
        System.out.println("Minimum: " + stats[1]);
        System.out.println("Maximum: " + stats[2]);
    }

    /**
     * Generates an array of random 4-digit integers.
     *
     * @param size the size of the array
     * @return an array of random 4-digit integers
     */
    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 9000) + 1000; // Generate random numbers between 1000 and 9999
        }
        return numbers;
    }

    /**
     * Calculates the average, minimum, and maximum values of an array of integers.
     *
     * @param numbers the array of integers
     * @return an array containing average, minimum, and maximum values (in that order)
     */
    public static double[] findAverageMinMax(int[] numbers) {
        double[] stats = new double[3]; // Array to store average, min, and max
        double sum = 0;

        for (int number : numbers) {
            sum += number;
        }
        stats[0] = sum / numbers.length; // Calculate average

        stats[1] = Math.min(Arrays.stream(numbers).min().getAsInt(), 
                           Math.min(numbers[0], numbers[1])); // Calculate minimum

        stats[2] = Math.max(Arrays.stream(numbers).max().getAsInt(), 
                           Math.max(numbers[0], numbers[1])); // Calculate maximum

        return stats;
    }
}

