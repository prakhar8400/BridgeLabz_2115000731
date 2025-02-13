import java.util.HashMap;
import java.util.Map;

public class FindPairWithGivenSum {

    public static boolean findPair(int[] arr, int targetSum) {
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = targetSum - arr[i];

            if (numberMap.containsKey(complement)) {
                return true; // Pair found
            }

            numberMap.put(arr[i], i); // Store the current number and its index
        }

        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 3, -6, 9, 11};
        int targetSum = 4;

        if (findPair(arr, targetSum)) {
            System.out.println("Pair with given sum exists.");
        } else {
            System.out.println("Pair with given sum does not exist.");
        }
    }
}
