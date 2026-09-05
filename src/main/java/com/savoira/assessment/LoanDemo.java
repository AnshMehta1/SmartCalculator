package com.savoira.assessment;

import java.util.ArrayList;
import java.util.List;

public class LoanDemo {

    public static void main(String[] args) {

        List<Loan> loans = new ArrayList<>();

        loans.add(new HomeLoan("HL001", "Ansh", 5_000_000, 8.5, 240));
        loans.add(new PersonalLoan("PL001", "Rahul", 500_000, 12.0, 60));
        loans.add(new EducationLoan("EL001", "Priya", 800_000, 7.5, 60));

        /*
         * Runtime polymorphism:
         *
         * The List contains Loan references, but each object's
         * overridden calculateEMI() method is called according
         * to the actual object type at runtime.
         */
        for (Loan loan : loans) {
            loan.printSummary();
        }
    }
}