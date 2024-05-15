package com.teste3.teste3.repositories;

import com.teste3.teste3.domain.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findPessoaById(Long id);
}
