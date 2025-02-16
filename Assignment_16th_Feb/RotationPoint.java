public class RotationPoint {

    public static int findRotationPoint(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // Handle null or empty array
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // Avoid potential overflow

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; // Or return right; left and right will be equal at the rotation point
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
        int rotationPoint1 = findRotationPoint(arr1);
        System.out.println("Rotation point in arr1: " + rotationPoint1); // Output: 4

        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int rotationPoint2 = findRotationPoint(arr2);
        System.out.println("Rotation point in arr2: " + rotationPoint2); // Output: 0 (no rotation)

        int[] arr3 = {7, 8, 1, 2, 3, 4, 5, 6};
        int rotationPoint3 = findRotationPoint(arr3);
        System.out.println("Rotation point in arr3: " + rotationPoint3); // Output: 2

        int[] arr4 = {1};
        int rotationPoint4 = findRotationPoint(arr4);
        System.out.println("Rotation point in arr4: " + rotationPoint4); // Output: 0

        int[] arr5 = {}; // Empty array
        int rotationPoint5 = findRotationPoint(arr5);
        System.out.println("Rotation point in arr5: " + rotationPoint5); // Output: -1

        int[] arr6 = null; // Null array
        int rotationPoint6 = findRotationPoint(arr6);
        System.out.println("Rotation point in arr6: " + rotationPoint6); // Output: -1

    }
}
