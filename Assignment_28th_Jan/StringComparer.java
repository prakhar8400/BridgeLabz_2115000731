import java.util.Scanner;

public class StringComparer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        int comparisonResult = compareStrings(str1, str2);

        if (comparisonResult < 0) {
            System.out.println(str1 + " comes before " + str2 + " lexicographically.");
        } else if (comparisonResult > 0) {
            System.out.println(str1 + " comes after " + str2 + " lexicographically.");
        } else {
            System.out.println(str1 + " and " + str2 + " are lexicographically equal.");
        }

        scanner.close();
    }

    public static int compareStrings(String str1, String str2) {
        // Handle null cases (optional, but good practice)
        if (str1 == null && str2 == null) {
            return 0; // Both null, considered equal
        } else if (str1 == null) {
            return -1; // str1 is null, comes before str2
        } else if (str2 == null) {
            return 1;  // str2 is null, str1 comes after
        }

        int i = 0;
        while (i < str1.length() && i < str2.length()) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            if (char1 != char2) {
                return char1 - char2; // Return the difference in ASCII values
            }
            i++;
        }

        // If one string is a prefix of the other
        return str1.length() - str2.length();
    }
}