package com.ansh.w7;

import java.util.Scanner;

public class ATMSimulator {
    private static final double MIN_WITHDRAWAL = 500.0;
    private static final double MAX_WITHDRAWAL = 20_000.0;
    private static final double DENOMINATION = 500.0;
    private static final int MAX_ATTEMPTS = 3;

    private double balance;
    private int attempts;

    public ATMSimulator(double initialBalance) {
        if (initialBalance < 0) throw new IllegalArgumentException("Initial balance cannot be negative.");
        balance = initialBalance;
    }

    public double withdraw(double amount) {
        // Rule 5: no withdrawal is allowed after three failed attempts.
        if (attempts >= MAX_ATTEMPTS) throw new ATMWithdrawalException("Maximum attempts reached. Card locked.");
        // Rule 1: minimum withdrawal is Rs.500.
        if (amount < MIN_WITHDRAWAL) { attempts++; throw new ATMWithdrawalException("Invalid withdrawal: minimum amount is Rs.500."); }
        // Rule 2: maximum withdrawal is Rs.20,000.
        if (amount > MAX_WITHDRAWAL) { attempts++; throw new ATMWithdrawalException("Invalid withdrawal: maximum amount is Rs.20,000."); }
        // Rule 3: amount must be a multiple of Rs.500.
        if (amount % DENOMINATION != 0) { attempts++; throw new ATMWithdrawalException("Invalid withdrawal: amount must be a multiple of Rs.500."); }
        // Rule 4: sufficient balance is required.
        if (amount > balance) { attempts++; throw new ATMWithdrawalException("Insufficient balance."); }
        balance -= amount;
        return balance;
    }

    public double getBalance() { return balance; }
    public int getAttempts() { return attempts; }

    public static class ATMWithdrawalException extends RuntimeException {
        public ATMWithdrawalException(String message) { super(message); }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMSimulator atm = new ATMSimulator(3000.0);
        System.out.println("=== Meridian Bank ATM ===");

        while (atm.getAttempts() < MAX_ATTEMPTS) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            try {
                double newBalance = atm.withdraw(amount);
                System.out.println("Withdrawal successful.");
                System.out.printf("New balance: Rs. %.2f%n", newBalance);
                break;
            } catch (ATMWithdrawalException e) {
                System.out.println(e.getMessage());
                if (atm.getAttempts() >= MAX_ATTEMPTS) System.out.println("Card locked.");
                else System.out.println("Attempts remaining: " + (MAX_ATTEMPTS - atm.getAttempts()));
            }
        }
        scanner.close();
    }
}
