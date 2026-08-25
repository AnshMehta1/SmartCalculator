# Code Smells and Refactoring

## Code Smell 1: Poor Naming

The method name process and parameter name l are vague.
They do not communicate what the method actually does.

### Refactoring

Use descriptive names such as printLoansInPrincipalRange
and loans.

---

## Code Smell 2: Unnecessary Indexed Loop and Repeated Access

The original method uses an indexed loop even though the index is
not required. It also repeatedly accesses l.get(i).

### Refactored Method

```java
void printLoansInPrincipalRange(List<Loan> loans) {

    for (Loan loan : loans) {

        if (loan.principal > 500000 &&
            loan.principal < 2000000) {

            System.out.println(loan.loanId);
        }
    }
}