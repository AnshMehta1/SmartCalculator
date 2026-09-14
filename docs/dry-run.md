# Dry Run

## Initial State

Before calling `withdraw(7500)`, the ATM object is initialized with:

| Variable | Value |
|---|---:|
| `balance` | ₹10,000 |
| `attempts` | 0 |
| `amount` | ₹7,500 |

The call is:

```java
atm.withdraw(7500);
```

---

## Step 1 — Check Minimum Withdrawal

The method checks:

```java
if (amount < 500)
```

Values:

| Variable | Value |
|---|---:|
| `balance` | ₹10,000 |
| `attempts` | 0 |
| `amount` | ₹7,500 |

Evaluation:

```text
7500 < 500 → false
```

The minimum withdrawal rule is satisfied.

No exception is thrown.

---

## Step 2 — Check Maximum Withdrawal

The method checks:

```java
if (amount > 20000)
```

Values:

| Variable | Value |
|---|---:|
| `balance` | ₹10,000 |
| `attempts` | 0 |
| `amount` | ₹7,500 |

Evaluation:

```text
7500 > 20000 → false
```

The maximum withdrawal rule is satisfied.

No exception is thrown.

---

## Step 3 — Check Withdrawal Denomination

The method checks:

```java
if (amount % 500 != 0)
```

Values:

| Variable | Value |
|---|---:|
| `balance` | ₹10,000 |
| `attempts` | 0 |
| `amount` | ₹7,500 |

Evaluation:

```text
7500 % 500 = 0
0 != 0 → false
```

₹7,500 is a valid multiple of ₹500.

No exception is thrown.

---

## Step 4 — Check Sufficient Balance

The method checks:

```java
if (amount > balance)
```

Values:

| Variable | Value |
|---|---:|
| `balance` | ₹10,000 |
| `attempts` | 0 |
| `amount` | ₹7,500 |

Evaluation:

```text
7500 > 10000 → false
```

The account has sufficient funds.

No exception is thrown.

---

## Step 5 — Perform Withdrawal

The method executes:

```java
balance -= amount;
```

Before withdrawal:

| Variable | Value |
|---|---:|
| `balance` | ₹10,000 |
| `attempts` | 0 |
| `amount` | ₹7,500 |

Calculation:

```text
balance = 10000 - 7500
balance = 2500
```

After withdrawal:

| Variable | Value |
|---|---:|
| `balance` | ₹2,500 |
| `attempts` | 0 |
| `amount` | ₹7,500 |

The method returns:

```text
₹2,500
```

---

## Final Result

```text
Withdrawal amount: ₹7,500
Initial balance:   ₹10,000
Amount withdrawn:  ₹7,500
Final balance:     ₹2,500
Attempts:          0
```

Therefore:

```java
atm.withdraw(7500);
```

successfully withdraws **₹7,500**, leaving a balance of **₹2,500**.