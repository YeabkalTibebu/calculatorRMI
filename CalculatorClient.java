import java.rmi.Naming;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            
            Calculator calc = (Calculator) Naming.lookup("CalculatorService");

            Scanner sc = new Scanner(System.in);
            System.out.println("=== RMI Calculator ===");
            System.out.println("Enter two numbers and operation (+ - * /)");
            System.out.println("Type 'exit' to quit\n");

            while (true) {
                System.out.print("First number: ");
                String line = sc.nextLine();
                
                if (line.trim().equalsIgnoreCase("exit")) {
                    break;
                }

                int num1;
                try {
                    num1 = Integer.parseInt(line.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number!");
                    continue;
                }

                System.out.print("Second number: ");
                int num2 = Integer.parseInt(sc.nextLine().trim());

                System.out.print("Operation (+ - * /): ");
                String op = sc.nextLine().trim();

                double result = 0;
                boolean valid = true;

                switch (op) {
                    case "+":
                        result = calc.add(num1, num2);
                        break;
                    case "-":
                        result = calc.subtract(num1, num2);
                        break;
                    case "*":
                        result = calc.multiply(num1, num2);
                        break;
                    case "/":
                        result = calc.divide(num1, num2);
                        break;
                    default:
                        System.out.println("Invalid operation! Use +, -, *, or /");
                        valid = false;
                }

                if (valid) {
                    System.out.println("Result: " + result);
                }
                System.out.println();
            }

            System.out.println("Thank you for using RMI Calculator!");
            sc.close();

        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}