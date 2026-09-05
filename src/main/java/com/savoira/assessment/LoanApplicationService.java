package com.savoira.assessment;

public class LoanApplicationService {

    private static final double MIN_INCOME_RATIO = 0.10;
    private static final double MAX_LOAN_AMOUNT = 5_000_000;
    private static final int MIN_CREDIT_SCORE = 650;

    public String applyForLoan(double income, double loanAmount, int creditScore) {

        /*
         * Check income requirement.
         *
         * The applicant must have an income of at least
         * 10% of the requested loan amount.
         */
        double requiredIncome = loanAmount * MIN_INCOME_RATIO;

        if (income < requiredIncome) {

            double shortfall = requiredIncome - income;

            throw new InsufficientIncomeException(
                    String.format(
                            "Insufficient income. Required: ₹%.2f, Provided: ₹%.2f",
                            requiredIncome,
                            income
                    ),
                    shortfall
            );
        }

        /*
         * Loan amount must be greater than zero and
         * must not exceed ₹5,000,000.
         */
        if (loanAmount <= 0 || loanAmount > MAX_LOAN_AMOUNT) {

            throw new InvalidLoanAmountException(
                    String.format(
                            "Invalid loan amount: ₹%.2f. " +
                            "Amount must be greater than ₹0 and at most ₹5,000,000.",
                            loanAmount
                    )
            );
        }

        /*
         * Credit score must be at least 650.
         */
        if (creditScore < MIN_CREDIT_SCORE) {

            throw new CreditScoreBelowThresholdException(
                    "Credit score is below the required threshold of 650. "
                    + "Provided: " + creditScore
            );
        }

        return "APPROVED";
    }
}