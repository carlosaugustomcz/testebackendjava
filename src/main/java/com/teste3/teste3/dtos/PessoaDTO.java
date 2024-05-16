package com.teste3.teste3.dtos;

import com.teste3.teste3.domain.endereco.Endereco;

import java.time.LocalDate;
import java.util.List;

public record PessoaDTO(Long id, String nomeCompleto, LocalDate dtNascimento, List<Endereco> enderecos) {

}
