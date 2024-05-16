package com.teste3.teste3.services;

import com.teste3.teste3.domain.endereco.Endereco;
import com.teste3.teste3.domain.exception.EnderecoNaoEncontradoException;
import com.teste3.teste3.domain.pessoa.Pessoa;
import com.teste3.teste3.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    public Endereco salvar(Endereco endereco){

        Long pessoaId = endereco.getPessoa().getId();
        Pessoa pessoa = pessoaService.buscar(pessoaId);
        endereco.setPessoa(pessoa);

        return enderecoRepository.save(endereco);

    }

    public Endereco buscar(Long enderecoId) {
        return enderecoRepository.findById(enderecoId)
                 .orElseThrow(() -> new EnderecoNaoEncontradoException(enderecoId));
    }

}
