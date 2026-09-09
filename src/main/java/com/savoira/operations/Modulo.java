package com.savoira.operations;

import com.savoira.Calculable;
import com.savoira.Operation;
import com.savoira.exceptions.ModuloByZeroException;

/**
 * Represents a modulo operation.
 */
public class Modulo extends Operation implements Calculable {

    /**
     * Creates a modulo operation.
     *
     * @param firstNumber the first operand
     * @param secondNumber the second operand
     */
    public Modulo(double firstNumber, double secondNumber) {
        super(firstNumber, secondNumber);
    }

    /**
     * Calculates the remainder of the two operands.
     *
     * @return the remainder
     */
    @Override
    public double calculate() {

        if (getSecondNumber() == 0) {
            throw new ModuloByZeroException(
                    "Cannot calculate modulo by zero"
            );
        }

        return getFirstNumber() % getSecondNumber();
    }

    /**
     * Returns a readable representation of the calculation.
     *
     * @return formatted modulo result
     */
    @Override
    public String toString() {
        return "Modulo: " + getFirstNumber()
                + " % " + getSecondNumber()
                + " = " + calculate();
    }
}