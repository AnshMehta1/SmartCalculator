package com.savoira.operations;

/**
 * Represents an addition operation.
 */
public class Addition extends Operation implements Calculable {

    /**
     * Creates an addition operation.
     *
     * @param firstNumber the first operand
     * @param secondNumber the second operand
     */
    public Addition(double firstNumber, double secondNumber) {
        super(firstNumber, secondNumber);
    }

    /**
     * Calculates the sum of the two operands.
     *
     * @return the sum
     */
    @Override
    public double calculate() {
        return getFirstNumber() + getSecondNumber();
    }

    /**
     * Returns a readable representation of the calculation.
     *
     * @return formatted addition result
     */
    @Override
    public String toString() {
        return "Addition: " + getFirstNumber()
                + " + " + getSecondNumber()
                + " = " + calculate();
    }
}