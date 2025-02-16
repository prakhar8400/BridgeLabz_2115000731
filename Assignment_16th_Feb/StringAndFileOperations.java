import java.io.*;

public class StringAndFileOperations {

    public static void main(String[] args) throws IOException {
        int numStrings = 1000000;
        String[] stringList = new String[10]; // Array instead of List for slight perf improvement
        for (int i=0; i<10; i++){
            stringList[i] = "hello";
        }


        // StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numStrings; i++) {
            for (String s : stringList) { // Use the array of strings
                sb.append(s); // Append each string from the array
            }

        }
        String resultSB = sb.toString(); // Convert to String (important for timing)
        long endTime = System.nanoTime();
        long durationSB = endTime - startTime;

        // StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < numStrings; i++) {
            for (String s : stringList) { // Use the array of strings
                sbf.append(s); // Append each string from the array
            }
        }
        String resultSBF = sbf.toString(); // Convert to String
        endTime = System.nanoTime();
        long durationSBF = endTime - startTime;

        System.out.println("StringBuilder time: " + durationSB + " nanoseconds");
        System.out.println("StringBuffer time: " + durationSBF + " nanoseconds");

        // File Reading and Word Count
        String filename = "large_file.txt"; // Replace with your file name
        long wordCount = 0;
        startTime = System.nanoTime();

        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");
                wordCount += words.length;
            }
        }
        endTime = System.nanoTime();
        long durationFileRead = endTime - startTime;


        System.out.println("Word count in file: " + wordCount);
        System.out.println("File read time: " + durationFileRead + " nanoseconds");


    }
}
