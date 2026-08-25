package com.savoira.w5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoanDemo {

    public static void main(String[] args) {

        List<Loan> loans = new ArrayList<>();

        HomeLoan homeLoan = new HomeLoan("HL101", "Rahul Sharma", 5000000, 8.5, 240);
        PersonalLoan personalLoan1 = new PersonalLoan("PL201", "Priya Patel", 500000, 12.0, 60);
        PersonalLoan personalLoan2 = new PersonalLoan("PL202", "Amit Shah", 300000, 10.5, 36);

        loans.add(homeLoan);
        loans.add(personalLoan1);
        loans.add(personalLoan2);

        // Runtime polymorphism
        for (Loan loan : loans) {
            loan.printSummary();
        }

        // Auditable interface reference
        Auditable auditableLoan = homeLoan;
        System.out.println(auditableLoan.getAuditSummary());

        // Exportable interface reference
        Exportable exportableLoan = personalLoan1;
        System.out.println(exportableLoan.toCSVRow());

        // equals() and hashCode() demonstration
        HomeLoan duplicateHomeLoan = new HomeLoan("hl101", "Another Applicant", 6000000, 9.0, 180);

        Set<Loan> loanSet = new HashSet<>();

        loanSet.add(homeLoan);
        loanSet.add(duplicateHomeLoan);

        System.out.println("HashSet size: " + loanSet.size());
    }
}