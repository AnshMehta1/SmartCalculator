package com.savoira.assessment;

public class MathUtils {

    private MathUtils() {
        // prevent instantiation — utility class.
    }

    public static double roundToTwoDecimalPlaces(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

    public static double calculateSimpleInterest(double p, double r, double t) {
        return (p * r * t) / 100;
    }

    public static double calculateCompoundInterest(double p, double r, int n, double t) {
        return p * Math.pow(1 + (r / (100 * n)), n * t) - p;
    }
}