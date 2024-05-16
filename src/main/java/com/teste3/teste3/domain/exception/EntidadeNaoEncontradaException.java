package com.teste3.teste3.domain.exception;

public class EntidadeNaoEncontradaException extends NegocioException{

    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
