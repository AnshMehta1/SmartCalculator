package com.ansh.calculator;

/*
Expected output for the required test cases:

Test Case 1:
Input:
10
3
+
Output:
Result: 13.00

Test Case 2:
Input:
10
0
/
Output:
Error: Division by zero

Test Case 3:
Input:
10
3
^
Output:
Error: Unknown operator '^'

Enter q as the operator to exit the calculator.
*/

import java.util.Scanner;

public class SmartCalc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Smart Calculator");
        System.out.println("Enter q as the operator to exit.");

        while (true) {
            System.out.print("\nEnter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter operator (+, -, *, /, %): ");
            String input = scanner.next();
            
            if (input.equals("q")) {
                System.out.println("Calculator exited.");
                break;
            }

            char operator = input.charAt(0);

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            switch (operator) {
                case '+', '-', '*', '/', '%' -> {
                    if ((operator == '/' || operator == '%') && num2 == 0) {
                        System.out.println("Error: Division by zero");
                    } else {
                        double result = switch (operator) {
                            case '+' -> num1 + num2;
                            case '-' -> num1 - num2;
                            case '*' -> num1 * num2;
                            case '/' -> num1 / num2;
                            case '%' -> num1 % num2;
                            default -> 0; // Unreachable
                        };

                        System.out.printf("Result: %.2f%n", result);
                    }
                }

                default -> System.out.println(
                        "Error: Unknown operator '" + operator + "'"
                );
            }
        }

        scanner.close();
    }
}