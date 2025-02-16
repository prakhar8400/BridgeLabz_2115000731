import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {

    public static int countWordOccurrences(String filename, String word) {
        int count = 0;

        try (FileReader fileReader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into words using whitespace as a delimiter
                String[] words = line.toLowerCase().split("\\s+"); // Case-insensitive and handles multiple spaces

                for (String w : words) {
                   if (w.equals(word.toLowerCase())) { // Case-insensitive comparison
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return 0; // Return 0 if file reading fails
        }

        return count;
    }

    public static void main(String[] args) {
        String filename = "my_file.txt"; // Replace with your file name
        String wordToCount = "the";       // Replace with the word to count

        int occurrences = countWordOccurrences(filename, wordToCount);

        System.out.println("The word '" + wordToCount + "' appears " + occurrences + " times in the file.");
    }
}
