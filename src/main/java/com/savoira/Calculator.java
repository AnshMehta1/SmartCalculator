package com.savoira;

public class Calculator {

    public double calculate(Operation operation) {
        double firstNumber = operation.getFirstNumber();
        String operator = operation.getOperator();
        double secondNumber = operation.getSecondNumber();

        return switch (operator) {
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
    }

    public static double percentage(double number, double percentage) {
        return number * percentage / 100;
    }

    public static double squareRoot(double number) {
        return Math.sqrt(number);
    }
}