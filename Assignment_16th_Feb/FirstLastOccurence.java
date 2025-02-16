import java.util.Arrays;

public class FirstLastOccurrence {

    public static int[] findFirstLastOccurrence(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return new int[]{-1, -1}; // Handle null or empty array
        }

        int first = -1;
        int last = -1;

        // Find first occurrence
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            if (arr[mid] == target) {
                first = mid;
                right = mid - 1; // Search left for first occurrence
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Find last occurrence
        left = 0;
        right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1; // Search right for last occurrence
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 3, 3, 4, 5, 5, 6};
        int target1 = 3;
        int[] result1 = findFirstLastOccurrence(arr1, target1);
        System.out.println("First and last occurrence of " + target1 + " in arr1: " + Arrays.toString(result1)); // Output: [3, 5]

        int[] arr2 = {1, 2, 3, 4, 5};
        int target2 = 2;
        int[] result2 = findFirstLastOccurrence(arr2, target2);
        System.out.println("First and last occurrence of " + target2 + " in arr2: " + Arrays.toString(result2)); // Output: [1, 1]

        int[] arr3 = {1, 2, 3, 4, 5};
        int target3 = 6;
        int[] result3 = findFirstLastOccurrence(arr3, target3);
        System.out.println("First and last occurrence of " + target3 + " in arr3: " + Arrays.toString(result3)); // Output: [-1, -1]

        int[] arr4 = {2,2,2,2,2};
        int target4 = 2;
        int[] result4 = findFirstLastOccurrence(arr4, target4);
        System.out.println("First and last occurrence of " + target4 + " in arr4: " + Arrays.toString(result4)); // Output: [0, 4]

        int[] arr5 = {};
        int target5 = 2;
        int[] result5 = findFirstLastOccurrence(arr5, target5);
        System.out.println("First and last occurrence of " + target5 + " in arr5: " + Arrays.toString(result5)); // Output: [-1, -1]

        int[] arr6 = null;
        int target6 = 2;
        int[] result6 = findFirstLastOccurrence(arr6, target6);
        System.out.println("First and last occurrence of " + target6 + " in arr6: " + Arrays.toString(result6)); // Output: [-1, -1]
    }
}
