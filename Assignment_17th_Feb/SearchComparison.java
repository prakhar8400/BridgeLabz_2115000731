
import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found
            }
        }
        return -1; // Not found
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000}; 
        int numTrials = 1000; // Number of trials for each dataset size

        for (int size : datasetSizes) {
            int[] data = new int[size];
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(10000); // Generate random data
            }

            // Sort the array for binary search
            int[] sortedData = data.clone();
            Arrays.sort(sortedData);

            long linearSearchTime = 0;
            long binarySearchTime = 0;

            for (int i = 0; i < numTrials; i++) {
                int target = data[rand.nextInt(size)]; // Generate random target

                long startTime = System.nanoTime();
                linearSearch(data, target);
                long endTime = System.nanoTime();
                linearSearchTime += (endTime - startTime);

                startTime = System.nanoTime();
                binarySearch(sortedData, target);
                endTime = System.nanoTime();
                binarySearchTime += (endTime - startTime);
            }

            System.out.println("Dataset Size: " + size);
            System.out.println("Average Linear Search Time: " + (linearSearchTime / (double) numTrials) + " ns");
            System.out.println("Average Binary Search Time: " + (binarySearchTime / (double) numTrials) + " ns");
            System.out.println("------------------------");
        }
    }
}
