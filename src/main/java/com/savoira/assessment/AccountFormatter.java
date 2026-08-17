package com.savoira.assessment;

public class AccountFormatter {

    public static String formatAccountSummary(String name, double balance, String accountType) {

        String formattedName = name.toUpperCase();
        String formattedBalance = String.format("%.2f", balance);

        return "Account Holder: " + formattedName
                + " | Type: " + accountType
                + " | Balance: ₹" + formattedBalance;
    }

    public static void main(String[] args) {

        System.out.println(
                formatAccountSummary("Priya Sharma", 45200.50, "SAVINGS")
        );

        System.out.println(
                formatAccountSummary("Rahul Mehta", 12500, "CURRENT")
        );

        System.out.println(
                formatAccountSummary("Ananya Patel", 98765.75, "SALARY")
        );
    }
}