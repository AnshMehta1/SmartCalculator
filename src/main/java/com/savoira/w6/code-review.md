# Code Review 

## Problem 1: Using `double` for financial calculations

**Severity: Major**

### Problem
The method uses `double` for the transfer amount:

```java
double amt
```

`double` can introduce floating-point precision errors, which is unsafe for financial calculations.

### Suggested Fix
Use `BigDecimal` instead of `double`:

```java
public void transfer(String from, String to, BigDecimal amt)
```

Use `subtract()` and `add()` for balance calculations.

---

## Problem 2: Catching and ignoring all exceptions

**Severity: Blocker**

### Problem
The code catches the generic `Exception` and silently ignores it:

```java
catch (Exception e) {
    // ignore
}
```

This hides errors and makes it impossible for the caller to know that the transfer failed. It also makes debugging very difficult.

### Suggested Fix
Do not silently ignore exceptions. Validate the inputs and accounts before performing the transfer, and throw a meaningful exception when an error occurs.

For example:

```java
if (!accounts.containsKey(from)) {
    throw new IllegalArgumentException("Source account not found: " + from);
}

if (!accounts.containsKey(to)) {
    throw new IllegalArgumentException("Destination account not found: " + to);
}
```

---

## Problem 3: Transfer is not atomic

**Severity: Blocker**

### Problem
The source account is updated before the destination account:

```java
accounts.get(from).setBalance(
    accounts.get(from).getBalance() - amt
);

accounts.get(to).setBalance(
    accounts.get(to).getBalance() + amt
);
```

If the second operation fails, the money could be deducted from the source account without being added to the destination account.

This can leave the ledger in an inconsistent state.

### Suggested Fix
Validate both accounts and all transfer conditions before modifying either balance.

For example:

```java
Account source = accounts.get(from);
Account destination = accounts.get(to);

if (source == null || destination == null) {
    throw new IllegalArgumentException("Invalid account");
}

// Perform balance updates only after all validation succeeds.
```

---

## Problem 4: No validation of transfer amount or sufficient balance

**Severity: Major**

### Problem
The method does not validate the transfer amount.

It could allow:

- Negative amounts
- Zero amounts
- Transfers greater than the source account balance

For example:

```java
transfer("ACC1001", "ACC1002", -500);
```

could cause unintended balance changes.

### Suggested Fix
Validate that the amount is positive and that the source account has sufficient funds.

With `BigDecimal`:

```java
if (amt.compareTo(BigDecimal.ZERO) <= 0) {
    throw new IllegalArgumentException(
        "Transfer amount must be positive"
    );
}

if (source.getBalance().compareTo(amt) < 0) {
    throw new IllegalArgumentException(
        "Insufficient balance"
    );
}
```

---

## Summary

| # | Problem | Severity | Suggested Fix |
|---|---|---|---|
| 1 | Using `double` for financial calculations | Major | Use `BigDecimal` |
| 2 | Catching and ignoring all exceptions | Blocker | Handle exceptions properly and provide meaningful errors |
| 3 | Transfer is not atomic | Blocker | Validate everything before modifying balances |
| 4 | No validation of amount or sufficient balance | Major | Reject non-positive amounts and insufficient funds |

## Overall Review

The method should be refactored to use `BigDecimal`, validate accounts and transfer amounts before making changes, and avoid silently swallowing exceptions. These changes will improve financial precision, reliability, error handling, and data consistency.