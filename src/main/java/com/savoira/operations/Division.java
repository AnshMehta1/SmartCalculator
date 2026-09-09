package com.savoira.operations;

/**
 * Represents a division operation.
 */
public class Division extends Operation implements Calculable {

    /**
     * Creates a division operation.
     *
     * @param firstNumber the dividend
     * @param secondNumber the divisor
     */
    public Division(double firstNumber, double secondNumber) {
        super(firstNumber, secondNumber);
    }

    /**
     * Calculates the quotient of the two operands.
     *
     * @return the quotient, or Double.NaN when dividing by zero
     */
    @Override
    public double calculate() {
        if (getSecondNumber() == 0) {
            System.out.println("Error: division by zero");
            return Double.NaN;
        }

        return getFirstNumber() / getSecondNumber();
    }

    /**
     * Returns a readable representation of the calculation.
     *
     * @return formatted division result
     */
    @Override
    public String toString() {
        return "Division: " + getFirstNumber()
                + " / " + getSecondNumber()
                + " = " + calculate();
    }
}