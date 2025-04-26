package com.thiagoalencar.socialexperiment.exceptions;

public class ValidacaoDeNegocioException extends RuntimeException {

    public ValidacaoDeNegocioException(String message) {
        super(message);
    }

    public ValidacaoDeNegocioException(String message, Exception exception) {
        super(message, exception);
    }
}