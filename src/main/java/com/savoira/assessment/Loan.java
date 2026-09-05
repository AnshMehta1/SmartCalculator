package com.savoira.assessment;

import java.util.Objects;

public abstract class Loan {

    protected final String loanId;
    protected final String applicantName;
    protected final double principalAmount;
    protected final double annualRate;
    protected final int tenureMonths;

    public Loan(String loanId, String applicantName, double principalAmount, double annualRate, int tenureMonths) {
        this.loanId = loanId;
        this.applicantName = applicantName;
        this.principalAmount = principalAmount;
        this.annualRate = annualRate;
        this.tenureMonths = tenureMonths;
    }

    // Each loan type provides its own EMI calculation.
    public abstract double calculateEMI();

    // Common calculation for all loan types.
    public double totalRepayable() {
        return round(calculateEMI() * tenureMonths);
    }

    public void printSummary() {
        System.out.println("=================================");
        System.out.println("Loan ID          : " + loanId);
        System.out.println("Applicant Name   : " + applicantName);
        System.out.println("Principal Amount : ₹" + format(principalAmount));
        System.out.println("Annual Rate      : " + format(annualRate) + "%");
        System.out.println("Tenure           : " + tenureMonths + " months");
        System.out.println("EMI              : ₹" + format(calculateEMI()));
        System.out.println("Total Repayable  : ₹" + format(totalRepayable()));
        System.out.println("=================================");
    }

    public String getLoanId() {
        return loanId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public double getAnnualRate() {
        return annualRate;
    }

    public int getTenureMonths() {
        return tenureMonths;
    }

    protected static double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    protected static String format(double value) {
        return String.format("%.2f", value);
    }

    /*
     * Two Loan objects are equal if their loan IDs are equal,
     * ignoring case.
     *
     * Applicant name, amount, rate, and tenure are intentionally
     * not considered.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Loan other)) {
            return false;
        }

        return loanId.equalsIgnoreCase(other.loanId);
    }

    @Override
    public int hashCode() {
        return loanId.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId='" + loanId + '\'' +
                ", applicantName='" + applicantName + '\'' +
                ", principalAmount=" + principalAmount +
                ", annualRate=" + annualRate +
                ", tenureMonths=" + tenureMonths +
                '}';
    }
}