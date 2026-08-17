# Code Review


## Updated Code

```java
public double calculateCompoundAmount(double principal,double interestRate, int periods) {

    double compoundFactor = 1.0;
    for (int period = 0; period < periods; period++) {
        compoundFactor = compoundFactor * (1 + interestRate);
    }
    return principal * compoundFactor;
}
```

## Clean code violations in original code :
1) Method name "x" does not describe what method does.
2) Meaningless parameter name : "a" does not describe its utility.
3) Meaningless parameter name : "b" does not describe its utility.
4) Meaningless parameter name : "c" does not describe its utility.
5) Meaningless local variable : "r" does not describe its value and reduce readability.
6) Poor code formatting reduces readability.
*/