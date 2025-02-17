import java.util.*;

public class DataStructureComparison {

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 100000, 1000000};
        int numTrials = 1000;

        for (int size : datasetSizes) {
            int[] data = new int[size];
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(10000); // Generate random data
            }

            // Create HashSet and TreeSet
            HashSet<Integer> hashSet = new HashSet<>();
            for (int num : data) {
                hashSet.add(num);
            }
            TreeSet<Integer> treeSet = new TreeSet<>(hashSet); // Create TreeSet from HashSet

            long arraySearchTime = 0;
            long hashSetSearchTime = 0;
            long treeSetSearchTime = 0;

            for (int i = 0; i < numTrials; i++) {
                int target = data[rand.nextInt(size)]; // Generate random target

                long startTime = System.nanoTime();
                linearSearch(data, target);
                long endTime = System.nanoTime();
                arraySearchTime += (endTime - startTime);

                startTime = System.nanoTime();
                hashSet.contains(target);
                endTime = System.nanoTime();
                hashSetSearchTime += (endTime - startTime);

                startTime = System.nanoTime();
                treeSet.contains(target);
                endTime = System.nanoTime();
                treeSetSearchTime += (endTime - startTime);
            }

            System.out.println("Dataset Size: " + size);
            System.out.println("Average Array Search Time: " + (arraySearchTime / (double) numTrials) + " ns");
            System.out.println("Average HashSet Search Time: " + (hashSetSearchTime / (double) numTrials) + " ns");
            System.out.println("Average TreeSet Search Time: " + (treeSetSearchTime / (double) numTrials) + " ns");
            System.out.println("------------------------");
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return 1; // Found
            }
        }
        return 0; // Not found
    }
}
