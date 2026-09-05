package com.savoira.assessment;

import java.util.HashSet;
import java.util.Set;

public class ObjectContractDemo {

    public static void main(String[] args) {

        System.out.println("===== B1: INTERFACES =====");

        /*
         * The object is a HomeLoan, but the reference type
         * is Auditable.
         */
        Auditable a = new HomeLoan("HL001", "Ansh", 5_000_000, 8.5, 240);

        System.out.println("Audit Log:");
        System.out.println(a.getAuditLog());

        System.out.println();

        /*
         * The same type of object can be referenced through
         * the Exportable interface.
         */
        Exportable e = new HomeLoan("HL002", "Rahul", 3_000_000, 9.0, 180);

        System.out.println("CSV Row:");
        System.out.println(e.toCSVRow());

        System.out.println();
        System.out.println("===== B2: EQUALS AND HASHCODE =====");

        HomeLoan loan1 = new HomeLoan("HL100", "Ansh", 5_000_000, 8.5, 240);
        HomeLoan loan2 = new HomeLoan("hl100", "Priya", 3_000_000, 9.0, 180);

        System.out.println("loan1 equals loan2: " + loan1.equals(loan2));
        System.out.println("loan1 hashCode: " + loan1.hashCode());
        System.out.println("loan2 hashCode: " + loan2.hashCode());

        Set<Loan> loans = new HashSet<>();

        loans.add(loan1);
        loans.add(loan2);

        /*
         * HashSet uses hashCode() and equals() to determine
         * whether two objects are duplicates.
         *
         * loan1 and loan2 have the same loanId ignoring case,
         * so equals() returns true and their hash codes match.
         *
         * Therefore only one object remains in the HashSet.
         */
        System.out.println("HashSet size: " + loans.size());
    }
}