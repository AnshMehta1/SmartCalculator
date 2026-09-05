# Exception Handling Code Review

## Original Code

```java
public void processPayment(double amount) {
    try {
        if (amount <= 0) throw new Exception("bad");
        // deduct from account
    } catch (Exception e) {
        // silent
    }
}
```

## Problems Identified

### 1. Generic `Exception` is thrown

**Severity:** Major

The method throws `Exception`, which is too generic. It does not clearly describe what went wrong.

Using a specific exception makes the error meaningful to callers and makes it easier to handle different failures appropriately.

**Suggested fix:**

Use a specific exception such as `IllegalArgumentException` for an invalid payment amount.

---

### 2. The exception message `"bad"` is meaningless

**Severity:** Major

The message does not explain why the payment was rejected.

A useful exception message should tell the caller what is wrong and, where appropriate, what value caused the problem.

**Suggested fix:**

Use a descriptive message such as:

```java
"Payment amount must be greater than zero"
```

---

### 3. The exception is silently swallowed

**Severity:** Blocker

The `catch` block contains no action:

```java
catch (Exception e) {
    // silent
}
```

This hides failures from the caller. The caller may believe that the payment was processed successfully even though it actually failed.

It also makes debugging extremely difficult because the original exception and its stack trace are lost.

**Suggested fix:**

Either allow the specific exception to propagate or log/rethrow it appropriately.

---

## Corrected Version

A simple corrected version is:

```java
public void processPayment(double amount) {

    if (amount <= 0) {
        throw new IllegalArgumentException(
                "Payment amount must be greater than zero"
        );
    }

    // Deduct the validated amount from the account.
}
```