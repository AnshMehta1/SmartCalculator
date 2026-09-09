package com.savoira;

/**
 * Abstract base class for calculator operations.
 * Stores the two operands used by concrete calculator operations.
 */
public abstract class Operation {

    private final double firstNumber;
    private final double secondNumber;

    /**
     * Creates an operation with two operands.
     *
     * @param firstNumber the first operand
     * @param secondNumber the second operand
     */
    protected Operation(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
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
     * Gets the second operand.
     *
     * @return the second operand
     */
    public double getSecondNumber() {
        return secondNumber;
    }

    /**
     * Performs the operation.
     *
     * @return the calculated result
     */
    public abstract double calculate();
}