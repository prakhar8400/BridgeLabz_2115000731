public class QuickSort {

    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high); // Partition index

            // Recursively sort subarrays before and after partition
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    private static int partition(int[] prices, int low, int high) {
        // Choose the pivot as the last element
        int pivot = prices[high];
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (prices[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap pivot with the element at i+1
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] productPrices = {50, 120, 20, 150, 80};

        System.out.println("Original array:");
        printArray(productPrices);

        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("\nSorted array:");
        printArray(productPrices);
    }
}
