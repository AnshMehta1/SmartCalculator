package com.savoira;

/**
 * Performs calculations for SmartCalculator.
 */
public class Calculator {

    /**
     * Calculates the result of the supplied operation.
     *
     * @param operation the operation to perform
     * @return the result of the calculation, or Double.NaN if the operation
     *         is invalid or division by zero is attempted
     */
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

    /**
     * Calculates a percentage of a number.
     *
     * @param number the original number
     * @param percentage the percentage to calculate
     * @return the calculated percentage
     */
    public static double percentage(double number, double percentage) {
        return number * percentage / 100;
    }

    /**
     * Calculates the square root of a number.
     *
     * @param number the number whose square root is required
     * @return the square root of the number
     */
    public static double squareRoot(double number) {
        return Math.sqrt(number);
    }
}