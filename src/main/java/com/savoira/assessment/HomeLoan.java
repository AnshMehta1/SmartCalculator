package com.savoira.assessment;

public class HomeLoan extends Loan {

    public HomeLoan(String loanId, String applicantName, double principalAmount, double annualRate, int tenureMonths) {
        super(loanId, applicantName, principalAmount, annualRate, tenureMonths);
    }

    @Override
    public double calculateEMI() {

        double monthlyRate = annualRate / 12 / 100;
        int months = tenureMonths;

        double factor = Math.pow(1 + monthlyRate, months);
        
        double emi = principalAmount * monthlyRate * factor / (factor - 1);

        return round(emi);
    }
}