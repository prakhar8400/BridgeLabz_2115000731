import java.util.Scanner;

public class CaseToggler {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Call the toggleCase method to get the toggled string
        String toggledString = toggleCase(inputString);

        // Print the toggled string
        System.out.println("Toggled string: " + toggledString);

        // Close the scanner to release resources
        scanner.close();
    }

    // Method to toggle the case of each character in a string
    public static String toggleCase(String str) {
        // Check for null or empty string
        if (str == null || str.isEmpty()) {
            return str;
        }

        // Convert the string to a character array (strings are immutable)
        char[] charArray = str.toCharArray();

        // Iterate through the character array
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];

            // Check if the character is an uppercase letter
            if (Character.isUpperCase(ch)) {
                // Convert to lowercase by adding the difference between 'a' and 'A'
                charArray[i] = Character.toLowerCase(ch); // More concise way
                // or charArray[i] = (char) (ch + 32);  // ASCII difference
            } 
            // Check if the character is a lowercase letter
            else if (Character.isLowerCase(ch)) {
                // Convert to uppercase by subtracting the difference between 'a' and 'A'
                charArray[i] = Character.toUpperCase(ch); // More concise way
                // or charArray[i] = (char) (ch - 32);  // ASCII difference
            }
            //If it is not an alphabet, we don't change it.
        }

        // Create a new string from the modified character array
        return new String(charArray);
    }
}