import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Call the removeDuplicates method to get the string without duplicates
        String stringWithoutDuplicates = removeDuplicates(inputString);

        // Print the string without duplicates
        System.out.println("String without duplicates: " + stringWithoutDuplicates);

        // Close the scanner to release resources
        scanner.close();
    }

    // Method to remove duplicate characters from a string
    public static String removeDuplicates(String str) {
        // Check if the string is null or empty. If so, return it as is.
        if (str == null || str.isEmpty()) {
            return str;
        }

        // Use a LinkedHashSet to store the characters in the order they appear.
        // LinkedHashSet maintains insertion order and does not allow duplicates.
        Set<Character> charSet = new LinkedHashSet<>();

        // Iterate through the string and add each character to the LinkedHashSet
        for (int i = 0; i < str.length(); i++) {
            charSet.add(str.charAt(i));
        }

        // Create a StringBuilder to build the string without duplicates
        StringBuilder sb = new StringBuilder();

        // Iterate through the LinkedHashSet and append each character to the StringBuilder
        for (Character ch : charSet) {
            sb.append(ch);
        }

        // Convert the StringBuilder to a String and return it
        return sb.toString();
    }
}