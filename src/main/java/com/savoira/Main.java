package com.savoira;

import com.savoira.exceptions.DivisionByZeroException;
import com.savoira.exceptions.InvalidOperationException;
import com.savoira.exceptions.ModuloByZeroException;
import com.savoira.exceptions.NegativeSquareRootException;
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

            try {

                System.out.print("Enter first number (or 'exit'): ");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                double firstNumber = Double.parseDouble(input);

                System.out.print("Enter operator (+ - * / % sqrt percentage): ");

                String operator = scanner.nextLine().trim();
                Calculable operation;

                if (operator.equalsIgnoreCase("sqrt")) {
                    operation = new SquareRoot(firstNumber);
                } else {

                    if (!isValidOperator(operator) && !operator.equalsIgnoreCase("percentage")) {
                        throw new InvalidOperationException("Unknown operator: " + operator);
                    }

                    System.out.print("Enter second number: ");
                    double secondNumber = Double.parseDouble(scanner.nextLine().trim());
                    operation = createOperation(firstNumber, operator, secondNumber);
                }

                double result = operation.calculate();
                System.out.printf("Result: %.2f%n", result);
            } catch (InvalidOperationException | DivisionByZeroException | ModuloByZeroException | NegativeSquareRootException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid numbers.");
            }
        }

        System.out.println("Goodbye!");
        runPolymorphismDemo();
        scanner.close();
    }

    /**
     * Checks whether the supplied operator is one of the
     * supported arithmetic operators.
     *
     * @param op operator to validate
     * @return true if the operator is valid, otherwise false
     */
    private static boolean isValidOperator(String op) {
        return switch (op) {
            case "+", "-", "*", "/", "%" -> true;
            default -> false;
        };
    }

    /**
     * Creates an operation based on the supplied operator.
     *
     * @param firstNumber first operand
     * @param operator operator entered by the user
     * @param secondNumber second operand
     * @return corresponding calculator operation
     * @throws InvalidOperationException if the operator is unsupported
     */
    private static Calculable createOperation(double firstNumber, String operator, double secondNumber) {

        return switch (operator.toLowerCase()) {
            case "+" -> new Addition(firstNumber, secondNumber);
            case "-" -> new Subtraction(firstNumber, secondNumber);
            case "*" -> new Multiplication(firstNumber, secondNumber);
            case "/" -> new Division(firstNumber, secondNumber);
            case "%" -> new Modulo(firstNumber, secondNumber);
            case "percentage" -> new Percentage(firstNumber, secondNumber);
            default -> throw new InvalidOperationException("Unknown operator: " + operator);
        };
    }

    /**
     * Demonstrates runtime polymorphism.
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