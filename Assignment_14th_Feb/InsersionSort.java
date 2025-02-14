public class InsertionSort {

    public static void insertionSort(int[] employeeIds) {
        int n = employeeIds.length;

        for (int i = 1; i < n; ++i) {
            int key = employeeIds[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j = j - 1;
            }
            employeeIds[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] employeeIds = {12, 10, 15, 5, 8};

        System.out.println("Original array:");
        printArray(employeeIds);

        insertionSort(employeeIds);

        System.out.println("\nSorted array:");
        printArray(employeeIds);
    }
}
