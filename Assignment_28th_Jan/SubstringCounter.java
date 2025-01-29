import java.util.Scanner;

public class SubstringCounter {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the main string
        System.out.print("Enter the main string: ");
        String mainString = scanner.nextLine();

        // Prompt the user to enter the substring to search for
        System.out.print("Enter the substring: ");
        String substring = scanner.nextLine();

        // Call the countSubstringOccurrences method to count occurrences
        int occurrences = countSubstringOccurrences(mainString, substring);

        // Print the number of occurrences
        System.out.println("Number of occurrences: " + occurrences);

        // Close the scanner to release resources
        scanner.close();
    }

    // Method to count the number of times a substring occurs in a string
    public static int countSubstringOccurrences(String str, String sub) {
        // Check for null or empty strings to avoid exceptions
        if (str == null || str.isEmpty() || sub == null || sub.isEmpty()) {
            return 0; // Or handle it as you deem appropriate (e.g., throw an exception)
        }

        int count = 0;  // Initialize the occurrence counter
        int startIndex = 0; // Start searching from the beginning of the string

        // Loop to find all occurrences
        while ((startIndex = str.indexOf(sub, startIndex)) != -1) {
            // str.indexOf(sub, startIndex) searches for the first occurrence of 'sub' in 'str'
            // starting from the index 'startIndex'. It returns -1 if the substring is not found.
            count++;        // Increment the counter if a match is found
            startIndex += sub.length(); // Move the starting index to the position after the found substring
                                      // to avoid overlapping matches (e.g. "aaa" contains "aa" twice).
        }

        return count;
    }
}