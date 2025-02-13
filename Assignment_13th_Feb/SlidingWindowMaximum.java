import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }

        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        // Process the first window
        for (int i = 0; i < k; i++) {
            // Remove smaller elements from the back of the deque
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        result[0] = nums[deque.peekFirst()];

        // Process the remaining windows
        for (int i = k; i < n; i++) {
            // Remove elements outside the current window
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.removeFirst();
            }

            // Remove smaller elements from the back of the deque
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);

            result[i - k + 1] = nums[deque.peekFirst()];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] maxes = maxSlidingWindow(nums, k);

        System.out.print("Maximums in each window: ");
        for (int max : maxes) {
            System.out.print(max + " ");
        }
    }
}
