public class StringConcatenationBenchmark {

    public static void main(String[] args) {
        int numStrings = 1000000; // 1 million strings

        // StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numStrings; i++) {
            sb.append("hello");
        }
        String resultSB = sb.toString(); // Important: Convert to String to finalize the operation
        long endTime = System.nanoTime();
        long durationSB = endTime - startTime;

        // StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < numStrings; i++) {
            sbf.append("hello");
        }
        String resultSBF = sbf.toString(); // Important: Convert to String
        endTime = System.nanoTime();
        long durationSBF = endTime - startTime;

        System.out.println("StringBuilder time: " + durationSB + " nanoseconds");
        System.out.println("StringBuffer time: " + durationSBF + " nanoseconds");

        // Verification (optional, but good practice): Ensure both results are the same
        if (!resultSB.equals(resultSBF)) {
            System.out.println("ERROR: Results are different!");
        }

    }
}
