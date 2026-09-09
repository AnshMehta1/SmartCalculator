package com.savoira.operations;

/**
 * Represents a percentage calculation.
 */
public class Percentage extends Operation implements Calculable {

    /**
     * Creates a percentage operation.
     *
     * @param number the original number
     * @param percentage the percentage value
     */
    public Percentage(double number, double percentage) {
        super(number, percentage);
    }

    /**
     * Calculates the given percentage of the first number.
     *
     * @return the calculated percentage
     */
    @Override
    public double calculate() {
        return getFirstNumber() * getSecondNumber() / 100;
    }

    /**
     * Returns a readable representation of the calculation.
     *
     * @return formatted percentage result
     */
    @Override
    public String toString() {
        return "Percentage: " + getSecondNumber()
                + "% of " + getFirstNumber()
                + " = " + calculate();
    }
}