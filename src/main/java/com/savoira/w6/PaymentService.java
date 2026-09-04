package com.savoira.w6;

public class PaymentService {

    private double balance;

    public PaymentService(double balance) {
        this.balance = balance;
    }

    public void processPayment(double amount) {

        if (amount < 0) {
            throw new InvalidAmountException(
                "Payment amount cannot be negative: Rs." + amount
            );
        }

        if (amount > 200000) {
            throw new DailyLimitExceededException(
                "Payment amount exceeds daily limit of Rs.200000: Rs." + amount,
                amount
            );
        }

        if (amount > balance) {
            double shortfall = amount - balance;

            throw new InsufficientFundsException(
                "Insufficient funds. Shortfall: Rs." + shortfall,
                shortfall
            );
        }

        balance -= amount;

        System.out.println(
            "Payment of Rs." + amount +
            " processed. New balance: Rs." + balance
        );
    }

    public static void main(String[] args) {

        PaymentService service = new PaymentService(50000);

        try {
            service.processPayment(15000);
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Attempt complete.");
        }

        try {
            service.processPayment(-500);
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Attempt complete.");
        }

        try {
            service.processPayment(250000);
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Attempt complete.");
        }

        try {
            service.processPayment(40000);
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Attempt complete.");
        }

        try {
            service.processPayment(10000);
        } catch (PaymentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Attempt complete.");
        }
    }
}