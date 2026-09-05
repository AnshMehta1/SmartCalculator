# Part A — Thread Creation & Lifecycle Trace

## Expected Output

The exact order of the two worker threads is **not guaranteed** because thread scheduling is controlled by the JVM/OS.

One valid output is:

```text
Main | Before start
TransferWorker-1 | STARTED
AuditLogger-1 | STARTED
AuditLogger-1 | DONE
TransferWorker-1 | DONE
Main | After join
```

### Important Ordering Guarantees

- `Main | Before start` is printed before either worker is started.
- `TransferWorker-1 | STARTED` appears before `TransferWorker-1 | DONE`.
- `AuditLogger-1 | STARTED` appears before `AuditLogger-1 | DONE`.
- `Main | After join` is printed last because `main` waits for both threads using `join()`.
- The relative order of the two worker threads is not deterministic.
