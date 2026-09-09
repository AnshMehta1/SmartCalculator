package com.savoira.exceptions;

/**
 * Thrown when an attempt is made to calculate modulo by zero.
 */
public class ModuloByZeroException extends RuntimeException {

    /**
     * Creates a modulo-by-zero exception.
     *
     * @param message error message
     */
    public ModuloByZeroException(String message) {
        super(message);
    }
}