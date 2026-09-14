START

SET balance = 10000
SET attempts = 0
SET maximumAttempts = 3

WHILE attempts < maximumAttempts

    INPUT withdrawal amount

    IF amount < 500 THEN
        DISPLAY "Withdrawal amount must be at least ₹500"
        attempts = attempts + 1
        CONTINUE
    END IF

    IF amount > 20000 THEN
        DISPLAY "Withdrawal amount cannot exceed ₹20,000"
        attempts = attempts + 1
        CONTINUE
    END IF

    IF amount is not a multiple of 500 THEN
        DISPLAY "Withdrawal amount must be a multiple of ₹500"
        attempts = attempts + 1
        CONTINUE
    END IF

    IF amount > balance THEN
        DISPLAY "Insufficient balance"
        attempts = attempts + 1
        CONTINUE
    END IF

    balance = balance - amount

    DISPLAY "Withdrawal successful"
    DISPLAY "New balance:", balance

    STOP

END WHILE

DISPLAY "Card locked."

END