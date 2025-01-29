import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        String word = getInput(); // Get input from the user
        boolean isPalindrome = isPalindrome(word); // Check if it's a palindrome
        displayResult(word, isPalindrome); // Display the result
    }

    /**
     * Gets input from the user.
     *
     * @return The string entered by the user.
     */
    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return scanner.nextLine();
    }

    /**
     * Checks if a given string is a palindrome (case-insensitive, ignoring spaces).
     *
     * @param word The string to check.
     * @return True if the string is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String word) {
        // Handle null or empty input
        if (word == null || word.isEmpty()) {
            return true; // Consider empty string as palindrome
        }

        // Remove spaces and convert to lowercase for case-insensitive comparison
        String processedWord = word.replaceAll("\\s+", "").toLowerCase();

        // Efficiently check for palindrome by comparing the processed string with its reverse
        String reversedWord = new StringBuilder(processedWord).reverse().toString();
        return processedWord.equals(reversedWord);

        // Alternative approach using two pointers (left and right):
        /*
        int left = 0;
        int right = processedWord.length() - 1;
        while (left < right) {
            if (processedWord.charAt(left) != processedWord.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
        */
    }

    /**
     * Displays the result to the user.
     *
     * @param word           The original string entered by the user.
     * @param isPalindromeResult True if the string is a palindrome, false otherwise.
     */
    public static void displayResult(String word, boolean isPalindromeResult) {
        if (isPalindromeResult) {
            System.out.println("\"" + word + "\" is a palindrome.");
        } else {
            System.out.println("\"" + word + "\" is not a palindrome.");
        }
    }
}