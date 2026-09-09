package com.savoira;

public class Operation {

    private final double firstNumber;
    private final String operator;
    private final double secondNumber;

    public Operation(double firstNumber, String operator, double secondNumber) {
        this.firstNumber = firstNumber;
        this.operator = operator;
        this.secondNumber = secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public String getOperator() {
        return operator;
    }

    public double getSecondNumber() {
        return secondNumber;
    }
}