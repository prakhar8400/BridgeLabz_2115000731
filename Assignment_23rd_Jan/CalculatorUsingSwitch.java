import java.util.Scanner;

public class CalculatorUsingSwitch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double first = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double second = scanner.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        String op = scanner.next();

        double result = 0.0;

        switch (op) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                if (second == 0) {
                    System.out.println("Error: Division by zero");
                } else {
                    result = first / second;
                }
                break;
            default:
                System.out.println("Invalid operator");
        }

        if (!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")) {
            System.out.println("Invalid operator");
        } else if (op.equals("/") && second == 0) {
            // Division by zero error already handled in the switch case
        } else {
            System.out.println(first + " " + op + " " + second + " = " + result);
        }

        scanner.close();
    }
}
