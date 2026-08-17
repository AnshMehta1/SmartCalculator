package com.savoira.assessment;

/*
 * Immutability is useful for an AccountHolder in a banking context because
 * customer information such as name, customer ID, and email should not be
 * changed accidentally after the object is created. It also makes the object
 * safer to share and easier to use consistently throughout the application.
 */
public final class AccountHolder {

    private final String name;
    private final String customerId;
    private final String email;

    public AccountHolder(String name, String customerId, String email) {
        this.name = name;
        this.customerId = customerId;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "AccountHolder[name=" + name
                + ", customerId=" + customerId
                + ", email=" + email + "]";
    }

    public static void main(String[] args) {
        AccountHolder holder = new AccountHolder(
                "Priya Sharma",
                "CUST1001",
                "priya@example.com"
        );

        System.out.println(holder);
    }
}