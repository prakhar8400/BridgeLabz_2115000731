import java.io.*;

public class BinaryToCharacter {

    public static void main(String[] args) {
        String filename = "binary_data.bin"; // Replace with your binary file name
        String charset = "UTF-8"; // Replace with the correct charset

        try (FileInputStream fis = new FileInputStream(filename);
             InputStreamReader isr = new InputStreamReader(fis, charset); // Specify charset here
             BufferedReader br = new BufferedReader(isr)) {

            int character;
            while ((character = br.read()) != -1) {  // Read character by character
                System.out.print((char) character); // Print the character
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.err.println("Unsupported encoding: " + e.getMessage());
        }
    }
}
