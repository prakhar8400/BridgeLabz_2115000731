import java.io.*;

public class FileReadingComparison {

    public static void main(String[] args) {
        String filePath = "large_file.txt"; // Replace with the actual file path

        // FileReader
        long startTime = System.nanoTime();
        try (FileReader fileReader = new FileReader(filePath)) {
            char[] buffer = new char[1024];
            int charsRead;
            while ((charsRead = fileReader.read(buffer)) != -1) {
                // Process the read characters (e.g., display to console)
                // System.out.print(new String(buffer, 0, charsRead)); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        long fileReaderTime = endTime - startTime;

        // InputStreamReader with FileInputStream
        startTime = System.nanoTime();
        try (InputStream inputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream)) {
            char[] buffer = new char[1024];
            int charsRead;
            while ((charsRead = inputStreamReader.read(buffer)) != -1) {
                // Process the read characters (e.g., display to console)
                // System.out.print(new String(buffer, 0, charsRead)); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        endTime = System.nanoTime();
        long inputStreamReaderTime = endTime - startTime;

        System.out.println("FileReader Time: " + fileReaderTime / 1000000.0 + " ms");
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime / 1000000.0 + " ms");

        if (inputStreamReaderTime < fileReaderTime) {
            System.out.println("InputStreamReader is faster.");
        } else {
            System.out.println("FileReader is faster.");
        }
    }
}
