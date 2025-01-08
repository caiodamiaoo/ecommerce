package com.flong.ecommerce.exception;

public class EntidadeExistenteException extends RuntimeException {

    public EntidadeExistenteException(String mensagem) {
        super(mensagem);
    }
}
