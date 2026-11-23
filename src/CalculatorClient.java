import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Client that sends calculator requests to the remote server.
 */
public class CalculatorClient {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String host = args.length > 0 ? args[0] : "localhost";

            Registry registry = LocateRegistry.getRegistry(host, 1099);
            CalculatorService calculator =
                    (CalculatorService) registry.lookup("CalculatorService");

            System.out.println("Connected to Calculator RMI Server.");

            System.out.print("Enter first number: ");
            double first = scanner.nextDouble();

            System.out.print("Enter operator (+, -, *, /): ");
            String operator = scanner.next();

            System.out.print("Enter second number: ");
            double second = scanner.nextDouble();

            double result;
            switch (operator) {
                case "+":
                    result = calculator.add(first, second);
                    break;
                case "-":
                    result = calculator.subtract(first, second);
                    break;
                case "*":
                    result = calculator.multiply(first, second);
                    break;
                case "/":
                    result = calculator.divide(first, second);
                    break;
                default:
                    System.out.println("Invalid operator. Use +, -, * or /.");
                    return;
            }

            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Calculation error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
