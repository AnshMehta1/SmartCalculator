package com.savoira.assessment;

public class MaximumWithdrawalException extends Exception {

    public MaximumWithdrawalException(double amount) {
        super("Withdrawal amount cannot exceed ₹20,000. Entered: ₹" + amount);
    }
}