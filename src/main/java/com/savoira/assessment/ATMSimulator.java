package com.savoira.assessment;

import java.util.Scanner;

public class ATMSimulator {

    private double balance = 10000;

    public double withdraw(double amount)
            throws MinimumWithdrawalException,
                   MaximumWithdrawalException,
                   InsufficientBalanceException,
                   InvalidDenominationException {

        // Rule 1: Minimum withdrawal
        if (amount < 500) {
            throw new MinimumWithdrawalException(amount);
        }

        // Rule 2: Maximum withdrawal
        if (amount > 20000) {
            throw new MaximumWithdrawalException(amount);
        }

        // Rule 3: Must be a multiple of ₹500
        if (amount % 500 != 0) {
            throw new InvalidDenominationException(amount);
        }

        // Rule 4: Sufficient balance
        if (amount > balance) {
            throw new InsufficientBalanceException(amount, balance);
        }

        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        ATMSimulator atm = new ATMSimulator();

        try (Scanner scanner = new Scanner(System.in)) {

            int attempts = 0;

            while (attempts < 3) {

                System.out.print("Enter withdrawal amount: ");

                if (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a numeric amount.");

                    scanner.next();
                    attempts++;
                    continue;
                }

                double amount = scanner.nextDouble();

                try {
                    double newBalance = atm.withdraw(amount);

                    System.out.println("Withdrawal successful.");
                    System.out.println("New balance: ₹" + newBalance);

                    return;

                } catch (MinimumWithdrawalException | MaximumWithdrawalException | InsufficientBalanceException | InvalidDenominationException e) {
                    attempts++;
                    System.out.println("Withdrawal failed: " + e.getMessage());
                }
            }

            System.out.println("Card locked.");
        }
    }
}