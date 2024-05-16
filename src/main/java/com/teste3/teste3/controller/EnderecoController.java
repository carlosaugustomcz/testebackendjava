package com.teste3.teste3.controller;

import com.teste3.teste3.domain.endereco.Endereco;
import com.teste3.teste3.domain.exception.EntidadeNaoEncontradaException;
import com.teste3.teste3.domain.exception.NegocioException;
import com.teste3.teste3.dtos.EnderecoDTO;
import com.teste3.teste3.repositories.EnderecoRepository;
import com.teste3.teste3.services.EnderecoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> listar(){
        return enderecoRepository.findAll();
    }

    @GetMapping("/{enderecoId}")
    public Endereco buscar(@PathVariable Long enderecoId) {
        try {
            return enderecoService.buscar(enderecoId);
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco adicionar(@RequestBody Endereco endereco) {
        return enderecoService.salvar(endereco);
    }

    @PutMapping("/{enderecoId}")
    public Endereco atualizar(@PathVariable Long enderecoId,
                            @RequestBody Endereco endereco) {
        Endereco enderecoAtual = enderecoService.buscar(enderecoId);
        // Long pessoaId = enderecoAtual.getPessoa().getId();

        BeanUtils.copyProperties(endereco, enderecoAtual, "id");

        try {
            return enderecoService.salvar(enderecoAtual);
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
}
