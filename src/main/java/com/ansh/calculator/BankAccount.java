public class BankAccount {

    private String accountNumber;
    private String holderName;
    private double balance;
    private int transactionCount;

    // Primary constructor
    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be empty.");
        }

        if (holderName == null || holderName.isBlank()) {
            throw new IllegalArgumentException("Holder name cannot be empty.");
        }

        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        this.transactionCount = 0;
    }

    // Secondary constructor
    public BankAccount(String accountNumber, String holderName) {
        this(accountNumber, holderName, 0.0);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit: amount must be greater than zero.");
            return;
        }

        balance += amount;
        transactionCount++;

        System.out.println("Deposited Rs." + amount + " into " + accountNumber);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal: amount must be greater than zero.");
            return;
        }

        if (amount > balance) {
            System.out.println("Invalid withdrawal: insufficient balance.");
            return;
        }

        balance -= amount;
        transactionCount++;

        System.out.println("Withdrawn Rs." + amount + " from " + accountNumber);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    @Override
    public String toString() {
        return "ACC" + accountNumber
                + " | " + holderName
                + " | Balance: Rs." + balance
                + " | Txn: " + transactionCount;
    }
}