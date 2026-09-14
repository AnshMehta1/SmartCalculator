package com.savoira.assessment;

public class InvalidDenominationException extends Exception {

    public InvalidDenominationException(double amount) {
        super("Withdrawal amount must be a multiple of ₹500. Entered: ₹" + amount);
    }
}