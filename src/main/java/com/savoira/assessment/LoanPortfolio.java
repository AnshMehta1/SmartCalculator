package com.savoira.assessment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LoanPortfolio {

    public static void main(String[] args) {

        // D1.1 - List<Loan>
        List<Loan> loans = new ArrayList<>();

        loans.add(new HomeLoan("HL001", "Ansh", 5_000_000, 8.5, 240));
        loans.add(new PersonalLoan("PL001", "Rahul", 500_000, 12.0, 60));
        loans.add(new EducationLoan("EL001", "Priya", 800_000, 7.5, 60));

        System.out.println("===== LOAN PORTFOLIO =====");
        System.out.println("Total loans: " + loans.size());

        // D1.2 - Map<String, Loan>
        Map<String, Loan> loanMap = new HashMap<>();

        for (Loan loan : loans) {
            loanMap.put(loan.getLoanId(), loan);
        }

        System.out.println();
        System.out.println("===== MAP LOOKUP =====");

        // Successful lookup
        Loan foundLoan = loanMap.get("HL001");

        if (foundLoan != null) {
            System.out.println(
                    "Successful lookup: "
                    + foundLoan.getLoanId()
                    + " - "
                    + foundLoan.getApplicantName()
            );
        }

        // Failed lookup
        Loan missingLoan = loanMap.get("HL999");

        if (missingLoan == null) {
            System.out.println(
                    "Failed lookup: Loan HL999 was not found."
            );
        }

        // D1.3 - Set<String>
        Set<String> applicantNames = new HashSet<>();

        for (Loan loan : loans) {
            applicantNames.add(loan.getApplicantName());
        }

        System.out.println();
        System.out.println("===== UNIQUE APPLICANTS =====");
        System.out.println(
                "Unique applicant count: "
                + applicantNames.size()
        );

        System.out.println("Applicants: " + applicantNames);

        // D1.4 - for-each loop
        System.out.println();
        System.out.println("===== FOR-EACH ITERATION =====");

        for (Loan loan : loans) {
            System.out.println(
                    loan.getLoanId()
                    + " -> "
                    + loan.getApplicantName()
            );
        }

        // D1.4 - Iterator
        System.out.println();
        System.out.println("===== ITERATOR ITERATION =====");

        Iterator<Loan> iterator = loans.iterator();

        while (iterator.hasNext()) {

            Loan loan = iterator.next();

            System.out.println(
                    loan.getLoanId()
                    + " -> "
                    + loan.getApplicantName()
            );
        }
    }
}