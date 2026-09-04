import java.math.BigDecimal;
import java.util.*;

class LoanTransaction {

    private String accountNumber;
    private BigDecimal amount;

    public LoanTransaction(String accountNumber, BigDecimal amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

public class LoanLedger {

    public static void main(String[] args) {

        // List: stores all loan transactions
        List<LoanTransaction> transactions = new ArrayList<>();

        transactions.add(new LoanTransaction("ACC1001", new BigDecimal("1000.00")));
        transactions.add(new LoanTransaction("ACC1002", new BigDecimal("2500.50")));
        transactions.add(new LoanTransaction("ACC1001", new BigDecimal("-200.00")));
        transactions.add(new LoanTransaction("ACC1003", new BigDecimal("500.00")));

        // Map: stores the balance for each account
        Map<String, BigDecimal> balances = new HashMap<>();

        // Set: stores unique active accounts
        Set<String> activeAccounts = new HashSet<>();

        for (LoanTransaction transaction : transactions) {

            String account = transaction.getAccountNumber();
            BigDecimal amount = transaction.getAmount();

            activeAccounts.add(account);
            BigDecimal currentBalance = balances.getOrDefault(account, BigDecimal.ZERO);

            balances.put(account,currentBalance.add(amount));
        }

        System.out.println("Account Balances:");

        for (Map.Entry<String, BigDecimal> entry : balances.entrySet()) {
            System.out.println(
                    entry.getKey() + " : " + entry.getValue()
            );
        }

        System.out.println(
                "Active accounts: " + activeAccounts.size()
        );
    }
}