public class StringConcatenationPerformance {

    public static void main(String[] args) {
        int numStrings = 1000000; // Number of strings to concatenate

        // Create a string array
        String[] strings = new String[numStrings];
        for (int i = 0; i < numStrings; i++) {
            strings[i] = "str" + i; 
        }

        long startTime, endTime;

        // String concatenation
        startTime = System.nanoTime();
        String stringResult = "";
        for (String str : strings) {
            stringResult += str;
        }
        endTime = System.nanoTime();
        long stringTime = endTime - startTime;

        // StringBuilder concatenation
        startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strings) {
            stringBuilder.append(str);
        }
        String stringBuilderResult = stringBuilder.toString();
        endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;

        // StringBuffer concatenation
        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strings) {
            stringBuffer.append(str);
        }
        String stringBufferResult = stringBuffer.toString();
        endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;

        System.out.println("String Concatenation Time: " + stringTime / 1000000.0 + " ms");
        System.out.println("StringBuilder Concatenation Time: " + stringBuilderTime / 1000000.0 + " ms");
        System.out.println("StringBuffer Concatenation Time: " + stringBufferTime / 1000000.0 + " ms");

        // Verify results (optional)
        if (stringResult.equals(stringBuilderResult) && stringResult.equals(stringBufferResult)) {
            System.out.println("All results are equal.");
        }
    }
}
