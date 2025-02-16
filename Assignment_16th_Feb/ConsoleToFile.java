import java.io.*;

public class ConsoleToFile {

    public static void main(String[] args) {
        String filename = "user_input.txt"; // Replace with your desired file name

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(filename, true); // Append mode (true)
             BufferedWriter bw = new BufferedWriter(fw)) { // Buffered writing

            String userInput;
            System.out.println("Enter text (type 'exit' to quit):");

            while ((userInput = br.readLine()) != null) {
                if (userInput.equalsIgnoreCase("exit")) {
                    break; // Exit the loop if the user types "exit"
                }

                bw.write(userInput);
                bw.newLine(); // Add a new line after each input
                System.out.println("Enter text (type 'exit' to quit):"); // Prompt again
            }

            System.out.println("Input saved to " + filename);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
