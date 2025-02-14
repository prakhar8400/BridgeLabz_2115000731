public class SelectionSort {

    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; 

            // Find the index of the minimum element in unsorted array
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] studentScores = {85, 68, 92, 75, 55};

        System.out.println("Original array:");
        printArray(studentScores);

        selectionSort(studentScores);

        System.out.println("\nSorted array:");
        printArray(studentScores);
    }
}
