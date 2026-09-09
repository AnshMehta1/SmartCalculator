package com.savoira;

import java.util.Scanner;

public class Main {

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

            double result = switch (operator) {
                case "+" -> firstNumber + secondNumber;
                case "-" -> firstNumber - secondNumber;
                case "*" -> firstNumber * secondNumber;

                case "/" -> {
                    if (secondNumber == 0) {
                        System.out.println("Error: division by zero");
                        yield Double.NaN;
                    } else {
                        yield firstNumber / secondNumber;
                    }
                }

                case "%" -> firstNumber % secondNumber;

                default -> {
                    System.out.println("Unknown operator");
                    yield Double.NaN;
                }
            };

            if (!Double.isNaN(result)) {
                System.out.printf("Result: %.2f%n", result);
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}