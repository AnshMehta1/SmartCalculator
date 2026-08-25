package com.savoira.w5;

import java.util.Objects;

public abstract class Loan implements Auditable {

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

    @Override
    public String getAuditSummary() {
        return auditPrefix()
                + loanId + " | "
                + applicantName + " | Rs."
                + String.format("%.2f", principal)
                + " | Rate:"
                + String.format("%.2f", annualRate)
                + "%";
    }

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

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Loan)) {
            return false;
        }

        Loan other = (Loan) obj;

        return loanId.equalsIgnoreCase(other.loanId);
    }

    @Override
    public int hashCode() {
        return loanId.toLowerCase().hashCode();
    }
}