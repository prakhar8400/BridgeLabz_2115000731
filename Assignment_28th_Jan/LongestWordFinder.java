import java.util.Scanner;

public class LongestWordFinder {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a sentence
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // Call the findLongestWord method to get the longest word
        String longestWord = findLongestWord(sentence);

        // Print the longest word
        System.out.println("Longest word: " + longestWord);

        // Close the scanner to release resources
        scanner.close();
    }

    // Method to find the longest word in a sentence
    public static String findLongestWord(String sentence) {
        // Check if the sentence is null or empty. If so, return an empty string.
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        // Remove leading and trailing whitespace from the sentence
        sentence = sentence.trim();

        // Split the sentence into words using spaces as delimiters
        String[] words = sentence.split("\\s+"); // \\s+ handles multiple spaces

        // Initialize the longest word to the first word in the sentence
        String longestWord = words[0];

        // Iterate through the remaining words and update the longest word if a longer word is found
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
            }
        }

        // Return the longest word
        return longestWord;
    }
}