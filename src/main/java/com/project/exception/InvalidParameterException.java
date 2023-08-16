package com.project.exception;

/**
 * Esto lo hago para manejar las excepciones mas personalizadas.
 * Tambien podria extender de otra clase que no sea RuntimeException, por ejemplo ResponseStatusException
 * o ExceptionHandler
 */
public class InvalidParameterException extends RuntimeException {
    public InvalidParameterException(String paramName, String message) {
        super("Parametro invalido '" + paramName + "': " + message);
    }

    public InvalidParameterException(String message) {
        super("Parametro invalido : " + message);
    }
}

