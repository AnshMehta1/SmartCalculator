package com.savoira.exceptions;

/**
 * Thrown when an attempt is made to divide by zero.
 */
public class DivisionByZeroException extends RuntimeException {

    /**
     * Creates a division-by-zero exception with the specified message.
     *
     * @param message error message
     */
    public DivisionByZeroException(String message) {
        super(message);
    }
}