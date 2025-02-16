
import java.util.Arrays;

public class SearchChallenge {

    public static int findFirstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1; // Handle null or empty array
        }

        int n = nums.length;

        // 1. Mark numbers as present using their indices (negative marking)
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with the element at the index it should be
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // 2. Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1; // All numbers from 1 to n are present
    }

    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1; // Handle null or empty array
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 0};
        int missing1 = findFirstMissingPositive(nums1);
        System.out.println("First missing positive in nums1: " + missing1); // Output: 3

        int[] nums2 = {3, 4, -1, 1};
        int missing2 = findFirstMissingPositive(nums2);
        System.out.println("First missing positive in nums2: " + missing2); // Output: 2

        int[] nums3 = {7, 8, 9, 11, 12};
        int missing3 = findFirstMissingPositive(nums3);
        System.out.println("First missing positive in nums3: " + missing3); // Output: 1

        int[] nums4 = {1,2,3};
        int missing4 = findFirstMissingPositive(nums4);
        System.out.println("First missing positive in nums4: " + missing4); // Output: 4

        int[] nums5 = {};
        int missing5 = findFirstMissingPositive(nums5);
        System.out.println("First missing positive in nums5: " + missing5); // Output: 1

        int[] nums6 = null;
        int missing6 = findFirstMissingPositive(nums6);
        System.out.println("First missing positive in nums6: " + missing6); // Output: 1


        int[] sortedNums1 = {2, 5, 7, 8, 11, 12};
        int target1 = 11;
        int index1 = binarySearch(sortedNums1, target1);
        System.out.println("Index of " + target1 + " in sortedNums1: " + index1); // Output: 4

        int target2 = 10;
        int index2 = binarySearch(sortedNums1, target2);
        System.out.println("Index of " + target2 + " in sortedNums1: " + index2); // Output: -1

        int[] sortedNums2 = {1};
        int target3 = 1;
        int index3 = binarySearch(sortedNums2, target3);
        System.out.println("Index of " + target3 + " in sortedNums2: " + index3); // Output: 0

        int[] sortedNums3 = {};
        int target4 = 1;
        int index4 = binarySearch(sortedNums3, target4);
        System.out.println("Index of " + target4 + " in sortedNums3: " + index4); // Output: -1

        int[] sortedNums4 = null;
        int target5 = 1;
        int index5 = binarySearch(sortedNums4, target5);
        System.out.println("Index of " + target5 + " in sortedNums4: " + index5); // Output: -1

    }
}



