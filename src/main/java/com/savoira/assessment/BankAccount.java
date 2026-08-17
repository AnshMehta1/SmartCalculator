package com.savoira.assessment;

public class BankAccount {

    // Fields
    private final String accountNumber;
    private final String holderName;
    private double balance;
    private int transactionCount;

    /**
     * Creates a bank account with the given account number,
     * holder name, and initial balance.
     *
     * @param accountNumber the unique account number
     * @param holderName the name of the account holder
     * @param initialBalance the initial balance of the account
     */
    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }

        if (holderName == null || holderName.isBlank()) {
            throw new IllegalArgumentException("Holder name cannot be empty");
        }

        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        this.transactionCount = 0;
    }

    /**
     * Creates a bank account with an initial balance of 0.0.
     *
     * @param accountNumber the unique account number
     * @param holderName the name of the account holder
     */
    public BankAccount(String accountNumber, String holderName) {
        this(accountNumber, holderName, 0.0);
    }

    /**
     * Deposits the specified amount into the account.
     *
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if the amount is less than or equal to zero
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }

        balance += amount;
        transactionCount++;
    }

    /**
     * Withdraws the specified amount from the account.
     *
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if the amount is less than or equal to zero
     *         or greater than the current balance
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be greater than zero"
            );
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        balance -= amount;
        transactionCount++;
    }

    /**
     * Returns the current account balance.
     *
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the number of successful deposits and withdrawals.
     *
     * @return the transaction count
     */
    public int getTransactionCount() {
        return transactionCount;
    }

    /**
     * Returns a formatted summary of the account.
     *
     * @return the formatted account summary
     */
    public String getSummary() {
        return String.format(
                "Account Number: %s | Holder: %s | Balance: ₹%.2f | Transactions: %d",
                accountNumber,
                holderName,
                balance,
                transactionCount
        );
    }

    public static void main(String[] args) {

        // Create first account using the primary constructor
        BankAccount account1 = new BankAccount("ACC1001", "Priya Sharma", 10000.00);

        // Create second account using the overloaded constructor
        BankAccount account2 = new BankAccount("ACC1002", "Rahul Mehta");

        account1.deposit(5000.00);
        account1.withdraw(2000.00);

        account2.deposit(15000.00);
        account2.withdraw(3000.00);

        // Attempt an invalid negative withdrawal
        try {
            account1.withdraw(-1000.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid operation: " + e.getMessage());
        }

        System.out.println(account1.getSummary());
        System.out.println(account2.getSummary());
    }
}