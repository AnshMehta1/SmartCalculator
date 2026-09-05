package com.savoira.assessment;

public class LoanCalculator {

    // Overload 1
    public boolean assessEligibility(double monthlyIncome) {

        boolean eligible = monthlyIncome > 25_000;

        if (eligible) {
            System.out.println(
                    "Eligible: Monthly income is greater than ₹25,000."
            );
        } else {
            System.out.println(
                    "Not Eligible: Monthly income must be greater than ₹25,000."
            );
        }

        return eligible;
    }

    // Overload 2
    public boolean assessEligibility(double monthlyIncome, double existingEMI) {

        boolean eligible = (monthlyIncome - existingEMI) > 20_000;

        if (eligible) {
            System.out.println(
                    "Eligible: Disposable monthly income is greater than ₹20,000."
            );
        } else {
            System.out.println(
                    "Not Eligible: Disposable monthly income must be greater than ₹20,000."
            );
        }

        return eligible;
    }

    // Overload 3
    public boolean assessEligibility(double monthlyIncome, double existingEMI, int creditScore) {

        boolean incomeEligible = (monthlyIncome - existingEMI) > 20_000;

        boolean creditEligible = creditScore > 650;

        boolean eligible = incomeEligible && creditEligible;

        if (eligible) {
            System.out.println(
                    "Eligible: Income, existing EMI, and credit score meet requirements."
            );
        } else {
            System.out.println(
                    "Not Eligible: Income or credit score requirement not met."
            );
        }

        return eligible;
    }

    public static void main(String[] args) {

        LoanCalculator calculator = new LoanCalculator();

        System.out.println("=== Eligibility Test 1 ===");
        calculator.assessEligibility(30_000);

        System.out.println();

        System.out.println("=== Eligibility Test 2 ===");
        calculator.assessEligibility(50_000, 25_000);

        System.out.println();

        System.out.println("=== Eligibility Test 3 ===");
        calculator.assessEligibility(60_000, 25_000, 720);
    }
}