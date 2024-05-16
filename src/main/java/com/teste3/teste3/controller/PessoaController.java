package com.teste3.teste3.controller;

import com.teste3.teste3.domain.exception.EntidadeNaoEncontradaException;
import com.teste3.teste3.domain.exception.NegocioException;
import com.teste3.teste3.domain.pessoa.Pessoa;
import com.teste3.teste3.dtos.PessoaDTO;
import com.teste3.teste3.repositories.PessoaRepository;
import com.teste3.teste3.services.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

    @RestController
    @RequestMapping("/pessoas")
    public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> listar(){

        List<PessoaDTO> pessoaDTOs = new ArrayList<PessoaDTO>();
        List<Pessoa> pessoas =  pessoaRepository.findAll();
        for (Pessoa pessoa : pessoas){
            PessoaDTO dto = new PessoaDTO(pessoa.getId(), pessoa.getNomeCompleto(), pessoa.getDataNascimento(), pessoa.getEndereco());

            pessoaDTOs.add(dto);
        }
        return new ResponseEntity<List<PessoaDTO>>(pessoaDTOs, HttpStatus.OK);
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<Pessoa> buscar(@PathVariable Long pessoaId) {
        Pessoa pessoa = pessoaService.buscar(pessoaId);
        return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa adicionar(@RequestBody Pessoa pessoa) {
        return pessoaService.salvar(pessoa);
    }

    @PutMapping("/{pessoaId}")
    public Pessoa atualizar(@PathVariable Long pessoaId,
                                  @RequestBody Pessoa pessoa) {
        Pessoa pessoaAtual = pessoaService.buscar(pessoaId);

        BeanUtils.copyProperties(pessoa, pessoaAtual, "id");

        try {
            return pessoaService.salvar(pessoaAtual);
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
}
