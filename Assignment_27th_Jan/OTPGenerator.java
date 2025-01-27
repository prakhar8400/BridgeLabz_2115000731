import java.util.Arrays;
import java.util.Random;

public class OTPGenerator {

    public static void main(String[] args) {
        int[] otps = new int[10];

        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
        }

        if (areOTPsUnique(otps)) {
            System.out.println("All OTPs are unique.");
            for (int otp : otps) {
                System.out.println("OTP: " + otp);
            }
        } else {
            System.out.println("Duplicate OTPs found. Please regenerate.");
        }
    }

    /**
     * Generates a 6-digit random OTP number.
     *
     * @return the generated OTP number
     */
    public static int generateOTP() {
        Random rand = new Random();
        return rand.nextInt(900000) + 100000; // Generate a random number between 100000 and 999999
    }

    /**
     * Checks if all OTPs in the array are unique.
     *
     * @param otps the array of OTP numbers
     * @return true if all OTPs are unique, false otherwise
     */
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false; // Duplicate OTP found
                }
            }
        }
        return true; // All OTPs are unique
    }
}