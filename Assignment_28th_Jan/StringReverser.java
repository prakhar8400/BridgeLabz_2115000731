import java.util.Scanner;

public class StringReverser {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Call the reverseString method to get the reversed string
        String reversedString = reverseString(inputString);

        // Print the reversed string
        System.out.println("Reversed string: " + reversedString);

        // Close the scanner to release resources
        scanner.close();
    }

    // Method to reverse a string without using built-in functions
    public static String reverseString(String str) {
        // Check if the string is null or empty.  If so, return it as is.
        if (str == null || str.isEmpty()) {
            return str;
        }

        // Convert the string to a character array. Strings are immutable in Java,
        // so we need a char array to modify the characters in place.
        char[] charArray = str.toCharArray();

        // Use two pointers, one at the beginning and one at the end of the array
        int left = 0;
        int right = charArray.length - 1;

        // Iterate through the array, swapping characters from the left and right
        while (left < right) {
            // Swap the characters at the left and right pointers
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            // Move the pointers towards the center
            left++;
            right--;
        }

        // Create a new string from the reversed character array
        return new String(charArray);
    }
}