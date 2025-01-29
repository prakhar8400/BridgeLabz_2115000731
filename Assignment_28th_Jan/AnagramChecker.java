import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        boolean areAnagrams = areAnagrams(str1, str2);

        if (areAnagrams) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }

        scanner.close();
    }

    public static boolean areAnagrams(String str1, String str2) {
        // Handle null or empty strings.  If both are null or empty, they're considered anagrams.
        if (str1 == null || str2 == null) {
            return str1 == null && str2 == null;
        }
        if (str1.isEmpty() || str2.isEmpty()) {
            return str1.isEmpty() && str2.isEmpty();
        }


        // Remove whitespace and convert to lowercase for case-insensitive comparison
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // Check if the lengths are different (anagrams must have the same length)
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to character arrays and sort them
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare the sorted character arrays
        return Arrays.equals(charArray1, charArray2);
    }
}