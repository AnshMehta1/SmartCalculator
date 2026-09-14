# Big-O Analysis

## Block X

```java
for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
        System.out.println(i + "," + j);
```

### Time Complexity: O(n²)

The outer loop executes `n` times.

For every iteration of the outer loop, the inner loop also executes `n` times.

Therefore:

```text
n × n = n²
```

So the time complexity is:

```text
O(n²)
```

### If n doubles

If `n` becomes `2n`:

```text
(2n)² = 4n²
```

Therefore, **4 times more operations** are required.

---

## Block Y

```java
int mid = n / 2;

while (mid > 0)
    mid = mid / 2;
```

### Time Complexity: O(log n)

The value of `mid` is divided by `2` during every iteration:

```text
n/2 → n/4 → n/8 → n/16 → ...
```

The number of iterations grows logarithmically with `n`.

Therefore, the time complexity is:

```text
O(log n)
```

### If n doubles

If `n` changes from `n` to `2n`, the number of iterations increases by approximately **1 iteration**.

For example:

```text
n = 16
8 → 4 → 2 → 1 → 0
```

For:

```text
n = 32
16 → 8 → 4 → 2 → 1 → 0
```

Thus, doubling `n` does **not** double the number of operations. It adds approximately one iteration.

---

## Block Z

```java
for (int i = 0; i < n; i++)
    System.out.println(arr[i]);
```

### Time Complexity: O(n)

The loop executes once for every element from `0` to `n - 1`.

Therefore, there are `n` iterations.

The time complexity is:

```text
O(n)
```

### If n doubles

If `n` changes from `n` to `2n`, the number of iterations also doubles:

```text
2n / n = 2
```

Therefore, **2 times more operations** are required.

---

## Summary

| Block | Time Complexity | If n Doubles |
|---|---|---|
| X | O(n²) | 4× operations |
| Y | O(log n) | Approximately 1 extra iteration |
| Z | O(n) | 2× operations |