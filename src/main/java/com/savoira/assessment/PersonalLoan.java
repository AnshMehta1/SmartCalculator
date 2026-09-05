package com.savoira.assessment;

public class PersonalLoan extends Loan {

    public PersonalLoan(String loanId, String applicantName, double principalAmount, double annualRate, int tenureMonths) {
        super(loanId, applicantName, principalAmount, annualRate, tenureMonths);
    }

    @Override
    public double calculateEMI() {

        double simpleInterest = principalAmount * (annualRate / 100) * (tenureMonths / 12);
        double totalAmount = principalAmount + simpleInterest;
        
        return round(totalAmount / tenureMonths);
    }
}