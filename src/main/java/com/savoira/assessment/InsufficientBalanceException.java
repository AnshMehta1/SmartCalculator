package com.savoira.assessment;

public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(double amount, double balance) {
        super("Insufficient balance for ₹" + amount + ". Available balance: ₹" + balance);
    }
}