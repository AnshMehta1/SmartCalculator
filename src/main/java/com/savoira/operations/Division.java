package com.savoira.operations;

import com.savoira.Calculable;
import com.savoira.Operation;
import com.savoira.exceptions.DivisionByZeroException;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a division operation using BigDecimal for precision.
 */
public class Division extends Operation implements Calculable {

    /**
     * Creates a division operation.
     *
     * @param firstNumber first operand
     * @param secondNumber second operand
     */
    public Division(double firstNumber, double secondNumber) {
        super(firstNumber, secondNumber);
    }

    /**
     * Calculates the quotient using BigDecimal.
     *
     * @return quotient rounded to 10 decimal places
     * @throws DivisionByZeroException if the divisor is zero
     */
    @Override
    public double calculate() {
        if (getSecondNumber() == 0) {
            throw new DivisionByZeroException("Cannot divide by zero");
        }

        BigDecimal first = BigDecimal.valueOf(getFirstNumber());
        BigDecimal second = BigDecimal.valueOf(getSecondNumber());
        BigDecimal result = first.divide(second, 10, RoundingMode.HALF_UP);

        return result.doubleValue();
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