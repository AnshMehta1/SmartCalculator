package com.savoira;

/**
 * Represents a calculator operation containing two operands and an operator.
 */
public class Operation {

    private final double firstNumber;
    private final String operator;
    private final double secondNumber;

    /**
     * Creates an operation with two operands and an operator.
     *
     * @param firstNumber the first operand
     * @param operator the arithmetic operator
     * @param secondNumber the second operand
     */
    public Operation(double firstNumber, String operator, double secondNumber) {
        this.firstNumber = firstNumber;
        this.operator = operator;
        this.secondNumber = secondNumber;
    }

    /**
     * Gets the first operand.
     *
     * @return the first operand
     */
    public double getFirstNumber() {
        return firstNumber;
    }

    /**
     * Gets the operator.
     *
     * @return the arithmetic operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Gets the second operand.
     *
     * @return the second operand
     */
    public double getSecondNumber() {
        return secondNumber;
    }
}