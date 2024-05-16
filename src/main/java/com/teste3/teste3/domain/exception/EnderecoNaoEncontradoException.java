package com.teste3.teste3.domain.exception;

public class EnderecoNaoEncontradoException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public EnderecoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public EnderecoNaoEncontradoException(Long enderecoId) {
        this(String.format("Não existe um cadastro de endereço com código %d", enderecoId));
    }
}
