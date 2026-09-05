package com.savoira.assessment;

public class EducationLoan extends Loan {

    private static final int MORATORIUM_MONTHS = 6;

    public EducationLoan(String loanId, String applicantName, double principalAmount, double annualRate, int tenureMonths) {
        super(loanId, applicantName, principalAmount, annualRate, tenureMonths);
    }

    @Override
    public double calculateEMI() {

        double simpleInterest = principalAmount * (annualRate / 100) * (tenureMonths / 12);
        double totalAmount = principalAmount + simpleInterest;

        return round(totalAmount / tenureMonths);
    }

    @Override
    public double totalRepayable() {

        double normalRepayment = calculateEMI() * tenureMonths;

        // Six months of additional simple interest is charged during the moratorium period.
        double moratoriumInterest = principalAmount * (annualRate / 100) * (MORATORIUM_MONTHS / 12);

        return round(normalRepayment + moratoriumInterest);
    }
}