package com.savoira.w5;

public class HomeLoan extends Loan {

    private int tenureMonths;

    public HomeLoan(String loanId, String applicantName, double principal, double annualRate, int tenureMonths) {
        super(loanId, applicantName, principal, annualRate);
        this.tenureMonths = tenureMonths;
    }

    @Override
    public double calculateEMI() {
        double r = annualRate / 12 / 100;
        double factor = Math.pow(1 + r, tenureMonths);
        return (principal * r * factor)
                / (factor - 1);
    }

    @Override
    public String loanType() {
        return "Home Loan";
    }
}