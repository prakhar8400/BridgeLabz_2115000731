import java.util.Scanner;

public class CharacterRemover {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        System.out.print("Enter the character to remove: ");
        char charToRemove = scanner.next().charAt(0); // Read only the first character

        String modifiedString = removeCharacter(inputString, charToRemove);

        System.out.println("Modified String: " + modifiedString);

        scanner.close();
    }

    public static String removeCharacter(String str, char charToRemove) {
        // Handle null or empty string
        if (str == null || str.isEmpty()) {
            return str; // Return the original string if it's null or empty
        }

        // Use StringBuilder for efficient string manipulation (strings are immutable)
        StringBuilder sb = new StringBuilder();

        // Iterate through the input string
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            // If the current character is NOT the character to remove, append it to the StringBuilder
            if (currentChar != charToRemove) {
                sb.append(currentChar);
            }
        }

        // Convert the StringBuilder to a String and return it
        return sb.toString();
    }
}