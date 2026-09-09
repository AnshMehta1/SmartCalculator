package com.savoira.exceptions;

/**
 * Thrown when an attempt is made to calculate the square root
 * of a negative number.
 */
public class NegativeSquareRootException extends RuntimeException {

    /**
     * Creates a negative-square-root exception.
     *
     * @param message error message
     */
    public NegativeSquareRootException(String message) {
        super(message);
    }
}