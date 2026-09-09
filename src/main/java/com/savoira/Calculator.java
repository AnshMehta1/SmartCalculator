package com.savoira;

/**
 * Provides calculator utility operations.
 */
public class Calculator {

    /**
     * Calculates a percentage of a number.
     *
     * @param number the original number
     * @param percentage the percentage value
     * @return the calculated percentage
     */
    public static double percentage(double number, double percentage) {
        return number * percentage / 100;
    }

    /**
     * Calculates the square root of a number.
     *
     * @param number the number
     * @return the square root
     */
    public static double squareRoot(double number) {
        return Math.sqrt(number);
    }
}