# Debug Analysis

The original `sumEvens()` method contains two bugs.

## Bug 1: Incorrect Initial Value

The original code initializes `sum` to `1`:

```java
int sum = 1;
```

This is incorrect because `sum` should start at `0`. At the beginning of the loop, no numbers have been added yet.

I identified this bug by checking the expected result for `sumEvens(10)`. The even numbers from 1 to 10 are:

```text
2 + 4 + 6 + 8 + 10 = 30
```

Starting `sum` at `1` would add an extra `1` to the result.

The fix is:

```java
int sum = 0;
```

---

## Bug 2: Incorrect Condition

The original code uses:

```java
if (i % 2 == 1)
```

This condition checks whether `i` is **odd**, because odd numbers have a remainder of `1` when divided by `2`.

For example:

```text
1 % 2 = 1  → odd
3 % 2 = 1  → odd
5 % 2 = 1  → odd
```

However, the method is supposed to calculate the sum of **even** numbers.

I identified this bug by checking the condition against the requirement that only even numbers should be added.

The correct condition is:

```java
if (i % 2 == 0)
```

Even numbers have a remainder of `0` when divided by `2`:

```text
2 % 2 = 0
4 % 2 = 0
6 % 2 = 0
```
