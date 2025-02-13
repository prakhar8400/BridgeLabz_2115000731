import java.util.Stack;

public class SortStack {

    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return; // Base case: empty stack is already sorted
        }

        // Pop the top element
        int temp = stack.pop();

        // Sort the remaining stack recursively
        sortStack(stack);

        // Insert the popped element back at the correct position
        insertSorted(stack, temp);
    }

    private static void insertSorted(Stack<Integer> stack, int x) {
        // If stack is empty or the top of the stack is smaller than x
        if (stack.isEmpty() || stack.peek() <= x) {
            stack.push(x);
            return;
        }

        // Pop the top element and recur
        int temp = stack.pop();
        insertSorted(stack, x);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        sortStack(stack);

        // Print the sorted stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
