Git featurepublic class StringReverser {

    public static String reverseString(String str) {
        if (str == null || str.isEmpty()) {
            return str; // Handle null or empty input
        }

        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String inputString = "hello";
        String reversedString = reverseString(inputString);
        System.out.println("Original string: " + inputString);
        System.out.println("Reversed string: " + reversedString);

        inputString = ""; // Test with empty string
        reversedString = reverseString(inputString);
        System.out.println("Original string: " + inputString);
        System.out.println("Reversed string: " + reversedString);


        inputString = null; // Test with null string
        reversedString = reverseString(inputString);
        System.out.println("Original string: " + inputString);
        System.out.println("Reversed string: " + reversedString);


        inputString = "a"; // Test with single char string
        reversedString = reverseString(inputString);
        System.out.println("Original string: " + inputString);
        System.out.println("Reversed string: " + reversedString);


    }
}
