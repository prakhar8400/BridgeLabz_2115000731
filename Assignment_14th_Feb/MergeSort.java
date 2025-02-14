public class MergeSort {

    public static void mergeSort(int[] prices) {
        if (prices.length <= 1) {
            return; // Base case: array of size 0 or 1 is already sorted
        }

        int mid = prices.length / 2;

        // Divide the array into two halves
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[prices.length - mid];

        // Copy elements to left and right halves
        System.arraycopy(prices, 0, leftHalf, 0, mid);
        System.arraycopy(prices, mid, rightHalf, 0, prices.length - mid);

        // Recursively sort the left and right halves
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // Merge the sorted halves
        merge(prices, leftHalf, rightHalf);
    }

    private static void merge(int[] prices, int[] leftHalf, int[] rightHalf) {
        int i = 0; // Index for leftHalf
        int j = 0; // Index for rightHalf
        int k = 0; // Index for prices

        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] <= rightHalf[j]) {
                prices[k++] = leftHalf[i++];
            } else {
                prices[k++] = rightHalf[j++];
            }
        }

        // Copy remaining elements from leftHalf, if any
        while (i < leftHalf.length) {
            prices[k++] = leftHalf[i++];
        }

        // Copy remaining elements from rightHalf, if any
        while (j < rightHalf.length) {
            prices[k++] = rightHalf[j++];
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] bookPrices = {120, 50, 150, 80, 20};

        System.out.println("Original array:");
        printArray(bookPrices);

        mergeSort(bookPrices);

        System.out.println("\nSorted array:");
        printArray(bookPrices);
    }
}
