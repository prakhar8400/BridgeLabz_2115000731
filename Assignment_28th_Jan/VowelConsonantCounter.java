import java.util.Scanner;

public class VowelConsonantCounter {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Initialize counters for vowels and consonants
        int vowelCount = 0;
        int consonantCount = 0;

        // Convert the string to lowercase to handle both uppercase and lowercase vowels
        inputString = inputString.toLowerCase();

        // Iterate through the string
        for (int i = 0; i < inputString.length(); i++) {
            // Get the character at the current index
            char ch = inputString.charAt(i);

            // Check if the character is an alphabet (a-z)
            if (ch >= 'a' && ch <= 'z') {
                // Check if the character is a vowel
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    // Increment vowel count
                    vowelCount++;
                } else {
                    // Increment consonant count
                    consonantCount++;
                }
            } //If it is not an alphabet, we don't count it as a vowel or consonant.
              //This handles spaces, numbers, and special characters.
        }

        // Print the results
        System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonants: " + consonantCount);

        // Close the scanner to release resources (good practice)
        scanner.close();
    }
}