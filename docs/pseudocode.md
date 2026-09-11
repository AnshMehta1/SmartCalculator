# Square Root Pseudocode

FUNCTION squareRoot(number):

    IF number < 0 THEN
        THROW NegativeSquareRootException(
            "Cannot calculate square root of a negative number"
        )
    END IF

    RETURN Math.sqrt(number)

END FUNCTION