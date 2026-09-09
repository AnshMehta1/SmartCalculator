package com.savoira;

import com.savoira.operations.Addition;
import com.savoira.operations.Division;
import com.savoira.operations.Modulo;
import com.savoira.operations.Multiplication;
import com.savoira.operations.Percentage;
import com.savoira.operations.SquareRoot;
import com.savoira.operations.Subtraction;

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

            System.out.print("Enter operator (+ - * / % sqrt): ");
            String operator = scanner.nextLine().trim();

            Calculable operation;

            if (operator.equalsIgnoreCase("sqrt")) {
                operation = new SquareRoot(firstNumber);
            } else {
                System.out.print("Enter second number: ");
                double secondNumber = Double.parseDouble(scanner.nextLine().trim());
                operation = createOperation(firstNumber, operator, secondNumber);
            }

            if (operation == null) {
                continue;
            }

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
     * Creates an operation based on the supplied operator.
     *
     * @param firstNumber the first operand
     * @param operator the arithmetic operator
     * @param secondNumber the second operand
     * @return the appropriate calculator operation, or null for an invalid operator
     */
    private static Calculable createOperation(double firstNumber, String operator, double secondNumber) {

        return switch (operator) {
            case "+" -> new Addition(firstNumber, secondNumber);
            case "-" -> new Subtraction(firstNumber, secondNumber);
            case "*" -> new Multiplication(firstNumber, secondNumber);
            case "/" -> new Division(firstNumber, secondNumber);
            case "%" -> new Modulo(firstNumber, secondNumber);
            default -> {
                System.out.println("Unknown operator");
                yield null;
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
                new Division(10, 4),
                new Modulo(10, 4),
                new Percentage(200, 10),
                new SquareRoot(25)
        );

        for (Calculable operation : operations) {
            System.out.println(operation);
        }
    }
}