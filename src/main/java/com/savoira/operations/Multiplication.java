package com.savoira.operations;

/**
 * Represents a multiplication operation.
 */
public class Multiplication extends Operation implements Calculable {

    /**
     * Creates a multiplication operation.
     *
     * @param firstNumber the first operand
     * @param secondNumber the second operand
     */
    public Multiplication(double firstNumber, double secondNumber) {
        super(firstNumber, secondNumber);
    }

    /**
     * Calculates the product of the two operands.
     *
     * @return the product
     */
    @Override
    public double calculate() {
        return getFirstNumber() * getSecondNumber();
    }

    /**
     * Returns a readable representation of the calculation.
     *
     * @return formatted multiplication result
     */
    @Override
    public String toString() {
        return "Multiplication: " + getFirstNumber()
                + " * " + getSecondNumber()
                + " = " + calculate();
    }
}