package com.savoira.assessment;

public class LoanApplicationDemo {

    public static void main(String[] args) {

        LoanApplicationService service = new LoanApplicationService();


        System.out.println("===== SCENARIO 1: ALL PASS =====");

        try {
            String result = service.applyForLoan(100_000, 500_000, 720);
            System.out.println("Result: " + result);
        } catch (LoanException e) {
            System.out.println("Loan application failed: " + e.getMessage());
        } finally {
            System.out.println("Scenario 1 completed.");
        }

        System.out.println();

        System.out.println("===== SCENARIO 2: INCOME TOO LOW =====");

        try {
            service.applyForLoan(30_000,500_000,720);
        } catch (InsufficientIncomeException e) {
            System.out.println("Exception: " + e.getMessage());
            System.out.printf("Income shortfall: ₹%.2f%n", e.getShortfall());
        } catch (LoanException e) {
            System.out.println("Loan exception: " + e.getMessage());
        } finally {
            System.out.println("Scenario 2 completed.");
        }

        System.out.println();

        System.out.println("===== SCENARIO 3: INVALID AMOUNT =====");

        try {
            service.applyForLoan(1_000_000, 6_000_000, 720);
        } catch (InvalidLoanAmountException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (LoanException e) {
            System.out.println("Loan exception: " + e.getMessage());
        } finally {
            System.out.println("Scenario 3 completed.");
        }

        System.out.println();

        System.out.println("===== SCENARIO 4: CREDIT SCORE TOO LOW =====");

        try {
            service.applyForLoan(100_000,500_000,600);
        } catch (CreditScoreBelowThresholdException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (LoanException e) {
            System.out.println("Loan exception: " + e.getMessage());
        } finally {
            System.out.println("Scenario 4 completed.");
        }
    }
}