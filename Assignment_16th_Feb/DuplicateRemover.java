import java.util.HashSet;
import java.util.Set;

public class DuplicateRemover {

    public static String removeDuplicates(String str) {
        if (str == null || str.isEmpty()) {
            return str; // Handle null or empty input
        }

        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String inputString = "bananas";
        String result = removeDuplicates(inputString);
        System.out.println("Original string: " + inputString);
        System.out.println("String without duplicates: " + result);

        inputString = "";
        result = removeDuplicates(inputString);
        System.out.println("Original string: " + inputString);
        System.out.println("String without duplicates: " + result);


        inputString = null;
        result = removeDuplicates(inputString);
        System.out.println("Original string: " + inputString);
        System.out.println("String without duplicates: " + result);


        inputString = "a";
        result = removeDuplicates(inputString);
        System.out.println("Original string: " + inputString);
        System.out.println("String without duplicates: " + result);

        inputString = "aabbcc";
        result = removeDuplicates(inputString);
        System.out.println("Original string: " + inputString);
        System.out.println("String without duplicates: " + result);

    }
}
