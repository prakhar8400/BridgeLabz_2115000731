public class CountingSort {

    public static void countingSort(int[] ages) {
        int maxAge = 18; // Maximum age in the given range
        int minAge = 10; // Minimum age in the given range
        int range = maxAge - minAge + 1; 

        int[] count = new int[range]; 

        // Count the frequency of each age
        for (int age : ages) {
            count[age - minAge]++; 
        }

        // Calculate cumulative frequencies
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1]; 
        }

        // Create a temporary array to store the sorted ages
        int[] output = new int[ages.length]; 

        // Place elements in their correct positions
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy sorted ages back to the original array
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] studentAges = {14, 12, 17, 10, 15, 13, 16, 11, 18, 15};

        System.out.println("Original array:");
        printArray(studentAges);

        countingSort(studentAges);

        System.out.println("\nSorted array:");
        printArray(studentAges);
    }
}
