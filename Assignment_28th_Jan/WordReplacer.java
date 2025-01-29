import java.util.Scanner;

public class WordReplacer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the sentence: ");
        String sentence = scanner.nextLine();

        System.out.print("Enter the word to replace: ");
        String wordToReplace = scanner.nextLine();

        System.out.print("Enter the replacement word: ");
        String replacementWord = scanner.nextLine();

        String modifiedSentence = replaceWord(sentence, wordToReplace, replacementWord);

        System.out.println("Modified sentence: " + modifiedSentence);

        scanner.close();
    }

    public static String replaceWord(String sentence, String wordToReplace, String replacementWord) {
         // Handle null or empty input.  Return the original sentence if it's null or empty.
        if (sentence == null || sentence.isEmpty() || wordToReplace == null || wordToReplace.isEmpty() || replacementWord == null) {
            return sentence;
        }

        // Use String's replaceAll method with word boundaries to avoid partial word replacements.
        // The \\b represents a word boundary (the position between a word character and a non-word character).
        // This ensures that only whole words are replaced.
        return sentence.replaceAll("\\b" + wordToReplace + "\\b", replacementWord);

        // Alternative approach using StringBuilder (more efficient for multiple replacements):
        /*
        StringBuilder sb = new StringBuilder();
        int startIndex = 0;
        int wordIndex;

        while ((wordIndex = sentence.indexOf(wordToReplace, startIndex)) != -1) {
            sb.append(sentence.substring(startIndex, wordIndex)); // Append the part before the word
            sb.append(replacementWord); // Append the replacement word
            startIndex = wordIndex + wordToReplace.length(); // Move startIndex past the replaced word
        }
        sb.append(sentence.substring(startIndex)); // Append the remaining part of the sentence
        return sb.toString();
        */
    }
}