package com.savoira.assessment;

public class MathUtilsDemo {

    public static void main(String[] args) {

        double roundedValue = MathUtils.roundToTwoDecimalPlaces(45200.5678);
        double simpleInterest = MathUtils.calculateSimpleInterest(10000, 5, 2);
        double compoundInterest = MathUtils.calculateCompoundInterest(10000, 5, 4, 2);

        System.out.println("Rounded value: " + roundedValue);
        System.out.println("Simple Interest: " + simpleInterest);
        System.out.println("Compound Interest: " + compoundInterest);
    }
}