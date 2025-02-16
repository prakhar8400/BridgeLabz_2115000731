import java.util.Arrays;

public class SentenceSearch {

    public static String findSentenceContainingWord(String[] sentences, String word) {
        if (sentences == null || sentences.length == 0 || word == null || word.isEmpty()) {
            return "Not Found"; // Handle null/empty input
        }

        for (String sentence : sentences) {
            if (sentence != null && sentence.toLowerCase().contains(word.toLowerCase())) { //Case-insensitive
                return sentence;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "This is the first sentence.",
                "The second sentence is here.",
                "A third sentence exists.",
                "No sentence contains the word."
        };

        String word1 = "second";
        String result1 = findSentenceContainingWord(sentences, word1);
        System.out.println("Sentence containing '" + word1 + "': " + result1);

        String word2 = "exists";
        String result2 = findSentenceContainingWord(sentences, word2);
        System.out.println("Sentence containing '" + word2 + "': " + result2);

        String word3 = "missing";
        String result3 = findSentenceContainingWord(sentences, word3);
        System.out.println("Sentence containing '" + word3 + "': " + result3);

        String word4 = null;
        String result4 = findSentenceContainingWord(sentences, word4);
        System.out.println("Sentence containing '" + word4 + "': " + result4);

        String[] sentences2 = {};
        String word5 = "test";
        String result5 = findSentenceContainingWord(sentences2, word5);
        System.out.println("Sentence containing '" + word5 + "': " + result5);

        String[] sentences3 = null;
        String word6 = "test";
        String result6 = findSentenceContainingWord(sentences3, word6);
        System.out.println("Sentence containing '" + word6 + "': " + result6);

        String word7 = "";
        String result7 = findSentenceContainingWord(sentences, word7);
        System.out.println("Sentence containing '" + word7 + "': " + result7);


    }
}
