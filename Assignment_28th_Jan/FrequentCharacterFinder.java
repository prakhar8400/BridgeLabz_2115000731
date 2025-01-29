import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequentCharacterFinder {

    public static void main(String args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        char mostFrequentChar = findMostFrequentCharacter(inputString);

        System.out.println("Most Frequent Character: '" + mostFrequentChar + "'");

        scanner.close();
    }

    public static char findMostFrequentCharacter(String str) {
        // Handle null or empty string
        if (str == null || str.isEmpty()) {
            return '\0'; // Return null character if the string is empty or null.  You could also throw an exception.
        }

        // Use a HashMap to store character frequencies
        Map<Character, Integer> charFrequencies = new HashMap<>();

        // Iterate through the string and count character occurrences
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If the character is already in the map, increment its count.
            // Otherwise, add it to the map with a count of 1.
            charFrequencies.put(ch, charFrequencies.getOrDefault(ch, 0) + 1);

            // The more concise way to do the above is:
            // charFrequencies.compute(ch, (k, v) -> (v == null)? 1: v + 1);
        }

        char mostFrequentChar = '\0'; // Initialize to null character
        int maxFrequency = 0;

        // Iterate through the HashMap to find the character with the highest frequency
        for (Map.Entry<Character, Integer> entry: charFrequencies.entrySet()) {
            char ch = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostFrequentChar = ch;
            }
        }

        return mostFrequentChar;
    }
}