public class PeakElement {

    public static int findPeakElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // Handle null or empty array
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) { // Important: <= for handling single-element arrays
            int mid = left + (right - left) / 2; // Avoid overflow

            // Handle edge cases for mid - 1 and mid + 1
            int leftNeighbor = (mid > 0) ? arr[mid - 1] : Integer.MIN_VALUE;
            int rightNeighbor = (mid < arr.length - 1) ? arr[mid + 1] : Integer.MIN_VALUE;


            if (arr[mid] > leftNeighbor && arr[mid] > rightNeighbor) {
                return mid; // Found a peak element
            } else if (arr[mid] < leftNeighbor) {
                right = mid - 1;
            } else { // arr[mid] < rightNeighbor or arr[mid] is not a peak
                left = mid + 1;
            }
        }

        return -1; // Should not reach here if array is valid and has a peak
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1};
        int peak1 = findPeakElement(arr1);
        System.out.println("Peak element index in arr1: " + peak1); // Output: 2

        int[] arr2 = {1, 2, 1, 3, 5, 6, 4};
        int peak2 = findPeakElement(arr2);
        System.out.println("Peak element index in arr2: " + peak2); // Output: 1 or 5 (any peak is valid)

        int[] arr3 = {1, 2, 3, 4, 5}; // strictly increasing
        int peak3 = findPeakElement(arr3);
        System.out.println("Peak element index in arr3: " + peak3); // Output: 4

        int[] arr4 = {5, 4, 3, 2, 1}; // strictly decreasing
        int peak4 = findPeakElement(arr4);
        System.out.println("Peak element index in arr4: " + peak4); // Output: 0

        int[] arr5 = {1}; // single element
        int peak5 = findPeakElement(arr5);
        System.out.println("Peak element index in arr5: " + peak5); // Output: 0

        int[] arr6 = {}; // empty array
        int peak6 = findPeakElement(arr6);
        System.out.println("Peak element index in arr6: " + peak6); // Output: -1

        int[] arr7 = null; // null array
        int peak7 = findPeakElement(arr7);
        System.out.println("Peak element index in arr7: " + peak7); // Output: -1


    }
}
