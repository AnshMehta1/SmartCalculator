package com.savoira.exceptions;

/**
 * Thrown when an invalid calculator operation is requested.
 */
public class InvalidOperationException extends RuntimeException {

    /**
     * Creates an exception with the specified message.
     *
     * @param message error message
     */
    public InvalidOperationException(String message) {
        super(message);
    }
}