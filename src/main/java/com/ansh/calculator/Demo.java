public class Demo {

    public static void main(String[] args) {

        var account1 = new BankAccount("1001", "Ansh", 10000.0);
        var account2 = new BankAccount("1002", "Rahul", 5000.0);

        // Valid operations
        account1.deposit(2000.0);
        account1.withdraw(1500.0);

        account2.deposit(1000.0);
        account2.withdraw(2000.0);

        // Invalid operations
        account1.withdraw(20000.0);
        account2.deposit(-500.0);

        System.out.println();

        System.out.println(account1);
        System.out.println(account2);

        System.out.println();
        System.out.println("Total accounts created: " + BankAccount.getTotalAccounts());

        var loanUtils = new LoanUtils();
        var loanAmount = loanUtils.calculateCompoundAmount(100000.0, 12.0, 12);

        System.out.println("Calculated loan amount: Rs." + loanAmount);
    }
}