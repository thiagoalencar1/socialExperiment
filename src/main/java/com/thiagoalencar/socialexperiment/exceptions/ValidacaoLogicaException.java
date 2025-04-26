package com.thiagoalencar.socialexperiment.exceptions;

public class ValidacaoLogicaException extends RuntimeException {

    public ValidacaoLogicaException(String message) {
        super(message);
    }

    public ValidacaoLogicaException(String message, Exception exception) {
        super(message, exception);
    }
}