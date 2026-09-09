package com.savoira;

import java.util.Scanner;

/**
 * Entry point for the SmartCalculator command-line application.
 */
public class Main {

    /**
     * Starts the SmartCalculator application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("=== SmartCalculator ===");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("Enter first number (or 'exit'): ");

            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            double firstNumber = Double.parseDouble(input);

            System.out.print("Enter operator (+ - * / %): ");
            String operator = scanner.nextLine().trim();

            System.out.print("Enter second number: ");
            double secondNumber = Double.parseDouble(scanner.nextLine().trim());

            Operation operation = new Operation(firstNumber, operator, secondNumber);
            double result = calculator.calculate(operation);

            if (!Double.isNaN(result)) {
                System.out.printf("Result: %.2f%n", result);
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}