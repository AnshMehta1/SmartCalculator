package com.savoira.w5;

public abstract class Loan {
    protected String loanId;
    protected String applicantName;
    protected double principal;
    protected double annualRate;

    public Loan(String loanId, String applicantName, double principal, double annualRate) {
        this.loanId = loanId;
        this.applicantName = applicantName;
        this.principal = principal;
        this.annualRate = annualRate;
    }

    public abstract double calculateEMI();
    public abstract String loanType();

    public void printSummary() {
        System.out.printf(
            "Loan ID: %s%n" +
            "Applicant: %s%n" +
            "Loan Type: %s%n" +
            "Principal: %.2f%n" +
            "Annual Rate: %.2f%%%n" +
            "Monthly EMI: %.2f%n" +
            "--------------------%n",
            loanId,
            applicantName,
            loanType(),
            principal,
            annualRate,
            calculateEMI()
        );
    }
}