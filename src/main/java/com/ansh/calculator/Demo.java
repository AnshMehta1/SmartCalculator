public class Demo {

    public static void main(String[] args) {

        BankAccount account1 = new BankAccount("1001", "Ansh", 10000.0);

        BankAccount account2 = new BankAccount("1002", "Rahul", 5000.0);

        // Account 1 - valid operations
        account1.deposit(2000.0);
        account1.withdraw(1500.0);

        // Account 1 - invalid operation
        account1.withdraw(20000.0);

        System.out.println();

        // Account 2 - valid operations
        account2.deposit(1000.0);
        account2.withdraw(2000.0);

        // Account 2 - invalid operation
        account2.deposit(-500.0);

        System.out.println();

        System.out.println(account1);
        System.out.println(account2);
    }
}