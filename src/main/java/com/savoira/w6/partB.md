# Part B — Answers

## B1. What is the state of `t1` while it is inside `Thread.sleep(100)`?

**Answer:** `TIMED_WAITING`

`Thread.sleep(100)` places the thread into the `TIMED_WAITING` state for up to 100 milliseconds.

---

## B2. Can `Main | After join` print BEFORE both workers print `DONE`? Explain in one sentence.

**Answer:** No.

`t1.join()` and `t2.join()` block the main thread until both worker threads have terminated, so `Main | After join` can only print after both workers print `DONE`.

---

## B3. A colleague suggests replacing `t1.start()` with `t1.run()`. What is the consequence?

**Answer:** Calling `t1.run()` directly does **not** create or start a new thread; the `run()` method executes synchronously on the `main` thread.

Therefore, `Thread.currentThread().getName()` inside `run()` would return `main`, so the output would look like:

```text
main | STARTED
main | DONE
```

instead of:

```text
TransferWorker-1 | STARTED
TransferWorker-1 | DONE
```

The main thread would also be blocked during `Thread.sleep(100)` before continuing.
