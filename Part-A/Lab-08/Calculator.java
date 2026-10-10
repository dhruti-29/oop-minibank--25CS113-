import java.util.Scanner;

class DivideByZeroException extends Exception {

    public DivideByZeroException() {
        super("Cannot divide by zero");
    }
}

public class Calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean success = false;

        while (!success) {

            try {

                System.out.print("Enter first number: ");
                double a = Double.parseDouble(sc.nextLine());

                System.out.print("Enter operator: ");
                String op = sc.nextLine();

                System.out.print("Enter second number: ");
                double b = Double.parseDouble(sc.nextLine());

                double result;

                if (op.equals("/") && b == 0) {
                    throw new DivideByZeroException();
                }

                if (op.equals("+")) {
                    result = a + b;
                } else if (op.equals("-")) {
                    result = a - b;
                } else if (op.equals("*")) {
                    result = a * b;
                } else if (op.equals("/")) {
                    result = a / b;
                } else {
                    System.out.println("Invalid operator");
                    continue;
                }

                System.out.println("Result: " + result);
                success = true;

            } catch (NumberFormatException e) {

                System.out.println("Invalid number");

            } catch (DivideByZeroException e) {

                System.out.println(e.getMessage());

            } finally {

                System.out.println("Attempt completed");
            }
        }

        sc.close();
    }
}