import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;

        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[arr.length - mid];

        System.arraycopy(arr, 0, leftHalf, 0, mid);
        System.arraycopy(arr, mid, rightHalf, 0, arr.length - mid);

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(arr, leftHalf, rightHalf);
    }

    private static void merge(int[] arr, int[] leftHalf, int[] rightHalf) {
        int i = 0; // Index for leftHalf
        int j = 0; // Index for rightHalf
        int k = 0; // Index for arr

        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] <= rightHalf[j]) {
                arr[k++] = leftHalf[i++];
            } else {
                arr[k++] = rightHalf[j++];
            }
        }

        while (i < leftHalf.length) {
            arr[k++] = leftHalf[i++];
        }

        while (j < rightHalf.length) {
            arr[k++] = rightHalf[j++];
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
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

            // Make copies of the original array for each sorting algorithm
            int[] bubbleSortData = data.clone();
            int[] mergeSortData = data.clone();
            int[] quickSortData = data.clone();

            long bubbleSortTime = 0;
            long mergeSortTime = 0;
            long quickSortTime = 0;

            for (int i = 0; i < numTrials; i++) {
                // Bubble Sort
                long startTime = System.nanoTime();
                bubbleSort(bubbleSortData);
                long endTime = System.nanoTime();
                bubbleSortTime += (endTime - startTime);
                // Reset array for next trial
                bubbleSortData = data.clone();

                // Merge Sort
                startTime = System.nanoTime();
                mergeSort(mergeSortData);
                endTime = System.nanoTime();
                mergeSortTime += (endTime - startTime);
                // Reset array for next trial
                mergeSortData = data.clone();

                // Quick Sort
                startTime = System.nanoTime();
                quickSort(quickSortData, 0, quickSortData.length - 1);
                endTime = System.nanoTime();
                quickSortTime += (endTime - startTime);
                // Reset array for next trial
                quickSortData = data.clone();
            }

            System.out.println("Dataset Size: " + size);
            System.out.println("Average Bubble Sort Time: " + (bubbleSortTime / (double) numTrials) + " ns");
            System.out.println("Average Merge Sort Time: " + (mergeSortTime / (double) numTrials) + " ns");
            System.out.println("Average Quick Sort Time: " + (quickSortTime / (double) numTrials) + " ns");
            System.out.println(" ");
        }
    }
}
