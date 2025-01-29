import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Convert the string to lowercase and remove non-alphanumeric characters
        // This ensures that the palindrome check is case-insensitive and ignores spaces/punctuation.
        String processedString = inputString.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");


        // Call the isPalindrome method to check if the processed string is a palindrome
        boolean isPalindrome = isPalindrome(processedString);

        // Print the result
        if (isPalindrome) {
            System.out.println(inputString + " is a palindrome."); //Print original string
        } else {
            System.out.println(inputString + " is not a palindrome.");//Print original string
        }

        // Close the scanner to release resources
        scanner.close();
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        // Check if the string is null or empty. If so, it's considered a palindrome.
        if (str == null || str.isEmpty()) {
            return true;
        }

        // Use two pointers, one at the beginning and one at the end of the string
        int left = 0;
        int right = str.length() - 1;

        // Iterate through the string, comparing characters from the left and right
        while (left < right) {
            // If the characters at the left and right pointers are not equal,
            // the string is not a palindrome
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            // Move the pointers towards the center
            left++;
            right--;
        }

        // If the loop completes without finding any mismatched characters,
        // the string is a palindrome
        return true;
    }
}