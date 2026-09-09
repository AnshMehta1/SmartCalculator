package com.savoira.operations;

import com.savoira.Calculable;
import com.savoira.Operation;


/**
 * Represents a square root operation.
 */
public class SquareRoot extends Operation implements Calculable {

    /**
     * Creates a square root operation.
     *
     * @param number the number whose square root is required
     */
    public SquareRoot(double number) {
        super(number, 0);
    }

    /**
     * Calculates the square root.
     *
     * @return the square root of the number
     */
    @Override
    public double calculate() {
        return Math.sqrt(getFirstNumber());
    }

    /**
     * Returns a readable representation of the calculation.
     *
     * @return formatted square root result
     */
    @Override
    public String toString() {
        return "Square Root: √" + getFirstNumber()
                + " = " + calculate();
    }
}