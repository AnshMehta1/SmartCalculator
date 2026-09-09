# Code Review Checklist

Before committing any code, I check the following:

1. Does the code compile successfully with `mvn clean compile`?
2. Do all automated tests pass with `mvn clean test`?
3. Does the code handle invalid input and expected exceptions correctly?
4. Is the code readable, well-structured, and consistent with the existing project style?
5. Are there unnecessary duplicate code, unused imports, or debugging statements?
6. Do class, method, and variable names clearly describe their purpose?
7. Have I reviewed the changes myself before committing?

## Self-Review

I reviewed the Phase 6 implementation against this checklist.

One improvement I made was replacing the previous division-by-zero behavior that returned `Double.NaN` with a dedicated `DivisionByZeroException`. I also added specific exceptions for modulo-by-zero and negative square-root operations.
