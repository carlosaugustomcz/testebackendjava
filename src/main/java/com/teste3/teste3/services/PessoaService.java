package com.teste3.teste3.services;

import com.teste3.teste3.domain.endereco.Endereco;
import com.teste3.teste3.domain.exception.PessoaNaoEncontradaException;
import com.teste3.teste3.domain.pessoa.Pessoa;
import com.teste3.teste3.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa){
        this.pessoaRepository.save(pessoa);
        return pessoa;
    }

    public Pessoa buscar(Long pessoaId) {
        return pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new PessoaNaoEncontradaException(pessoaId));
    }
}

