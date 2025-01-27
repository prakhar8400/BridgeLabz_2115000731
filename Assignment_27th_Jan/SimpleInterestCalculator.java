 import java.util.Scanner
     public class SimpleInterestCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter Principal Amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rate = scanner.nextDouble();

        System.out.print("Enter Time (in years): ");
        double time = scanner.nextDouble();

        // Calculate simple interest using the method
        double simpleInterest = calculateSimpleInterest(principal, rate, time);

        // Display the result
        System.out.println("The Simple Interest is " + simpleInterest + 
                " for Principal " + principal + 
                ", Rate of Interest " + rate + 
                " and Time " + time);

        scanner.close();
    }

    /**
     * Calculates the simple interest.
     *
     * @param principal the principal amount
     * @param rate the rate of interest
     * @param time the time period in years
     * @return the calculated simple interest
     */
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }
}