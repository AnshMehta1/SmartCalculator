package com.savoira.assessment;

public class CreditScoreBelowThresholdException extends LoanException {

    public CreditScoreBelowThresholdException(String message) {
        super(message);
    }
}