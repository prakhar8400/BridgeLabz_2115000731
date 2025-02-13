import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindZeroSumSubarrays {

    public static List<List<Integer>> findSubarraysWithZeroSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> sumMap = new HashMap<>(); 
        sumMap.put(0, -1); // Handle the case where the subarray starts from the beginning
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sumMap.containsKey(sum)) {
                int startIndex = sumMap.get(sum) + 1; 
                List<Integer> subarray = new ArrayList<>();
                for (int j = startIndex; j <= i; j++) {
                    subarray.add(arr[j]);
                }
                result.add(subarray);
            } else {
                sumMap.put(sum, i); 
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<List<Integer>> subarrays = findSubarraysWithZeroSum(arr);

        System.out.println("Subarrays with zero sum:");
        for (List<Integer> subarray : subarrays) {
            System.out.println(subarray);
        }
    }
}
