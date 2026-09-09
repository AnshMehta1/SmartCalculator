package com.savoira.operations;

import com.savoira.Calculable;
import com.savoira.Operation;


/**
 * Represents a subtraction operation.
 */
public class Subtraction extends Operation implements Calculable {

    /**
     * Creates a subtraction operation.
     *
     * @param firstNumber the first operand
     * @param secondNumber the second operand
     */
    public Subtraction(double firstNumber, double secondNumber) {
        super(firstNumber, secondNumber);
    }

    /**
     * Calculates the difference between the two operands.
     *
     * @return the difference
     */
    @Override
    public double calculate() {
        return getFirstNumber() - getSecondNumber();
    }

    /**
     * Returns a readable representation of the calculation.
     *
     * @return formatted subtraction result
     */
    @Override
    public String toString() {
        return "Subtraction: " + getFirstNumber()
                + " - " + getSecondNumber()
                + " = " + calculate();
    }
}