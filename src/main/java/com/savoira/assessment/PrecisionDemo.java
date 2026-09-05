package com.savoira.assessment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrecisionDemo {

    public static void main(String[] args) {

        // Floating-point precision problem
        double d1 = 0.1 + 0.2;

        System.out.println("===== FLOATING-POINT PROBLEM =====");
        System.out.println("0.1 + 0.2 using double = " + d1);

        // BigDecimal solution
        BigDecimal bd1 = new BigDecimal("0.1");
        BigDecimal bd2 = new BigDecimal("0.2");

        BigDecimal exactResult = bd1.add(bd2);

        System.out.println();
        System.out.println("===== BIGDECIMAL SOLUTION =====");
        System.out.println("0.1 + 0.2 using BigDecimal = " + exactResult);

        // Compound interest calculation
        BigDecimal principal = new BigDecimal("500000");
        BigDecimal annualRate = new BigDecimal("0.085");

        int years = 3;
        int compoundsPerYear = 12;

        int totalPeriods = years * compoundsPerYear;

        /*
         * Compound interest formula:
         *
         * A = P(1 + r/n)^(nt)
         *
         * P = principal
         * r = annual interest rate
         * n = compounds per year
         * t = number of years
         */

        BigDecimal periodicRate =
                annualRate.divide(
                        BigDecimal.valueOf(compoundsPerYear),
                        20,
                        RoundingMode.HALF_UP
                );

        BigDecimal base = BigDecimal.ONE.add(periodicRate);
        BigDecimal growthFactor = base.pow(totalPeriods);
        BigDecimal finalAmount = principal.multiply(growthFactor);

        finalAmount =
                finalAmount.setScale(
                        2,
                        RoundingMode.HALF_UP
                );

        System.out.println();
        System.out.println("===== COMPOUND INTEREST =====");
        System.out.println("Principal       : ₹" + principal);
        System.out.println("Annual Rate     : 8.50%");
        System.out.println("Period          : 3 years");
        System.out.println("Compounding     : Monthly");
        System.out.println("Final Amount    : ₹" + finalAmount);

        BigDecimal interest = finalAmount.subtract(principal);

        System.out.println("Interest Earned : ₹" + interest);
    }
}