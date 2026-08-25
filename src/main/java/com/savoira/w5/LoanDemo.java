package com.savoira.w5;

import java.util.ArrayList;
import java.util.List;

public class LoanDemo {
    public static void main(String[] args) {

        List<Loan> loans = new ArrayList<>();

        loans.add(new HomeLoan("HL101", "Rahul Sharma", 5000000, 8.5, 240));
        loans.add(new PersonalLoan("PL201", "Priya Patel", 500000, 12.0, 60));
        loans.add(new PersonalLoan("PL202", "Amit Shah", 300000, 10.5, 36));

        for (Loan loan : loans) {
            System.out.println("Loan Type: " + loan.loanType());
            loan.printSummary();
        }
    }
}