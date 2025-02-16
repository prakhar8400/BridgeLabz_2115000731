public class FirstNegativeNumber {

    public static int findFirstNegative(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // Handle null or empty array
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; // Return the index of the first negative number found
            }
        }

        return -1; // Return -1 if no negative number is found
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, -3, 4, -5, 6};
        int index1 = findFirstNegative(arr1);
        System.out.println("Index of first negative number in arr1: " + index1); // Output: 2

        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int index2 = findFirstNegative(arr2);
        System.out.println("Index of first negative number in arr2: " + index2); // Output: -1

        int[] arr3 = {-1, -2, -3, 4, 5, 6};
        int index3 = findFirstNegative(arr3);
        System.out.println("Index of first negative number in arr3: " + index3); // Output: 0

        int[] arr4 = {}; //Empty Array
        int index4 = findFirstNegative(arr4);
        System.out.println("Index of first negative number in arr4: " + index4); // Output: -1

        int[] arr5 = null; //Null Array
        int index5 = findFirstNegative(arr5);
        System.out.println("Index of first negative number in arr5: " + index5); // Output: -1

    }
}
