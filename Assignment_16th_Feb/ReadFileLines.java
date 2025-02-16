import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLines {

    public static void main(String[] args) {
        String filename = "my_file.txt"; // Replace with your file name

        try (FileReader fileReader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
