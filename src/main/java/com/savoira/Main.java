package com.savoira;

import java.util.List;
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

            Calculable operation = createOperation(firstNumber, operator, secondNumber);
            double result = operation.calculate();

            if (!Double.isNaN(result)) {
                System.out.printf("Result: %.2f%n", result);
            }
        }

        System.out.println("Goodbye!");
        runPolymorphismDemo();
        scanner.close();
    }

    /**
     * Creates the appropriate calculator operation.
     *
     * @param firstNumber the first operand
     * @param operator the arithmetic operator
     * @param secondNumber the second operand
     * @return the appropriate calculable operation
     */
    private static Calculable createOperation(double firstNumber, String operator, double secondNumber) {

        return switch (operator) {
            case "+" -> new Addition(firstNumber, secondNumber);
            case "-" -> new Subtraction(firstNumber, secondNumber);
            case "*" -> new Multiplication(firstNumber, secondNumber);
            case "/" -> new Division(firstNumber, secondNumber);
            case "%" -> new Calculable() {
                @Override
                public double calculate() {
                    return firstNumber % secondNumber;
                }

                @Override
                public String toString() {
                    return "Modulus: " + firstNumber
                            + " % " + secondNumber
                            + " = " + calculate();
                }
            };
            default -> {
                System.out.println("Unknown operator");
                yield new Calculable() {
                    @Override
                    public double calculate() {
                        return Double.NaN;
                    }
                };
            }
        };
    }

    /**
     * Demonstrates runtime polymorphism using different operation types.
     */
    private static void runPolymorphismDemo() {
        System.out.println();
        System.out.println("=== Polymorphism Demo ===");

        List<Calculable> operations = List.of(
                new Addition(10, 4),
                new Subtraction(10, 4),
                new Multiplication(10, 4),
                new Division(10, 4)
        );

        for (Calculable operation : operations) {
            System.out.println(operation);
        }
    }
}