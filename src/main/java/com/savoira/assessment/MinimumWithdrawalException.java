package com.savoira.assessment;

public class MinimumWithdrawalException extends Exception {

    public MinimumWithdrawalException(double amount) {
        super("Withdrawal amount must be at least ₹500. Entered: ₹" + amount);
    }
}