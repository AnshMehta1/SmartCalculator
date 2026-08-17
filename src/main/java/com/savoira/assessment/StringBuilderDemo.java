package com.savoira.assessment;

public class StringBuilderDemo {

    public static String buildReport(String[] items) {
        StringBuilder report = new StringBuilder("Report: ");

        for (int i = 0; i < items.length; i++) {
            report.append(items[i]);

            if (i < items.length - 1) {
                report.append(" | ");
            }
        }

        return report.toString();
    }

    public static void main(String[] args) {
        String[] transactions = {
                "Salary credited",
                "Grocery payment",
                "Electricity bill",
                "UPI transfer",
                "ATM withdrawal"
        };

        System.out.println(buildReport(transactions));

        /*
         * StringBuilder is preferred over String concatenation in a loop
         * because String objects are immutable. Repeated concatenation can
         * create many intermediate String objects, while StringBuilder
         * modifies the same internal buffer and is therefore more efficient.
         */
    }
}