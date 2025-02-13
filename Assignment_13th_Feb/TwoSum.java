import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i}; 
            }

            numMap.put(nums[i], i); 
        }

        return new int[]{}; // No solution found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] indices = twoSum(nums, target);

        if (indices.length > 0) {
            System.out.println("Indices of the two numbers: [" + indices[0] + ", " + indices[1] + "]");
        } else {
            System.out.println("No two numbers sum up to the target.");
        }
    }
}
