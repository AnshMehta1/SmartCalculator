# ATM Logic

## Task 1: Pseudocode

```text
START

Set attempts to 0

REPEAT while attempts are less than 3

    Ask the customer for the withdrawal amount

    If withdrawal amount is less than Rs.500
        Display "Invalid amount: minimum withdrawal is Rs.500"
        Increase attempts by 1
        Continue to the next attempt

    If withdrawal amount is greater than Rs.20,000
        Display "Invalid amount: maximum withdrawal is Rs.20,000"
        Increase attempts by 1
        Continue to the next attempt

    If withdrawal amount is not a multiple of Rs.500
        Display "Invalid amount: withdrawal must be a multiple of Rs.500"
        Increase attempts by 1
        Continue to the next attempt

    If withdrawal amount is greater than the available balance
        Display "Insufficient balance"
        Increase attempts by 1
        Continue to the next attempt

    Otherwise
        Subtract the withdrawal amount from the balance
        Dispense the cash
        Display "Withdrawal successful"
        END

END REPEAT

Display "Maximum attempts reached. Card locked."
END
```

---

## Task 3: Dry-run Trace

Given:

```text
Starting balance = 3000
count = 0
txns = {500, -200, 1000, -300, 800}
```

The loop processes one transaction at a time.

| Iteration | `txns[i]` | Balance before | Balance after (`balance += txns[i]`) | `txns[i] > 0`? | Count after |
|---:|---:|---:|---:|:---:|---:|
| 1 | 500 | 3000 | 3500 | Yes | 1 |
| 2 | -200 | 3500 | 3300 | No | 1 |
| 3 | 1000 | 3300 | 4300 | Yes | 2 |
| 4 | -300 | 4300 | 4000 | No | 2 |
| 5 | 800 | 4000 | 4800 | Yes | 3 |

### Step-by-step calculation

```text
Initial balance = 3000
Initial count   = 0

Iteration 1:
balance = 3000 + 500 = 3500
500 > 0, so count = 1

Iteration 2:
balance = 3500 - 200 = 3300
-200 is not greater than 0, so count remains 1

Iteration 3:
balance = 3300 + 1000 = 4300
1000 > 0, so count = 2

Iteration 4:
balance = 4300 - 300 = 4000
-300 is not greater than 0, so count remains 2

Iteration 5:
balance = 4000 + 800 = 4800
800 > 0, so count = 3
```

---

## Task 4: Final Output and Explanation

The final balance is **4800** because all five transactions are added to the starting balance:

```text
3000 + 500 - 200 + 1000 - 300 + 800 = 4800
```

The final deposit count is **3** because the positive transaction values are:

```text
500, 1000, 800
```

There are three positive transactions, so `count` becomes 3.

Therefore, the two `println` statements produce:

```text
Balance: 4800
Deposits: 3
```
